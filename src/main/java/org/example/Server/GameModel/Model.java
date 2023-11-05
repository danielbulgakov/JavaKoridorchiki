package org.example.Server.GameModel;

import org.example.Common.Player;
import org.example.Common.Response.ServerResponse;
import org.example.Server.GameCore.GameField;
import org.example.Server.Socket.Server;
import org.example.Common.Move;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Model extends ServerResponse {
    // Variables to be stored in model
    private GameField field = new GameField(6, 5, getPlayers());

    // Game Functional methods
    public void init() {
        setGameState(GameStates.WaitingForPlayers);
    }

    public void makeMove(Move m) {
        field.tryMakeMove(m.getRow(), m.getColumn(), m.getPlayer());
    }

    public void makeMove(int row, int column, Player p) {
        System.out.println("wow");
        if (!movePreCheckValid()) return;

        if (p != getNextMove()) {
            setContent("Next move making " + p.getName());
            Server.broadcast();
        }

        field.tryMakeMove(row, column, p);

        after();
    }

    public boolean movePreCheckValid() {
        if (getPlayers().size() < 2)  {
            setContent("Waiting for players");
            Server.broadcast();
            return false;
        }
        if (field.isGameEnded()) {
            setContent("Game ended");
            setGameState(GameStates.Ended);
            setWinner(getPlayers().stream()
                    .max(Comparator.comparingInt(Player::getScore))
                    .orElse(null));
            Server.broadcast();
        }
        return true;
    }

    public void after() {
        if (field.isGameEnded()) {
            setContent(field.toString());
            setGameState(GameStates.Ended);
            Player winner = getPlayers().stream()
                    .max(Comparator.comparingInt(Player::getScore))
                    .orElse(null);
            if (winner != null) {
                winner.addWin();
            }
            setWinner(winner);
        } else {
            setContent(field.toString());
            setGameState(GameStates.Running);
            setWinner(null);
            setNextMove(getPlayers().get((getPlayers().indexOf(getNextMove()) + 1) % getPlayers().size()));
        }
        Server.broadcast();
    }

    public void reset() {
        field.clear();
        for (Player p : getPlayers()) {
            p.setScore(0);
        }
        setGameState(GameStates.Running);
    }

}
