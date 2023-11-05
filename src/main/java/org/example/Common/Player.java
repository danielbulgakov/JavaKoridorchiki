package org.example.Common;

public class Player {
    private String name;
    private int wins;
    private int score;

    public Player(String name, int countWins, int score) {
        this.name = name;
        this.wins = countWins;
        this.score = score;
    }

    public Player(String name) {
        this.name = name;
        this.wins = 0;
        this.score = 0;
    }

    public void addWin() {
        this.wins += 1;
    }

    public void addScore(int scoreToAdd) {
        this.score += scoreToAdd;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return this.wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
