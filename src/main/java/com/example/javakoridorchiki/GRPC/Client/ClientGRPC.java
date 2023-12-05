package com.example.javakoridorchiki.GRPC.Client;

import GRPC.*;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.google.protobuf.StringValue;
import io.grpc.stub.StreamObserver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientGRPC {
    private static final Logger LOGGER = Logger.getLogger(ClientGRPC.class.getName());
    private final GameServiceGrpc.GameServiceBlockingStub gameServiceBlockingStub;
    private final GameServiceGrpc.GameServiceStub gameServiceStub;
    private static final int PORT = 3124;

    public static ClientInfo clientInfo;

    public ClientGRPC(String host, int port) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        gameServiceBlockingStub = GameServiceGrpc.newBlockingStub(managedChannel);
        gameServiceStub = GameServiceGrpc.newStub(managedChannel);
    }

    public RegisterResponse registerName(String name) {
        StringValue request = StringValue.newBuilder().setValue(name).build();
        RegisterResponse response = gameServiceBlockingStub.registerName(request);
        LOGGER.log(Level.INFO, "Response from server: " + response.getComment());
        return response;
    }

    public ServerMessage makeMove(int row, int column) {
        ClientMessage request = ClientMessage.newBuilder().setIdentity(clientInfo).setRow(row).setColumn(column).build();
        ServerMessage response = gameServiceBlockingStub.makeMove(request);
        LOGGER.log(Level.INFO, "Gor response from server");
        return response;
    }

    public ServerMessage updateInfo() {
        ServerMessage response = gameServiceBlockingStub.updateInfo(Empty.newBuilder().build());
        LOGGER.log(Level.INFO, "Gor response from server");
        return response;
    }

    public void subscribe(StreamObserver<ServerMessage> responseObject) {
        gameServiceStub.subscribe(Empty.newBuilder().build(), responseObject);
    }

    // *** Builder class for client ***

    private static ClientGRPC instance;

    public static class Builder {
        public ClientGRPC build() {
            if (instance == null) {
                instance = new ClientGRPC("localhost", PORT);
            }
            return instance;
        }
    }

    // *** End of builder class ***
}