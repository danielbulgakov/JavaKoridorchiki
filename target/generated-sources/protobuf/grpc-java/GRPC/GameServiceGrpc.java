package GRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: proto.proto")
public final class GameServiceGrpc {

  private GameServiceGrpc() {}

  public static final String SERVICE_NAME = "gRPC.GameService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      GRPC.RegisterResponse> getRegisterNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterName",
      requestType = com.google.protobuf.StringValue.class,
      responseType = GRPC.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      GRPC.RegisterResponse> getRegisterNameMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, GRPC.RegisterResponse> getRegisterNameMethod;
    if ((getRegisterNameMethod = GameServiceGrpc.getRegisterNameMethod) == null) {
      synchronized (GameServiceGrpc.class) {
        if ((getRegisterNameMethod = GameServiceGrpc.getRegisterNameMethod) == null) {
          GameServiceGrpc.getRegisterNameMethod = getRegisterNameMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, GRPC.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPC.RegisterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameServiceMethodDescriptorSupplier("RegisterName"))
              .build();
        }
      }
    }
    return getRegisterNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GRPC.ClientMessage,
      GRPC.ServerMessage> getMakeMoveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MakeMove",
      requestType = GRPC.ClientMessage.class,
      responseType = GRPC.ServerMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GRPC.ClientMessage,
      GRPC.ServerMessage> getMakeMoveMethod() {
    io.grpc.MethodDescriptor<GRPC.ClientMessage, GRPC.ServerMessage> getMakeMoveMethod;
    if ((getMakeMoveMethod = GameServiceGrpc.getMakeMoveMethod) == null) {
      synchronized (GameServiceGrpc.class) {
        if ((getMakeMoveMethod = GameServiceGrpc.getMakeMoveMethod) == null) {
          GameServiceGrpc.getMakeMoveMethod = getMakeMoveMethod =
              io.grpc.MethodDescriptor.<GRPC.ClientMessage, GRPC.ServerMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MakeMove"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPC.ClientMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPC.ServerMessage.getDefaultInstance()))
              .setSchemaDescriptor(new GameServiceMethodDescriptorSupplier("MakeMove"))
              .build();
        }
      }
    }
    return getMakeMoveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      GRPC.ServerMessage> getUpdateInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInfo",
      requestType = com.google.protobuf.Empty.class,
      responseType = GRPC.ServerMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      GRPC.ServerMessage> getUpdateInfoMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, GRPC.ServerMessage> getUpdateInfoMethod;
    if ((getUpdateInfoMethod = GameServiceGrpc.getUpdateInfoMethod) == null) {
      synchronized (GameServiceGrpc.class) {
        if ((getUpdateInfoMethod = GameServiceGrpc.getUpdateInfoMethod) == null) {
          GameServiceGrpc.getUpdateInfoMethod = getUpdateInfoMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, GRPC.ServerMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPC.ServerMessage.getDefaultInstance()))
              .setSchemaDescriptor(new GameServiceMethodDescriptorSupplier("UpdateInfo"))
              .build();
        }
      }
    }
    return getUpdateInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      GRPC.ServerMessage> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Subscribe",
      requestType = com.google.protobuf.Empty.class,
      responseType = GRPC.ServerMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      GRPC.ServerMessage> getSubscribeMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, GRPC.ServerMessage> getSubscribeMethod;
    if ((getSubscribeMethod = GameServiceGrpc.getSubscribeMethod) == null) {
      synchronized (GameServiceGrpc.class) {
        if ((getSubscribeMethod = GameServiceGrpc.getSubscribeMethod) == null) {
          GameServiceGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, GRPC.ServerMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GRPC.ServerMessage.getDefaultInstance()))
              .setSchemaDescriptor(new GameServiceMethodDescriptorSupplier("Subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GameServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameServiceStub>() {
        @java.lang.Override
        public GameServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameServiceStub(channel, callOptions);
        }
      };
    return GameServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameServiceBlockingStub>() {
        @java.lang.Override
        public GameServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameServiceBlockingStub(channel, callOptions);
        }
      };
    return GameServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GameServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameServiceFutureStub>() {
        @java.lang.Override
        public GameServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameServiceFutureStub(channel, callOptions);
        }
      };
    return GameServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service
   * </pre>
   */
  public static abstract class GameServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerName(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<GRPC.RegisterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterNameMethod(), responseObserver);
    }

    /**
     */
    public void makeMove(GRPC.ClientMessage request,
        io.grpc.stub.StreamObserver<GRPC.ServerMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getMakeMoveMethod(), responseObserver);
    }

    /**
     */
    public void updateInfo(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<GRPC.ServerMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateInfoMethod(), responseObserver);
    }

    /**
     */
    public void subscribe(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<GRPC.ServerMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                GRPC.RegisterResponse>(
                  this, METHODID_REGISTER_NAME)))
          .addMethod(
            getMakeMoveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GRPC.ClientMessage,
                GRPC.ServerMessage>(
                  this, METHODID_MAKE_MOVE)))
          .addMethod(
            getUpdateInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                GRPC.ServerMessage>(
                  this, METHODID_UPDATE_INFO)))
          .addMethod(
            getSubscribeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                GRPC.ServerMessage>(
                  this, METHODID_SUBSCRIBE)))
          .build();
    }
  }

  /**
   * <pre>
   * Service
   * </pre>
   */
  public static final class GameServiceStub extends io.grpc.stub.AbstractAsyncStub<GameServiceStub> {
    private GameServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServiceStub(channel, callOptions);
    }

    /**
     */
    public void registerName(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<GRPC.RegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void makeMove(GRPC.ClientMessage request,
        io.grpc.stub.StreamObserver<GRPC.ServerMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMakeMoveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateInfo(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<GRPC.ServerMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subscribe(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<GRPC.ServerMessage> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service
   * </pre>
   */
  public static final class GameServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GameServiceBlockingStub> {
    private GameServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public GRPC.RegisterResponse registerName(com.google.protobuf.StringValue request) {
      return blockingUnaryCall(
          getChannel(), getRegisterNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public GRPC.ServerMessage makeMove(GRPC.ClientMessage request) {
      return blockingUnaryCall(
          getChannel(), getMakeMoveMethod(), getCallOptions(), request);
    }

    /**
     */
    public GRPC.ServerMessage updateInfo(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getUpdateInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<GRPC.ServerMessage> subscribe(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service
   * </pre>
   */
  public static final class GameServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GameServiceFutureStub> {
    private GameServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.RegisterResponse> registerName(
        com.google.protobuf.StringValue request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.ServerMessage> makeMove(
        GRPC.ClientMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getMakeMoveMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GRPC.ServerMessage> updateInfo(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_NAME = 0;
  private static final int METHODID_MAKE_MOVE = 1;
  private static final int METHODID_UPDATE_INFO = 2;
  private static final int METHODID_SUBSCRIBE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GameServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GameServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_NAME:
          serviceImpl.registerName((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<GRPC.RegisterResponse>) responseObserver);
          break;
        case METHODID_MAKE_MOVE:
          serviceImpl.makeMove((GRPC.ClientMessage) request,
              (io.grpc.stub.StreamObserver<GRPC.ServerMessage>) responseObserver);
          break;
        case METHODID_UPDATE_INFO:
          serviceImpl.updateInfo((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<GRPC.ServerMessage>) responseObserver);
          break;
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<GRPC.ServerMessage>) responseObserver);
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

  private static abstract class GameServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GameServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GRPC.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GameService");
    }
  }

  private static final class GameServiceFileDescriptorSupplier
      extends GameServiceBaseDescriptorSupplier {
    GameServiceFileDescriptorSupplier() {}
  }

  private static final class GameServiceMethodDescriptorSupplier
      extends GameServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GameServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GameServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GameServiceFileDescriptorSupplier())
              .addMethod(getRegisterNameMethod())
              .addMethod(getMakeMoveMethod())
              .addMethod(getUpdateInfoMethod())
              .addMethod(getSubscribeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
