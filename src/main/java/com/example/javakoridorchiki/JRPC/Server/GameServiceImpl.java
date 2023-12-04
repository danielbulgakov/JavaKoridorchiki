package com.example.javakoridorchiki.JRPC.Server;

import JRPC.GameServiceGrpc;
import JRPC.ServerMessage;
import com.example.javakoridorchiki.JRPC.Server.Game.GameCore;
import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;
import io.grpc.stub.StreamObserver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameServiceImpl extends GameServiceGrpc.GameServiceImplBase {
    private static final Logger LOGGER = Logger.getLogger(GameServiceImpl.class.getName());
    private final GameCore gc = new GameCore.Builder().build();

    // ====================================================
    // Handle new connections to the server
    // ====================================================
    private static final int MAX_NUM_PLAYERS = 2;
    @Override
    public void registerName(StringValue request, StreamObserver<JRPC.RegisterResponse> responseObserver) {
        String playerName = request.getValue();
        JRPC.RegisterResponse.Builder response = JRPC.RegisterResponse.newBuilder();
        if (gc.clients.stream().anyMatch(clientInfo -> clientInfo.getName().equals(playerName))) {
            response.setConnected(false).setComment("DECLINE: Player with this name already exists");
        } else if (gc.clients.size() >= MAX_NUM_PLAYERS) {
            response.setConnected(false).setComment("DECLINE: Maximum number of players reached");
        } else {
            JRPC.ClientInfo clientInfo = JRPC.ClientInfo.newBuilder().setName(playerName).build();
            gc.addClient(clientInfo);
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
    public void makeMove(JRPC.ClientMessage request, StreamObserver<JRPC.ServerMessage> responseObserver) {
        gc.makeMove(request.getRow(), request.getColumn(), request.getIdentity());
        responseObserver.onNext(getUpdatedResponseBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateInfo(Empty request, StreamObserver<JRPC.ServerMessage> responseObserver) {
        responseObserver.onNext(getUpdatedResponseBuilder().build());
        responseObserver.onCompleted();
    }

    // ====================================================
    // Unified server message builder
    // ====================================================
    JRPC.ServerMessage.Builder getUpdatedResponseBuilder() {
        JRPC.ServerMessage.Builder response = JRPC.ServerMessage.newBuilder();

        for (int i = 0; i < gc.field.length; i++) {
            JRPC.ServerMessage.Field.Builder fieldBuilder = JRPC.ServerMessage.Field.newBuilder();
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