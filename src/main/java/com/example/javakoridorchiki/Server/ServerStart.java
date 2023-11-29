package com.example.javakoridorchiki.Server;

import com.example.javakoridorchiki.Common.SocketWrapper;
import com.example.javakoridorchiki.Server.Game.GameCore;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerStart {
    private static final Logger LOGGER = Logger.getLogger(GameCore.class.getName());
    private final int port = 3124;
    private final int numberOfPlayers = 2;
    private InetAddress ip = null;
    private final ExecutorService service = Executors.newFixedThreadPool(numberOfPlayers);
    private final static ArrayList<ServerClient> clientArrayList = new ArrayList<>();
    private int tries = 0;

    private final GameCore gc = new GameCore.Builder().build();

    public void broadcast() {
        clientArrayList.forEach(ServerClient::update);
    }
    public void serverStart(){
        ServerSocket ss;
        try {
            ip = InetAddress.getLocalHost();
            ss = new ServerSocket(port, 2, ip);
            LOGGER.log(Level.INFO, "Server start");

            while(true)
            {
                Socket socket = ss.accept();
                SocketWrapper sw = new SocketWrapper(socket);

                String response = sw.getData();

                if (tryAddClient(sw, response)) {
                    LOGGER.log(Level.INFO, "Login: " + response + " Connected");
                } else {
                    sw.close();
                }
            }

        } catch (IOException ignored) {}
    }

    private boolean tryAddClient(SocketWrapper sw, String name) {

        if (clientArrayList.size() >= numberOfPlayers) {
            sw.writeData("Maximum number of connections exceeded");
            return false;
        }
        if (clientArrayList.isEmpty() ||
                clientArrayList.stream()
                        .filter(client -> client.getClientInfo().getName().equals(name))
                        .findFirst()
                        .orElse(null) == null) {
            sw.writeData("ACCEPT");
            ServerClient c = new ServerClient(sw, this, name);
            clientArrayList.add(c);
            service.submit(c);
            LOGGER.log(Level.INFO, "Response: ACCEPT");
            return true;
        }

        int maxTries = 10;
        if (tries++ < maxTries) {
            sw.writeData("Already have player with that name");
            LOGGER.log(Level.INFO, "Response: DECLINE");
            tryAddClient(sw, sw.getData());
        } else {
            sw.writeData("Max number of tries exceeded");
            return false;
        }
        tries = 0;
        return true;
    }

    public static void main(String[] args) {
        new ServerStart().serverStart();
    }
}
