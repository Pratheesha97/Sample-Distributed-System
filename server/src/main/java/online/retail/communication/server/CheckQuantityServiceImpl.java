package online.retail.communication.server;

import io.grpc.stub.StreamObserver;
import online.retail.communication.grpc.generated.CheckQuantityRequest;
import online.retail.communication.grpc.generated.CheckQuantityResponse;
import online.retail.communication.grpc.generated.CheckQuantityServiceGrpc;

public class CheckQuantityServiceImpl extends CheckQuantityServiceGrpc.CheckQuantityServiceImplBase {

    private OnlineRetailServer server;

    public CheckQuantityServiceImpl(OnlineRetailServer server){
        this.server = server;
    }

    @Override
    public void checkQuantity(CheckQuantityRequest request,
                              StreamObserver<CheckQuantityResponse> responseObserver) {

        String productName = request.getProductName();
        System.out.println("Request received..");
        int quantity = getProductQuantity(productName);
        CheckQuantityResponse response = CheckQuantityResponse
                .newBuilder()
                .setQuantity(quantity)
                .build();
        System.out.println("Responding, quantity for product " + productName + " is " + quantity);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private int getProductQuantity(String productName) {
        return server.getProductQuantity(productName);
    }
}
