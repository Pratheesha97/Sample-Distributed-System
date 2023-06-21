package online.retail.communication.server;

import ds.tutorials.synchronization.DistributedLock;
import ds.tutorials.synchronization.DistributedTx;
import ds.tutorials.synchronization.DistributedTxCoordinator;
import ds.tutorials.synchronization.DistributedTxParticipant;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class OnlineRetailServer {
    private DistributedLock leaderLock;
    private AtomicBoolean isLeader = new AtomicBoolean(false);
    private byte[] leaderData;
    private int serverPort;
    private Map<String, Integer> products = new HashMap();

    DistributedTx addStockTransaction;
    DistributedTx placeOrderTransaction;
    AddStockServiceImpl addStockService;
    CheckQuantityServiceImpl checkQuantityService;
    PlaceOrderServiceImpl placeOrderService;

    public static String buildServerData(String IP, int port) {
        StringBuilder builder = new StringBuilder();
        builder.append(IP).append(":").append(port);
        return builder.toString();
    }

    public OnlineRetailServer(String host, int port) throws InterruptedException, IOException, KeeperException {
        this.serverPort = port;
        leaderLock = new DistributedLock("OnlineRetailServerTestCluster", buildServerData(host, port));

        addStockService = new AddStockServiceImpl(this);
        checkQuantityService = new CheckQuantityServiceImpl(this);
        placeOrderService = new PlaceOrderServiceImpl(this);

        addStockTransaction = new DistributedTxParticipant(addStockService);
        placeOrderTransaction = new DistributedTxParticipant(placeOrderService);
    }

    private void tryToBeLeader() throws KeeperException, InterruptedException {
        Thread leaderCampaignThread = new Thread(new LeaderCampaignThread());
        leaderCampaignThread.start();
    }

    public DistributedTx getAddStockTransaction() {
        return addStockTransaction;
    }

    public DistributedTx getPlaceOrderTransaction() {
        return placeOrderTransaction;
    }

    public void startServer() throws IOException, InterruptedException, KeeperException {
        Server server = ServerBuilder
                .forPort(serverPort)
                .addService(checkQuantityService)
                .addService(addStockService)
                .addService(placeOrderService)
                .build();
        server.start();
        System.out.println("OnlineRetailServer Started and ready to accept requests on port " + serverPort);

        tryToBeLeader();
        server.awaitTermination();
    }

    public boolean isLeader() {
        return isLeader.get();
    }

    private synchronized void setCurrentLeaderData(byte[] leaderData) {
        this.leaderData = leaderData;
    }

    public synchronized String[] getCurrentLeaderData() {
        return new String(leaderData).split(":");
    }

    public void addNewStock(String productName, int value) {
        Integer currQuantity = products.get(productName);
        if (currQuantity != null ) {
            products.put(productName, currQuantity + value);
        } else {
            products.put(productName, value);
        }
    }

    public void checkout(String productName, int quantity) {
        Integer currQuantity = products.get(productName);
        products.put(productName, currQuantity - quantity);
    }

    public int getProductQuantity(String productName) {
        Integer value = products.get(productName);
        return (value != null) ? value : 0;
    }

    public List<String[]> getOthersData() throws KeeperException, InterruptedException {
        List<String[]> result = new ArrayList<>();
        List<byte[]> othersData = leaderLock.getOthersData();

        for (byte[] data : othersData) {
            String[] dataStrings = new String(data).split(":");
            result.add(dataStrings);
        }
        return result;
    }

    class LeaderCampaignThread implements Runnable {
        private byte[] currentLeaderData = null;
        @Override
        public void run() {
            System.out.println("Starting the leader Campaign");

            try {
                boolean leader = leaderLock.tryAcquireLock();

                while (!leader) {
                    byte[] leaderData = leaderLock.getLockHolderData();
                    if (currentLeaderData != leaderData) {
                        currentLeaderData = leaderData;
                        setCurrentLeaderData(currentLeaderData);
                    }
                    Thread.sleep(10000);
                    leader = leaderLock.tryAcquireLock();
                }
                currentLeaderData = null;
                beTheLeader();
            } catch (Exception e){
            }
        }
    }

    private void beTheLeader() {
        System.out.println("I got the leader lock. Now acting as primary");
        isLeader.set(true);
        addStockTransaction = new DistributedTxCoordinator(addStockService);
        placeOrderTransaction = new DistributedTxCoordinator(placeOrderService);
    }

    public static void main (String[] args) throws Exception{
        if (args.length != 1) {
            System.out.println("Usage executable-name <port>");
        }

        int serverPort = Integer.parseInt(args[0]);
        DistributedLock.setZooKeeperURL("localhost:2181");
        DistributedTx.setZooKeeperURL("localhost:2181");

        OnlineRetailServer server = new OnlineRetailServer("localhost", serverPort);
        server.startServer();
    }
}
