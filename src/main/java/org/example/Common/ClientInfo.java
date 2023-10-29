package org.example.Common;

public class ClientInfo {
    private String playerName;
    private int wins = 0;

    public ClientInfo (String _name) {
        playerName = _name;
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String _name) {
        this.playerName = _name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int _wins) {
        this.wins = _wins;
    }
}
