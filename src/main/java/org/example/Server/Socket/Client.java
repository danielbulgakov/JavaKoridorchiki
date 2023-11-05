package org.example.Server.Socket;

import com.google.gson.Gson;
import org.example.Common.Player;
import org.example.Common.Response.ClientResponse;
import org.example.Common.Response.ServerResponse;
import org.example.Common.SocketMessageWrapper;
import org.example.Server.GameModel.Model;
import org.example.Server.GameModel.ModelBuilder;


import java.io.IOException;

public class Client implements Runnable{
    private final Server server;
    private final SocketMessageWrapper smw;
    private final Player player;
    private final Gson gson = new Gson();
    private final Model model = ModelBuilder.build();

    public Client(SocketMessageWrapper smw, Server server, String name)  {
        this.smw = smw;
        this.server = server;
        this.player = new Player(name);
    }
    public String getPlayerName() {
        return player.getName();
    }

    public Player getPlayer() {
        return player;
    }

    public void sendInfoToClient() {
        try {
            ServerResponse sr = new ServerResponse();

            sr.setContent   (model.getContent());
            sr.setNextMove  (model.getNextMove());
            sr.setWinner    (model.getWinner());
            sr.setGameState (model.getGameState());
            sr.setPlayers   (model.getPlayers());

            smw.writeData(gson.toJson(sr));
        } catch (IOException ignored) {
        }
    }

    @Override
    public void run() {
        try {

            System.out.println("Client thread " + player.getName() + " started");

            // Broadcast new player added
            model.addPlayer(player);
//            Server.broadcast();

            while(true)
            {
                String s = smw.getData();
                System.out.println("Msg: " + s);

                ClientResponse msg = gson.fromJson(s, ClientResponse.class);

                model.makeMove(msg.getRow(), msg.getColumn(), player);

            }
        } catch (IOException ignored) {

        }
    }


}