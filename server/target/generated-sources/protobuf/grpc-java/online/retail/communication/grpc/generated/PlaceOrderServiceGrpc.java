package online.retail.communication.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: OnlineRetailService.proto")
public final class PlaceOrderServiceGrpc {

  private PlaceOrderServiceGrpc() {}

  public static final String SERVICE_NAME = "online.retail.communication.grpc.generated.PlaceOrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<online.retail.communication.grpc.generated.PlaceOrderRequest,
      online.retail.communication.grpc.generated.PlaceOrderResponse> getPlaceOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "placeOrder",
      requestType = online.retail.communication.grpc.generated.PlaceOrderRequest.class,
      responseType = online.retail.communication.grpc.generated.PlaceOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<online.retail.communication.grpc.generated.PlaceOrderRequest,
      online.retail.communication.grpc.generated.PlaceOrderResponse> getPlaceOrderMethod() {
    io.grpc.MethodDescriptor<online.retail.communication.grpc.generated.PlaceOrderRequest, online.retail.communication.grpc.generated.PlaceOrderResponse> getPlaceOrderMethod;
    if ((getPlaceOrderMethod = PlaceOrderServiceGrpc.getPlaceOrderMethod) == null) {
      synchronized (PlaceOrderServiceGrpc.class) {
        if ((getPlaceOrderMethod = PlaceOrderServiceGrpc.getPlaceOrderMethod) == null) {
          PlaceOrderServiceGrpc.getPlaceOrderMethod = getPlaceOrderMethod =
              io.grpc.MethodDescriptor.<online.retail.communication.grpc.generated.PlaceOrderRequest, online.retail.communication.grpc.generated.PlaceOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "placeOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  online.retail.communication.grpc.generated.PlaceOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  online.retail.communication.grpc.generated.PlaceOrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PlaceOrderServiceMethodDescriptorSupplier("placeOrder"))
              .build();
        }
      }
    }
    return getPlaceOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PlaceOrderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlaceOrderServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlaceOrderServiceStub>() {
        @java.lang.Override
        public PlaceOrderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlaceOrderServiceStub(channel, callOptions);
        }
      };
    return PlaceOrderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PlaceOrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlaceOrderServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlaceOrderServiceBlockingStub>() {
        @java.lang.Override
        public PlaceOrderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlaceOrderServiceBlockingStub(channel, callOptions);
        }
      };
    return PlaceOrderServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PlaceOrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlaceOrderServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlaceOrderServiceFutureStub>() {
        @java.lang.Override
        public PlaceOrderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlaceOrderServiceFutureStub(channel, callOptions);
        }
      };
    return PlaceOrderServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PlaceOrderServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void placeOrder(online.retail.communication.grpc.generated.PlaceOrderRequest request,
        io.grpc.stub.StreamObserver<online.retail.communication.grpc.generated.PlaceOrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPlaceOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPlaceOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                online.retail.communication.grpc.generated.PlaceOrderRequest,
                online.retail.communication.grpc.generated.PlaceOrderResponse>(
                  this, METHODID_PLACE_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class PlaceOrderServiceStub extends io.grpc.stub.AbstractAsyncStub<PlaceOrderServiceStub> {
    private PlaceOrderServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlaceOrderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlaceOrderServiceStub(channel, callOptions);
    }

    /**
     */
    public void placeOrder(online.retail.communication.grpc.generated.PlaceOrderRequest request,
        io.grpc.stub.StreamObserver<online.retail.communication.grpc.generated.PlaceOrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PlaceOrderServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<PlaceOrderServiceBlockingStub> {
    private PlaceOrderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlaceOrderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlaceOrderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public online.retail.communication.grpc.generated.PlaceOrderResponse placeOrder(online.retail.communication.grpc.generated.PlaceOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPlaceOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PlaceOrderServiceFutureStub extends io.grpc.stub.AbstractFutureStub<PlaceOrderServiceFutureStub> {
    private PlaceOrderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlaceOrderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlaceOrderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<online.retail.communication.grpc.generated.PlaceOrderResponse> placeOrder(
        online.retail.communication.grpc.generated.PlaceOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PLACE_ORDER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PlaceOrderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PlaceOrderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PLACE_ORDER:
          serviceImpl.placeOrder((online.retail.communication.grpc.generated.PlaceOrderRequest) request,
              (io.grpc.stub.StreamObserver<online.retail.communication.grpc.generated.PlaceOrderResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PlaceOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PlaceOrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return online.retail.communication.grpc.generated.OnlineRetailService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PlaceOrderService");
    }
  }

  private static final class PlaceOrderServiceFileDescriptorSupplier
      extends PlaceOrderServiceBaseDescriptorSupplier {
    PlaceOrderServiceFileDescriptorSupplier() {}
  }

  private static final class PlaceOrderServiceMethodDescriptorSupplier
      extends PlaceOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PlaceOrderServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PlaceOrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PlaceOrderServiceFileDescriptorSupplier())
              .addMethod(getPlaceOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
