package com.example.javakoridorchiki.Server;

import com.example.javakoridorchiki.Common.ClientInfo;
import com.example.javakoridorchiki.Common.SocketMessage.ClientMessage;
import com.example.javakoridorchiki.Common.SocketMessage.ServerMessage;
import com.example.javakoridorchiki.Common.SocketWrapper;
import com.example.javakoridorchiki.Server.Game.GameCore;
import com.google.gson.Gson;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerClient implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(GameCore.class.getName());
    private final ServerStart server;
    private final SocketWrapper sw;
    private final GameCore gc = new GameCore.Builder().build();
    private final Gson gson = new Gson();
    private final ClientInfo clientInfo;

    public ServerClient(SocketWrapper sw, ServerStart server, String name)  {
        this.sw = sw;
        this.server = server;
        this.clientInfo = new ClientInfo(name);
    }

    public void update() {
        ServerMessage sm = new ServerMessage();
        sm.setField(gc.getField());
        sm.setClients(gc.getClients());
        sm.setWinner(gc.getWinner());
        sm.setNextMoveBy(gc.getNextMoveBy());
        String messageJson = gson.toJson(sm);
        sw.writeData(messageJson);
    }

    public boolean isAlive() {
        return sw.isConnected();
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    @Override
    public void run() {
        try {
            gc.addClient(clientInfo);
            server.broadcast();

            // Continue receiving messages while the socket is connected and the thread isn't interrupted
            while (sw.isConnected()) {
                String s = sw.getData();
                if (s == null || s.isEmpty()) break;

                LOGGER.log(Level.INFO, "Received message: " + s);

                // Deserialize the JSON string back into a ClientMessage object
                ClientMessage msg = gson.fromJson(s, ClientMessage.class);

                // Check if the received message has valid coordinates before making a move
                if (msg.getRow() >= 0 && msg.getColumn() >= 0) {
                    gc.makeMove(msg.getRow(), msg.getColumn(), clientInfo);
                }

                // After handling the message, broadcast the update to all clients
                server.broadcast();

                // Bad implementation, if we got winner just reset game
                if (gc.getWinner() != null)  {
                    gc.resetGame();
                    server.broadcast();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // Perform resource cleanup here, such as closing sockets
            sw.close();
        }
    }
}
