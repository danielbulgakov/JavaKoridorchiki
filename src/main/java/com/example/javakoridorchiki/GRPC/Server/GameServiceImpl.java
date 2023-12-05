package com.example.javakoridorchiki.GRPC.Server;

import GRPC.GameServiceGrpc;
import GRPC.RegisterResponse;
import GRPC.ServerMessage;
import com.example.javakoridorchiki.GRPC.Server.Game.GameCore;
import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameServiceImpl extends GameServiceGrpc.GameServiceImplBase {
    private static final Logger LOGGER = Logger.getLogger(GameServiceImpl.class.getName());
    private final GameCore gc = new GameCore.Builder().build();

    private volatile boolean wasFieldModified = false;

    // ====================================================
    // Handle new connections to the server
    // ====================================================
    private static final int MAX_NUM_PLAYERS = 2;
    @Override
    public void registerName(StringValue request, StreamObserver<RegisterResponse> responseObserver) {
        String playerName = request.getValue();
        GRPC.RegisterResponse.Builder response = GRPC.RegisterResponse.newBuilder();
        if (gc.clients.stream().anyMatch(clientInfo -> clientInfo.getName().equals(playerName))) {
            response.setConnected(false).setComment("DECLINE: Player with this name already exists");
        } else if (gc.clients.size() >= MAX_NUM_PLAYERS) {
            response.setConnected(false).setComment("DECLINE: Maximum number of players reached");
        } else {
            GRPC.ClientInfo clientInfo = GRPC.ClientInfo.newBuilder().setName(playerName).build();
            gc.addClient(clientInfo);
            wasFieldModified = true;
            response.setConnected(true).setComment("ACCEPT").setIdentity(clientInfo);
            LOGGER.log(Level.INFO, "Client added, name = " + playerName);
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    // ====================================================
    // Handle game flow on the server
    // ====================================================
    @Override
    public void makeMove(GRPC.ClientMessage request, StreamObserver<GRPC.ServerMessage> responseObserver) {
        gc.makeMove(request.getRow(), request.getColumn(), request.getIdentity());
        wasFieldModified = true;
        responseObserver.onNext(getUpdatedResponseBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateInfo(Empty request, StreamObserver<GRPC.ServerMessage> responseObserver) {
        responseObserver.onNext(getUpdatedResponseBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void subscribe(Empty request, StreamObserver<GRPC.ServerMessage> responseObserver) {
        try {
            while (true) {
                if (!wasFieldModified) continue;
                GRPC.ServerMessage updateMessage = getUpdatedResponseBuilder().build();

                responseObserver.onNext(updateMessage);

                Thread.sleep(200);
                wasFieldModified = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            responseObserver.onCompleted();
        }
    }

    // ====================================================
    // Unified server message builder
    // ====================================================
    GRPC.ServerMessage.Builder getUpdatedResponseBuilder() {
        GRPC.ServerMessage.Builder response = GRPC.ServerMessage.newBuilder();

        for (int i = 0; i < gc.field.length; i++) {
            GRPC.ServerMessage.Field.Builder fieldBuilder = GRPC.ServerMessage.Field.newBuilder();
            for (int j = 0; j < gc.field[i].length; j++) {
                if (gc.field[i][j] == null) {
                    fieldBuilder.addCellType(ServerMessage.Field.CellType.Empty);
                } else {
                    fieldBuilder.addCellType(gc.field[i][j]);
                }
            }
            response.addField(fieldBuilder.build());
        }

        for (ClientInfoWrapper clientInfoWrapper : gc.clients) {
            response.addClients(clientInfoWrapper.getClientInfo());
        }

        if (gc.winner != null) {
            response.setWinner(gc.winner.getClientInfo());
        }

        if (gc.nextMoveBy != null) {
            response.setNextMoveBy(gc.nextMoveBy.getClientInfo());
        }

        return response;
    }
}