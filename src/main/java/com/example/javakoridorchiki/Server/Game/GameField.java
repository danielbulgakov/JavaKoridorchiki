package com.example.javakoridorchiki.Server.Game;

import com.example.javakoridorchiki.Common.CellType;
import com.example.javakoridorchiki.Common.ClientInfo;

public class GameField {
    private final int rows, cols;
    private final CellType[][] field;
    private static final int maxSize = 15;

    private final ClientInfo player0;
    private final ClientInfo player1;

    public GameField(int rows, int columns, ClientInfo player0, ClientInfo player1) {
        this.rows = Math.min(rows, maxSize) * 2 + 1;
        this.cols = Math.min(columns, maxSize) * 2 + 1;
        this.field = new CellType[this.rows][this.cols];
        this.player0 = player0;
        this.player1 = player1;

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                field[i][j] = CellType.Empty;
            }
        }
    }

    public CellType[][] getField() {
        return field;
    }

    public void clear() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                field[i][j] = CellType.Empty;
            }
        }
    }

    public int makeMove(int row, int column, ClientInfo p) {
        int result = 0;
        CellType t = p == player0 ? CellType.Player0 : CellType.Player1;

        if (row < 0 || row >= rows) return -1;
        if (column < 0 || column >= cols) return -1;
        if (field[row][column] != CellType.Empty) return -1;
        // Add a move made by a player
        field[row][column] = t;

        // Find completed cells
        if (field[row][column] == t) {
            result += setCellCompleted(getValueInRange(row + 1,rows - 1), column, p);
            result += setCellCompleted(getValueInRange(row - 1, rows - 1), column, p);
            result += setCellCompleted(row, getValueInRange(column + 1, cols - 1), p);
            result += setCellCompleted(row, getValueInRange(column - 1, cols - 1), p);
        }

        return result;
    }

    private int setCellCompleted(int row, int column, ClientInfo p) {
        CellType s = p == player0 ? CellType.Player0 : CellType.Player1;
        if (isCellCompleted(row, column) && field[row][column] == CellType.Empty) {
            field[row][column] = s;
            return 1;
        }
        return 0;
    }
    private int getValueInRange(int value, int upperBound) {
        return Math.min(Math.max(value, 0), upperBound);
    }
    private boolean isCellCompleted(int row, int column) {
        // Check cells on same column
        if (field[getValueInRange(row - 1, rows - 1)][column] == CellType.Empty) return false;
        if (field[getValueInRange(row + 1, rows - 1)][column] == CellType.Empty) return false;
        // Check cells on same row
        if (field[row][getValueInRange(column - 1, cols - 1)] == CellType.Empty) return false;
        if (field[row][getValueInRange(column + 1, cols - 1)] == CellType.Empty) return false;

        return true;
    }

    public boolean isGameEnded() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i % 2 != 0 && j % 2 != 0) {
                    if (field[rows][cols] == CellType.Empty) return false;
                }
            }
        }
        return true;
    }

    public ClientInfo checkWinner() {
        for (int row = 1; row < rows; row+=2) {
            int player0AllScore= 0;
            int player1AllScore = 0;
            for (int col = 1; col < cols; col+=2) {
                if (field[row][col] == CellType.Empty) return null;
                player0AllScore += (field[row][col] == CellType.Player0) ? 1 : 0;
                player1AllScore += (field[row][col] == CellType.Player1) ? 1 : 0;
            }
            if (player0AllScore > player1AllScore) {
                return player0;
            } else if (player0AllScore < player1AllScore) {
                return player1;
            } else {
                return new ClientInfo("ITS A TIE");
            }
        }
        return null;
    }

}
