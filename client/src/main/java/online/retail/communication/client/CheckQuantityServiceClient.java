package online.retail.communication.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import online.retail.communication.grpc.generated.CheckQuantityRequest;
import online.retail.communication.grpc.generated.CheckQuantityResponse;
import online.retail.communication.grpc.generated.CheckQuantityServiceGrpc;

import java.util.Scanner;

public class CheckQuantityServiceClient {
    private ManagedChannel channel = null;
    CheckQuantityServiceGrpc.CheckQuantityServiceBlockingStub clientStub = null;
    String host = null;
    int port = -1;

    public CheckQuantityServiceClient (String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initializeConnection () {
        System.out.println("Initializing Connecting to server at " + host + ":" +
                port);
        channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();
        clientStub = CheckQuantityServiceGrpc.newBlockingStub(channel);
    }
    public void closeConnection() {
        channel.shutdown();
    }

    public void processUserRequests() throws InterruptedException {
        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("\nEnter Product Name to check the quantity :");
            String productName = userInput.nextLine().trim();
            System.out.println("Requesting server to check the product quantity for " + productName.toString());
            CheckQuantityRequest request = CheckQuantityRequest
                    .newBuilder()
                    .setProductName(productName)
                    .build();
            CheckQuantityResponse response = clientStub.checkQuantity(request);
            System.out.printf("Product quantity is " + response.getQuantity());
            Thread.sleep(1000);
        }
    }
}
