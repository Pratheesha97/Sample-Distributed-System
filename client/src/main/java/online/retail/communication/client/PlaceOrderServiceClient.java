package online.retail.communication.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import online.retail.communication.grpc.generated.*;

import java.util.Scanner;

public class PlaceOrderServiceClient {
	private ManagedChannel channel = null;
	PlaceOrderServiceGrpc.PlaceOrderServiceBlockingStub clientStub = null;
	String host = null;
	int port = -1;

	public PlaceOrderServiceClient (String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void initializeConnection () {
		System.out.println("Initializing Connecting to server at " + host + ":" +
				port);
		channel = ManagedChannelBuilder.forAddress("localhost", port)
				.usePlaintext()
				.build();
		clientStub = PlaceOrderServiceGrpc.newBlockingStub(channel);
	}
	public void closeConnection() {
		channel.shutdown();
	}

	public void processUserRequests() throws InterruptedException {
		while (true) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("\nEnter Product Name, quantity to checkout :");
			String input[] = userInput.nextLine().trim().split(",");
			String productName = input[0];
			int quantity = Integer.parseInt(input[1]);
			System.out.println("Requesting server to checkout a quantity of " + quantity + " items from " + productName.toString());
			PlaceOrderRequest request = PlaceOrderRequest
					.newBuilder()
					.setProductName(productName)
					.setQuantity(quantity)
					.setIsSentByPrimary(false)
					.build();
			PlaceOrderResponse response = clientStub.placeOrder(request);
			System.out.printf("Transaction Status " + (response.getStatus() ? "Successful" : "Failed"));
			Thread.sleep(1000);
		}
	}
}
