package online.retail.communication.server;

import ds.tutorials.synchronization.DistributedTxCoordinator;
import ds.tutorials.synchronization.DistributedTxListener;
import ds.tutorials.synchronization.DistributedTxParticipant;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import online.retail.communication.grpc.generated.*;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PlaceOrderServiceImpl extends PlaceOrderServiceGrpc.PlaceOrderServiceImplBase implements DistributedTxListener {
	private ManagedChannel channel = null;
	PlaceOrderServiceGrpc.PlaceOrderServiceBlockingStub clientStub = null;
	private OnlineRetailServer server;

	private HashMap<String, Integer> tempDataHolder;
	private boolean transactionStatus = false;

	public PlaceOrderServiceImpl(OnlineRetailServer server){
		this.server = server;
	}

	private void startDistributedTx(String productName, int quantity) {
		try {
			server.getPlaceOrderTransaction().start(productName, String.valueOf(UUID.randomUUID()));
			tempDataHolder = new HashMap<String, Integer>();
			tempDataHolder.put(productName, quantity);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void placeOrder(PlaceOrderRequest request,
						   StreamObserver<PlaceOrderResponse> responseObserver) {

		String productName = request.getProductName();
		int quantity = request.getQuantity();
		if (server.isLeader()){
			// Act as primary
			try {
				System.out.println("Updating product quantity as Primary");
				startDistributedTx(productName, quantity);
				updateSecondaryServers(productName, quantity);
				System.out.println("going to perform");
				if (quantity !=0 && quantity < server.getProductQuantity(productName)) {
					((DistributedTxCoordinator)server.getPlaceOrderTransaction()).perform();
				} else if (quantity!=0){
					System.out.println("Sorry! sufficient stock of "+ productName +" is currently not available");
					((DistributedTxCoordinator)server.getPlaceOrderTransaction()).sendGlobalAbort();
				} else {
					((DistributedTxCoordinator)server.getPlaceOrderTransaction()).sendGlobalAbort();
				}
			} catch (Exception e) {
				System.out.println("Error while updating the product quantity " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			// Act As Secondary
			if (request.getIsSentByPrimary()) {
				System.out.println("Updating product quantity on secondary, on Primary's command");
				startDistributedTx(productName, quantity);
				if (quantity !=0 && quantity < server.getProductQuantity(productName)) {
					((DistributedTxParticipant)server.getPlaceOrderTransaction()).voteCommit();
				} else if (quantity!=0){
					System.out.println("Sorry! sufficient stock of "+ productName +" is currently not available");
					((DistributedTxParticipant)server.getPlaceOrderTransaction()).voteAbort();
				} else {
					((DistributedTxParticipant)server.getPlaceOrderTransaction()).voteAbort();
				}
			} else {
				PlaceOrderResponse response = callPrimary(productName, quantity);
				if (response.getStatus()) {
					transactionStatus = true;
				}
			}
		}
		PlaceOrderResponse response = PlaceOrderResponse
				.newBuilder()
				.setStatus(transactionStatus)
				.build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	private void checkoutItems() {
		if (tempDataHolder.size()!=0) {
			String productName = tempDataHolder.entrySet().iterator().next().getKey();
			int quantity = tempDataHolder.get(productName);
			server.checkout(productName, quantity);
			System.out.println("Product " + productName + " updated to quantity " + quantity + " committed");
			tempDataHolder = null;
		}
	}

	private PlaceOrderResponse callServer(String productName, int quantity, boolean isSentByPrimary, String IPAddress,
										int port) {
		System.out.println("Call Server " + IPAddress + ":" + port);
		channel = ManagedChannelBuilder.forAddress(IPAddress, port)
				.usePlaintext()
				.build();
		clientStub = PlaceOrderServiceGrpc.newBlockingStub(channel);

		PlaceOrderRequest request = PlaceOrderRequest
				.newBuilder()
				.setProductName(productName)
				.setQuantity(quantity)
				.setIsSentByPrimary(isSentByPrimary)
				.build();
		PlaceOrderResponse response = clientStub.placeOrder(request);
		return response;
	}

	private PlaceOrderResponse callPrimary(String productName, int quantity) {
		System.out.println("Calling Primary server");
		String[] currentLeaderData = server.getCurrentLeaderData();
		String IPAddress = currentLeaderData[0];
		int port = Integer.parseInt(currentLeaderData[1]);
		return callServer(productName, quantity, false, IPAddress, port);
	}

	private void updateSecondaryServers(String productName, int quantity) throws KeeperException, InterruptedException {
		System.out.println("Updating other servers");
		List<String[]> othersData = server.getOthersData();
		for (String[] data : othersData) {
			String IPAddress = data[0];
			int port = Integer.parseInt(data[1]);
			callServer(productName, quantity, true, IPAddress, port);
		}
	}

	@Override
	public void onGlobalCommit() {
		checkoutItems();
	}

	@Override
	public void onGlobalAbort() {
		tempDataHolder = null;
		System.out.println("Transaction Aborted by the Coordinator");
	}
}
