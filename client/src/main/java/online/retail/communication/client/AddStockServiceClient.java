package online.retail.communication.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import online.retail.communication.grpc.generated.AddStockRequest;
import online.retail.communication.grpc.generated.AddStockResponse;
import online.retail.communication.grpc.generated.AddStockServiceGrpc;

import java.util.Scanner;

public class AddStockServiceClient {
    private ManagedChannel channel = null;
    AddStockServiceGrpc.AddStockServiceBlockingStub clientStub = null;
    String host = null;
    int port = -1;

    public AddStockServiceClient (String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initializeConnection () {
        System.out.println("Initializing Connecting to server at " + host + ":" +
                port);
        channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();
        clientStub = AddStockServiceGrpc.newBlockingStub(channel);
    }
    public void closeConnection() {
        channel.shutdown();
    }

    public void processUserRequests() throws InterruptedException {
        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("\nEnter Product Name, quantity to set the quantity :");
            String input[] = userInput.nextLine().trim().split(",");
            String productName = input[0];
            int quantity = Integer.parseInt(input[1]);
            System.out.println("Requesting server to set the product quantity to " + quantity + " for " + productName.toString());
            AddStockRequest request = AddStockRequest
                    .newBuilder()
                    .setProductName(productName)
                    .setValue(quantity)
                    .setIsSentByPrimary(false)
                    .build();
            AddStockResponse response = clientStub.addStock(request);
            System.out.printf("Transaction Status " + (response.getStatus() ? "Successful" : "Failed"));
            Thread.sleep(1000);
        }
    }
}
