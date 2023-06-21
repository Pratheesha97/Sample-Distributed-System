package online.retail.communication.server;

import ds.tutorials.synchronization.DistributedTxCoordinator;
import ds.tutorials.synchronization.DistributedTxListener;
import ds.tutorials.synchronization.DistributedTxParticipant;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import online.retail.communication.grpc.generated.AddStockRequest;
import online.retail.communication.grpc.generated.AddStockResponse;
import online.retail.communication.grpc.generated.AddStockServiceGrpc;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class AddStockServiceImpl extends AddStockServiceGrpc.AddStockServiceImplBase implements DistributedTxListener {
    private ManagedChannel channel = null;
    AddStockServiceGrpc.AddStockServiceBlockingStub clientStub = null;
    private OnlineRetailServer server;

    private HashMap<String, Integer> tempDataHolder;
    private boolean transactionStatus = false;

    public AddStockServiceImpl(OnlineRetailServer server){
        this.server = server;
    }

    private void startDistributedTx(String productName, int value) {
        try {
            server.getAddStockTransaction().start(productName, String.valueOf(UUID.randomUUID()));
            tempDataHolder = new HashMap<String, Integer>();
            tempDataHolder.put(productName, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStock(AddStockRequest request,
                         StreamObserver<AddStockResponse> responseObserver) {

        String productName = request.getProductName();
        int value = request.getValue();
        if (server.isLeader()){
            // Act as primary
            try {
                System.out.println("Updating product quantity as Primary");
                startDistributedTx(productName, value);
                updateSecondaryServers(productName, value);
                System.out.println("going to perform");
                if (value > 0){
                    ((DistributedTxCoordinator)server.getAddStockTransaction()).perform();
                } else {
                    ((DistributedTxCoordinator)server.getAddStockTransaction()).sendGlobalAbort();
                }
            } catch (Exception e) {
                System.out.println("Error while updating the product quantity " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Act As Secondary
            if (request.getIsSentByPrimary()) {
                System.out.println("Updating product quantity on secondary, on Primary's command");
                startDistributedTx(productName, value);
                if (value > 0) {
                    ((DistributedTxParticipant)server.getAddStockTransaction()).voteCommit();
                } else {
                    ((DistributedTxParticipant)server.getAddStockTransaction()).voteAbort();
                }
            } else {
                AddStockResponse response = callPrimary(productName, value);
                if (response.getStatus()) {
                    transactionStatus = true;
                }
            }
        }
        AddStockResponse response = AddStockResponse
                .newBuilder()
                .setStatus(transactionStatus)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void addQuantity() {
        if (tempDataHolder.size()!=0) {
            String productName = tempDataHolder.entrySet().iterator().next().getKey();
            int value = tempDataHolder.get(productName);
            server.addNewStock(productName, value);
            System.out.println("Product " + productName + " updated to quantity " + value + " committed");
            tempDataHolder = null;
        }
    }

    private AddStockResponse callServer(String productName, int value, boolean isSentByPrimary, String IPAddress,
                                        int port) {
        System.out.println("Call Server " + IPAddress + ":" + port);
        channel = ManagedChannelBuilder.forAddress(IPAddress, port)
                .usePlaintext()
                .build();
        clientStub = AddStockServiceGrpc.newBlockingStub(channel);

        AddStockRequest request = AddStockRequest
                .newBuilder()
                .setProductName(productName)
                .setValue(value)
                .setIsSentByPrimary(isSentByPrimary)
                .build();
        AddStockResponse response = clientStub.addStock(request);
        return response;
    }

    private AddStockResponse callPrimary(String productName, int value) {
        System.out.println("Calling Primary server");
        String[] currentLeaderData = server.getCurrentLeaderData();
        String IPAddress = currentLeaderData[0];
        int port = Integer.parseInt(currentLeaderData[1]);
        return callServer(productName, value, false, IPAddress, port);
    }

    private void updateSecondaryServers(String productName, int value) throws KeeperException, InterruptedException {
        System.out.println("Updating other servers");
        List<String[]> othersData = server.getOthersData();
        for (String[] data : othersData) {
            String IPAddress = data[0];
            int port = Integer.parseInt(data[1]);
            callServer(productName, value, true, IPAddress, port);
        }
    }

    @Override
    public void onGlobalCommit() {
        addQuantity();
    }

    @Override
    public void onGlobalAbort() {
        tempDataHolder = null;
        System.out.println("Transaction Aborted by the Coordinator");
    }
}
