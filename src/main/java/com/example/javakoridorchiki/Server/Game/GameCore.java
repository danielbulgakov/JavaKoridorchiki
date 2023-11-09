package com.example.javakoridorchiki.Server.Game;

import com.example.javakoridorchiki.Client.Client;
import com.example.javakoridorchiki.Common.ClientInfo;
import com.example.javakoridorchiki.Common.SocketMessage.ServerMessage;

import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.InputStream;

public class GameCore extends ServerMessage {
    private static final Logger LOGGER = Logger.getLogger(GameCore.class.getName());
    private GameField gameField;
    private static final Properties properties = new Properties();

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
    }

    public void addClient(ClientInfo client) {
        clients.add(client);
        if (clients.size() >= 2) {
            this.gameField = new GameField(Integer.parseInt(properties.getProperty("rows")),
                    Integer.parseInt(properties.getProperty("cols")), clients.get(0), clients.get(1));

            Random random = new Random();
            int randomPlayerIndex = random.nextInt(2);
            setNextMoveBy(clients.get(randomPlayerIndex));
        }
    }

    public synchronized boolean makeMove(int row, int column, ClientInfo client) {
        if (!client.equals(getNextMoveBy())) {
            LOGGER.log(Level.WARNING, "It's not this player's turn");
            return false;
        }
        int score = gameField.makeMove(row, column, client);

        if (score < 0) return false;

        client.addScore(score);
        setNextMoveBy(getNextPlayer());
        field = gameField.getField();
        checkWinner();

        return true;
    }

    private ClientInfo getNextPlayer() {
        return getClients().stream()
                .filter(c -> !c.equals(getNextMoveBy()))
                .findFirst()
                .orElse(null);
    }

    public synchronized void checkWinner() {
        ClientInfo winner = gameField.checkWinner();
        if (winner != null) {
            setWinner(winner);
            winner.addWins(1);
        }
    }

    public synchronized void resetGame() {
        gameField.clear();
        getClients().forEach(ClientInfo::clearScore);
        if (!getClients().isEmpty()) {
            setNextMoveBy(getWinner());
        }
        setWinner(null);
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