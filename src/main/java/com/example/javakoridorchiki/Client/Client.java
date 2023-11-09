package com.example.javakoridorchiki.Client;

import com.example.javakoridorchiki.Common.ClientInfo;
import com.example.javakoridorchiki.Common.SocketMessage.ClientMessage;
import com.example.javakoridorchiki.Common.SocketMessage.ServerMessage;
import com.example.javakoridorchiki.Common.SocketWrapper;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.javakoridorchiki.Server.Game.GameCore;
import com.example.javakoridorchiki.Web.Grid.GridController;
import com.example.javakoridorchiki.Web.Grid.IObserver;
import com.google.gson.Gson;

public class Client extends ServerMessage {
    private static final Logger LOGGER = Logger.getLogger(GameCore.class.getName());
    final int port = 3124;
    final Gson gson = new Gson();
    InetAddress ip = null;
    private int tries = 0;
    SocketWrapper sw;
    boolean isConnected = false;
    ClientInfo clientInfo;

    ArrayList<GridController> observers = new ArrayList<>();

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void init() {
        try {
            ip = InetAddress.getLocalHost();
            Socket socket = new Socket(ip, port);
            sw = new SocketWrapper(socket);
        } catch (IOException ignored) {}
    }

    public boolean isConnected() {
        return isConnected;
    }

    public String tryConnectWithNickName(String name) {
        String response;
        sw.writeData(name.trim());
        response = sw.getData();
        if (response.equals("ACCEPT")) {
            isConnected = true;
            clientInfo = new ClientInfo(name);
            run();
        }
        return response;
    }

    public void run() {
        Thread thread = new Thread(
                ()->
                {
                    while (true) {
                        String s = sw.getData();

                        LOGGER.log(Level.INFO, "Res: " + s);
                        Gson gson = new Gson();
                        ServerMessage sm = gson.fromJson(s, ServerMessage.class);

                        if (sm == null) break;

                        field = sm.getField();
                        clients = sm.getClients();
                        winner = sm.getWinner();
                        nextMoveBy = sm.getNextMoveBy();

                        for (IObserver o : observers) {
                            o.update();
                        }
                    }

                }
        );
        thread.start();
    }

    public void sendMove(int x, int y) {
        ClientMessage cm = new ClientMessage(x, y);
        sw.writeData(gson.toJson(cm));
    }


    public void addObserver(GridController gridController) {
        observers.add(gridController);
    }

    // *** Builder class for client ***

    private static Client instance;

    public static class Builder {
        public Client build() {
            if (instance == null) {
                instance = new Client();
            }
            return instance;
        }
    }

    // *** End of builder class ***

}
