package com.example.javakoridorchiki.JRPC.Server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerJRPC {
    private static final Logger LOGGER = Logger.getLogger(ServerJRPC.class.getName());
    private static final int PORT = 3124;

    public void serverStart() throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(PORT)
                .addService(new GameServiceImpl())
                .build();

        server.start();

        LOGGER.log(Level.INFO, "Server started");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down gRPC server since JVM is shutting down");
            server.shutdown();
            System.err.println("Server shuted down");
        }));

        server.awaitTermination();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new ServerJRPC().serverStart();
    }
}
