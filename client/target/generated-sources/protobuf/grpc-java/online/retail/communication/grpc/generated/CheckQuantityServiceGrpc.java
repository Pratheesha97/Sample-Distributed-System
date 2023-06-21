package online.retail.communication.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: OnlineRetailService.proto")
public final class CheckQuantityServiceGrpc {

  private CheckQuantityServiceGrpc() {}

  public static final String SERVICE_NAME = "online.retail.communication.grpc.generated.CheckQuantityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<online.retail.communication.grpc.generated.CheckQuantityRequest,
      online.retail.communication.grpc.generated.CheckQuantityResponse> getCheckQuantityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkQuantity",
      requestType = online.retail.communication.grpc.generated.CheckQuantityRequest.class,
      responseType = online.retail.communication.grpc.generated.CheckQuantityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<online.retail.communication.grpc.generated.CheckQuantityRequest,
      online.retail.communication.grpc.generated.CheckQuantityResponse> getCheckQuantityMethod() {
    io.grpc.MethodDescriptor<online.retail.communication.grpc.generated.CheckQuantityRequest, online.retail.communication.grpc.generated.CheckQuantityResponse> getCheckQuantityMethod;
    if ((getCheckQuantityMethod = CheckQuantityServiceGrpc.getCheckQuantityMethod) == null) {
      synchronized (CheckQuantityServiceGrpc.class) {
        if ((getCheckQuantityMethod = CheckQuantityServiceGrpc.getCheckQuantityMethod) == null) {
          CheckQuantityServiceGrpc.getCheckQuantityMethod = getCheckQuantityMethod =
              io.grpc.MethodDescriptor.<online.retail.communication.grpc.generated.CheckQuantityRequest, online.retail.communication.grpc.generated.CheckQuantityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "checkQuantity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  online.retail.communication.grpc.generated.CheckQuantityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  online.retail.communication.grpc.generated.CheckQuantityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CheckQuantityServiceMethodDescriptorSupplier("checkQuantity"))
              .build();
        }
      }
    }
    return getCheckQuantityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CheckQuantityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckQuantityServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckQuantityServiceStub>() {
        @java.lang.Override
        public CheckQuantityServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckQuantityServiceStub(channel, callOptions);
        }
      };
    return CheckQuantityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CheckQuantityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckQuantityServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckQuantityServiceBlockingStub>() {
        @java.lang.Override
        public CheckQuantityServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckQuantityServiceBlockingStub(channel, callOptions);
        }
      };
    return CheckQuantityServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CheckQuantityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CheckQuantityServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CheckQuantityServiceFutureStub>() {
        @java.lang.Override
        public CheckQuantityServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CheckQuantityServiceFutureStub(channel, callOptions);
        }
      };
    return CheckQuantityServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CheckQuantityServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkQuantity(online.retail.communication.grpc.generated.CheckQuantityRequest request,
        io.grpc.stub.StreamObserver<online.retail.communication.grpc.generated.CheckQuantityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckQuantityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckQuantityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                online.retail.communication.grpc.generated.CheckQuantityRequest,
                online.retail.communication.grpc.generated.CheckQuantityResponse>(
                  this, METHODID_CHECK_QUANTITY)))
          .build();
    }
  }

  /**
   */
  public static final class CheckQuantityServiceStub extends io.grpc.stub.AbstractAsyncStub<CheckQuantityServiceStub> {
    private CheckQuantityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckQuantityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckQuantityServiceStub(channel, callOptions);
    }

    /**
     */
    public void checkQuantity(online.retail.communication.grpc.generated.CheckQuantityRequest request,
        io.grpc.stub.StreamObserver<online.retail.communication.grpc.generated.CheckQuantityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckQuantityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CheckQuantityServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CheckQuantityServiceBlockingStub> {
    private CheckQuantityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckQuantityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckQuantityServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public online.retail.communication.grpc.generated.CheckQuantityResponse checkQuantity(online.retail.communication.grpc.generated.CheckQuantityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckQuantityMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CheckQuantityServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CheckQuantityServiceFutureStub> {
    private CheckQuantityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckQuantityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CheckQuantityServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<online.retail.communication.grpc.generated.CheckQuantityResponse> checkQuantity(
        online.retail.communication.grpc.generated.CheckQuantityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckQuantityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_QUANTITY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CheckQuantityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CheckQuantityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_QUANTITY:
          serviceImpl.checkQuantity((online.retail.communication.grpc.generated.CheckQuantityRequest) request,
              (io.grpc.stub.StreamObserver<online.retail.communication.grpc.generated.CheckQuantityResponse>) responseObserver);
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

  private static abstract class CheckQuantityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CheckQuantityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return online.retail.communication.grpc.generated.OnlineRetailService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CheckQuantityService");
    }
  }

  private static final class CheckQuantityServiceFileDescriptorSupplier
      extends CheckQuantityServiceBaseDescriptorSupplier {
    CheckQuantityServiceFileDescriptorSupplier() {}
  }

  private static final class CheckQuantityServiceMethodDescriptorSupplier
      extends CheckQuantityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CheckQuantityServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CheckQuantityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CheckQuantityServiceFileDescriptorSupplier())
              .addMethod(getCheckQuantityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
