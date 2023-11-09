package com.example.javakoridorchiki.Common.SocketMessage;

import com.example.javakoridorchiki.Common.CellType;
import com.example.javakoridorchiki.Common.ClientInfo;
import com.example.javakoridorchiki.Server.Game.GameCore;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ServerMessage {
    protected CellType[][] field;
    protected ArrayList<ClientInfo> clients;
    protected ClientInfo winner;
    protected ClientInfo nextMoveBy;

    // *** Get field size parameters for config.properties files ***
    private static final Properties properties = new Properties();

    static {
        try {
            InputStream inputStream = GameCore.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // *** End here ***

    // Gson requires a no-arg constructor for deserialization
    public ServerMessage() {
        this.field = new CellType[(Integer.parseInt(properties.getProperty("rows")) * 2 + 1)][(Integer.parseInt(properties.getProperty("cols")) * 2 + 1)];
        this.clients = new ArrayList<>();
        this.winner = null;
        this.nextMoveBy = null;
    }

    // Getters and setters for all fields to allow serialization and deserialization
    public CellType[][] getField() {
        return field;
    }

    public void setField(CellType[][] field) {
        this.field = field;
    }

    public ArrayList<ClientInfo> getClients() {
        return clients;
    }

    public void setClients(ArrayList<ClientInfo> clients) {
        this.clients = clients;
    }

    public ClientInfo getWinner() {
        return winner;
    }

    public void setWinner(ClientInfo winner) {
        this.winner = winner;
    }

    public ClientInfo getNextMoveBy() {
        return nextMoveBy;
    }

    public void setNextMoveBy(ClientInfo nextMoveBy) {
        this.nextMoveBy = nextMoveBy;
    }
}