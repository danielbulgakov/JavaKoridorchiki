package com.example.javakoridorchiki.Common;

import java.io.Serializable;

public class ClientInfo implements Serializable {
    private final String name;
    private int score = 0;
    private int wins = 0;

    public ClientInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getWins() {
        return wins;
    }

    public void clearScore() {
        score = 0;
    }

    public void clearWins() {
        wins = 0;
    }

    public void addWins(int w) {
        wins += w;
    }

    public void addScore(int s) {
        score += s;
    }
}
