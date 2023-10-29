package org.example.Server;

import org.example.Common.ClientInfo;
import org.example.Server.GameCore.GameField;
import org.example.Server.GameCore.Primitives.Move;
import org.example.Server.GameCore.Primitives.Pair;
import org.example.Server.Sockets.MainServer;

import java.util.ArrayList;
import java.util.Random;

public class ServerModel {
    private final ArrayList<ClientInfo> clientsArrayList = new ArrayList<>();
    private ArrayList<Integer> scoreArrayList;
    private final ArrayList<Pair<ClientInfo,Move>> moveQueue = new ArrayList<>();
    private int playerMove = 0;

    private GameField field;
    public ServerModel() {
    }

    public void init() {
        field = new GameField(5, 5);
        scoreArrayList = new ArrayList<>(2);

        // Random player makes move
        Random r = new Random();
        playerMove = (r.nextInt() % clientsArrayList.size() < 0) ? 0 : 1;
    }

    public void addClient (ClientInfo _clientInfo) {
        if (clientsArrayList.size() >= 2) return;
        clientsArrayList.add(_clientInfo);
    }

    public void makeMove (ClientInfo _client, int _row, int _col) {
        moveQueue.add(new Pair<>(_client, new Move(_row, _col)));
    }

    public void makeMove(ClientInfo _client, Move _move) {
        moveQueue.add(new Pair<>(_client, _move));
    }

    public void start(MainServer _mainServer) {
        if (clientsArrayList.isEmpty()) return;
        Thread thread = new Thread(
                () ->
                {
                    while (true) {
                    if (moveQueue.size() != 0) {
                    }

                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ignored) {
                        }
                    }
                }
        );
        thread.start();
    }

    public void reset() {
        clientsArrayList.clear();
        scoreArrayList.clear();
    }


}
