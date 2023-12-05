package com.example.javakoridorchiki.GRPC.Server.Game;

import GRPC.ClientInfo;
import GRPC.ServerMessage.Field.*;
import com.example.javakoridorchiki.GRPC.Server.ClientInfoWrapper;

import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameCore {
    private static final Logger LOGGER = Logger.getLogger(GameCore.class.getName());
    private GameField gameField;
    private static final Properties properties = new Properties();

    // ====================================================
    // Public field to gather server message object data
    // ====================================================

    public CellType[][] field;
    public CopyOnWriteArrayList<ClientInfoWrapper> clients;
    public ClientInfoWrapper winner;
    public ClientInfoWrapper nextMoveBy;

    // ====================================================

    static {
        try {
            InputStream inputStream = GameCore.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GameCore() {
        super();
        clients = new CopyOnWriteArrayList<>();
        field = new CellType[(Integer.parseInt(properties.getProperty("rows")) * 2 + 1)][(Integer.parseInt(properties.getProperty("cols")) * 2 + 1)];
    }

    public void addClient(ClientInfo client) {
        clients.add(new ClientInfoWrapper(client));
        if (clients.size() >= 2) {
            this.gameField = new GameField(Integer.parseInt(properties.getProperty("rows")),
                    Integer.parseInt(properties.getProperty("cols")), clients.get(0).getClientInfo(), clients.get(1).getClientInfo());

            Random random = new Random();
            int randomPlayerIndex = random.nextInt(2);
            nextMoveBy = clients.get(randomPlayerIndex);
        }
    }

    public synchronized boolean makeMove(int row, int column, ClientInfo client) {
        if (!client.getName().equals(nextMoveBy.getName())) {
            LOGGER.log(Level.WARNING, "It's not this player's turn");
            return false;
        }
        int score = gameField.makeMove(row, column, client);

        if (score < 0) return false;

        findClient(client.getName()).addScore(score);
        nextMoveBy = getNextPlayer();
        field = gameField.getField();
        checkWinner();

        return true;
    }

    public ClientInfoWrapper findClient(String name) {
        return clients.stream()
                .filter(client -> client.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private ClientInfoWrapper getNextPlayer() {
        return clients.stream()
                .filter(c -> !c.equals(nextMoveBy))
                .findFirst()
                .orElse(null);
    }

    public synchronized void checkWinner() {
        ClientInfo pendingClient = gameField.checkWinner();
        if (pendingClient != null) {
            winner = findClient(pendingClient.getName());
            winner.addWins(1);
        }
    }

    public synchronized void resetGame() {
        gameField.clear();
        clients.forEach(ClientInfoWrapper::clearScore);
        if (!clients.isEmpty()) {
            nextMoveBy = getNextPlayer();
        }
        winner = null;
    }

    // *** Builder class for client ***

    private static GameCore instance;

    public static class Builder {
        public GameCore build() {
            if (instance == null) {
                instance = new GameCore();
            }
            return instance;
        }
    }

    // *** End of builder class ***

}