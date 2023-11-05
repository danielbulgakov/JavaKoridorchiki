package org.example.Common.Response;

import org.example.Common.Player;
import org.example.Server.GameModel.GameStates;

import java.util.ArrayList;

import java.util.ArrayList;

public class ServerResponse {
    private String content;
    private Player nextMove;
    private Player winner;
    private GameStates gameState;
    private ArrayList<Player> players;

    public ServerResponse(String content, Player nextMove, Player winner, GameStates gameState, ArrayList<Player> players) {
        this.content = content;
        this.nextMove = nextMove;
        this.winner = winner;
        this.gameState = gameState;
        this.players = players;
    }
    public ServerResponse() {
        this(null, null, null, null, null);
        players = new ArrayList<>();
    }

    public void listClear() {
        players.clear();
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Player getNextMove() {
        return this.nextMove;
    }

    public void setNextMove(Player nextMove) {
        this.nextMove = nextMove;
    }

    public Player getWinner() {
        return this.winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStates getGameState() {
        return this.gameState;
    }

    public void setGameState(GameStates gameState) {
        this.gameState = gameState;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}

