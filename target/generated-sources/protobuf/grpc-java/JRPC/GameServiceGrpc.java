package JRPC;

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

  public static final String SERVICE_NAME = "JRPC.GameService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<JRPC.ClientMessage,
      JRPC.ServerMessage> getSendClientMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendClientMessage",
      requestType = JRPC.ClientMessage.class,
      responseType = JRPC.ServerMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<JRPC.ClientMessage,
      JRPC.ServerMessage> getSendClientMessageMethod() {
    io.grpc.MethodDescriptor<JRPC.ClientMessage, JRPC.ServerMessage> getSendClientMessageMethod;
    if ((getSendClientMessageMethod = GameServiceGrpc.getSendClientMessageMethod) == null) {
      synchronized (GameServiceGrpc.class) {
        if ((getSendClientMessageMethod = GameServiceGrpc.getSendClientMessageMethod) == null) {
          GameServiceGrpc.getSendClientMessageMethod = getSendClientMessageMethod =
              io.grpc.MethodDescriptor.<JRPC.ClientMessage, JRPC.ServerMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendClientMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  JRPC.ClientMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  JRPC.ServerMessage.getDefaultInstance()))
              .setSchemaDescriptor(new GameServiceMethodDescriptorSupplier("SendClientMessage"))
              .build();
        }
      }
    }
    return getSendClientMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<JRPC.ServerMessage,
      JRPC.ClientMessage> getSendServerMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendServerMessage",
      requestType = JRPC.ServerMessage.class,
      responseType = JRPC.ClientMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<JRPC.ServerMessage,
      JRPC.ClientMessage> getSendServerMessageMethod() {
    io.grpc.MethodDescriptor<JRPC.ServerMessage, JRPC.ClientMessage> getSendServerMessageMethod;
    if ((getSendServerMessageMethod = GameServiceGrpc.getSendServerMessageMethod) == null) {
      synchronized (GameServiceGrpc.class) {
        if ((getSendServerMessageMethod = GameServiceGrpc.getSendServerMessageMethod) == null) {
          GameServiceGrpc.getSendServerMessageMethod = getSendServerMessageMethod =
              io.grpc.MethodDescriptor.<JRPC.ServerMessage, JRPC.ClientMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendServerMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  JRPC.ServerMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  JRPC.ClientMessage.getDefaultInstance()))
              .setSchemaDescriptor(new GameServiceMethodDescriptorSupplier("SendServerMessage"))
              .build();
        }
      }
    }
    return getSendServerMessageMethod;
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
    public void sendClientMessage(JRPC.ClientMessage request,
        io.grpc.stub.StreamObserver<JRPC.ServerMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getSendClientMessageMethod(), responseObserver);
    }

    /**
     */
    public void sendServerMessage(JRPC.ServerMessage request,
        io.grpc.stub.StreamObserver<JRPC.ClientMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getSendServerMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendClientMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                JRPC.ClientMessage,
                JRPC.ServerMessage>(
                  this, METHODID_SEND_CLIENT_MESSAGE)))
          .addMethod(
            getSendServerMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                JRPC.ServerMessage,
                JRPC.ClientMessage>(
                  this, METHODID_SEND_SERVER_MESSAGE)))
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
    public void sendClientMessage(JRPC.ClientMessage request,
        io.grpc.stub.StreamObserver<JRPC.ServerMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendClientMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendServerMessage(JRPC.ServerMessage request,
        io.grpc.stub.StreamObserver<JRPC.ClientMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendServerMessageMethod(), getCallOptions()), request, responseObserver);
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
    public JRPC.ServerMessage sendClientMessage(JRPC.ClientMessage request) {
      return blockingUnaryCall(
          getChannel(), getSendClientMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public JRPC.ClientMessage sendServerMessage(JRPC.ServerMessage request) {
      return blockingUnaryCall(
          getChannel(), getSendServerMessageMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<JRPC.ServerMessage> sendClientMessage(
        JRPC.ClientMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getSendClientMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<JRPC.ClientMessage> sendServerMessage(
        JRPC.ServerMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getSendServerMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_CLIENT_MESSAGE = 0;
  private static final int METHODID_SEND_SERVER_MESSAGE = 1;

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
        case METHODID_SEND_CLIENT_MESSAGE:
          serviceImpl.sendClientMessage((JRPC.ClientMessage) request,
              (io.grpc.stub.StreamObserver<JRPC.ServerMessage>) responseObserver);
          break;
        case METHODID_SEND_SERVER_MESSAGE:
          serviceImpl.sendServerMessage((JRPC.ServerMessage) request,
              (io.grpc.stub.StreamObserver<JRPC.ClientMessage>) responseObserver);
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
      return JRPC.ServiceProto.getDescriptor();
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
              .addMethod(getSendClientMessageMethod())
              .addMethod(getSendServerMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
