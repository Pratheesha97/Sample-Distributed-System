package online.retail.communication.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: OnlineRetailService.proto")
public final class AddStockServiceGrpc {

  private AddStockServiceGrpc() {}

  public static final String SERVICE_NAME = "online.retail.communication.grpc.generated.AddStockService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<online.retail.communication.grpc.generated.AddStockRequest,
      online.retail.communication.grpc.generated.AddStockResponse> getAddStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addStock",
      requestType = online.retail.communication.grpc.generated.AddStockRequest.class,
      responseType = online.retail.communication.grpc.generated.AddStockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<online.retail.communication.grpc.generated.AddStockRequest,
      online.retail.communication.grpc.generated.AddStockResponse> getAddStockMethod() {
    io.grpc.MethodDescriptor<online.retail.communication.grpc.generated.AddStockRequest, online.retail.communication.grpc.generated.AddStockResponse> getAddStockMethod;
    if ((getAddStockMethod = AddStockServiceGrpc.getAddStockMethod) == null) {
      synchronized (AddStockServiceGrpc.class) {
        if ((getAddStockMethod = AddStockServiceGrpc.getAddStockMethod) == null) {
          AddStockServiceGrpc.getAddStockMethod = getAddStockMethod =
              io.grpc.MethodDescriptor.<online.retail.communication.grpc.generated.AddStockRequest, online.retail.communication.grpc.generated.AddStockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  online.retail.communication.grpc.generated.AddStockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  online.retail.communication.grpc.generated.AddStockResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AddStockServiceMethodDescriptorSupplier("addStock"))
              .build();
        }
      }
    }
    return getAddStockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AddStockServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddStockServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddStockServiceStub>() {
        @java.lang.Override
        public AddStockServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddStockServiceStub(channel, callOptions);
        }
      };
    return AddStockServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AddStockServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddStockServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddStockServiceBlockingStub>() {
        @java.lang.Override
        public AddStockServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddStockServiceBlockingStub(channel, callOptions);
        }
      };
    return AddStockServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AddStockServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddStockServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddStockServiceFutureStub>() {
        @java.lang.Override
        public AddStockServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddStockServiceFutureStub(channel, callOptions);
        }
      };
    return AddStockServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AddStockServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addStock(online.retail.communication.grpc.generated.AddStockRequest request,
        io.grpc.stub.StreamObserver<online.retail.communication.grpc.generated.AddStockResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddStockMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddStockMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                online.retail.communication.grpc.generated.AddStockRequest,
                online.retail.communication.grpc.generated.AddStockResponse>(
                  this, METHODID_ADD_STOCK)))
          .build();
    }
  }

  /**
   */
  public static final class AddStockServiceStub extends io.grpc.stub.AbstractAsyncStub<AddStockServiceStub> {
    private AddStockServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddStockServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddStockServiceStub(channel, callOptions);
    }

    /**
     */
    public void addStock(online.retail.communication.grpc.generated.AddStockRequest request,
        io.grpc.stub.StreamObserver<online.retail.communication.grpc.generated.AddStockResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddStockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AddStockServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AddStockServiceBlockingStub> {
    private AddStockServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddStockServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddStockServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public online.retail.communication.grpc.generated.AddStockResponse addStock(online.retail.communication.grpc.generated.AddStockRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddStockMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AddStockServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AddStockServiceFutureStub> {
    private AddStockServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddStockServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddStockServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<online.retail.communication.grpc.generated.AddStockResponse> addStock(
        online.retail.communication.grpc.generated.AddStockRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddStockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_STOCK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AddStockServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AddStockServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_STOCK:
          serviceImpl.addStock((online.retail.communication.grpc.generated.AddStockRequest) request,
              (io.grpc.stub.StreamObserver<online.retail.communication.grpc.generated.AddStockResponse>) responseObserver);
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

  private static abstract class AddStockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AddStockServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return online.retail.communication.grpc.generated.OnlineRetailService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AddStockService");
    }
  }

  private static final class AddStockServiceFileDescriptorSupplier
      extends AddStockServiceBaseDescriptorSupplier {
    AddStockServiceFileDescriptorSupplier() {}
  }

  private static final class AddStockServiceMethodDescriptorSupplier
      extends AddStockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AddStockServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AddStockServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AddStockServiceFileDescriptorSupplier())
              .addMethod(getAddStockMethod())
              .build();
        }
      }
    }
    return result;
  }
}
