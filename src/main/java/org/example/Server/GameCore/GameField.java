package org.example.Server.GameCore;

import org.example.Common.Move;
import org.example.Common.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameField {
    private final int rows, cols;
    private final FieldStates[][] field;
    private final boolean wrapFieldWithDigits;
    private static final int maxSize = 15;

    private final ArrayList<Player> playersList;

    /**
     * @param rows  number of rows of the field (max = 15)
     * @param columns number of columns of the field (max = 15)
     * @param wrapFieldWithDigits boolean var if string output should be wrapped with digits
     */
    public GameField(int rows, int columns, boolean wrapFieldWithDigits, ArrayList<Player> players) {
        this.rows = Math.min(rows, maxSize) * 2 + 1;
        this.cols = Math.min(columns, maxSize) * 2 + 1;
        this.field = new FieldStates[rows][cols];
        this.wrapFieldWithDigits = wrapFieldWithDigits;
        this.playersList = players;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    field[i][j] = FieldStates.Corner;
                } else {
                    field[i][j] = FieldStates.Empty;
                }
            }
        }
    }

    /**
     * @param rows  number of rows of the field (max = 15)
     * @param columns number of columns of the field (max = 15)
     */
    public GameField(int rows, int columns, ArrayList<Player> players) {
        this(rows, columns, true, players);
    }

    public void clear() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    field[i][j] = FieldStates.Corner;
                } else {
                    field[i][j] = FieldStates.Empty;
                }
            }
        }
    }

    public int tryMakeMove(Move m, Player p) {
        return tryMakeMove(m.getRow(), m.getColumn(), p);
    }

    /**
     * @param row row position
     * @param column column position
     * @param p Players object
     * @return -1 if move is not valid, 0 if it valid, > 0 if player got scored
     */
    public int tryMakeMove(int row, int column, Player p) {
        int result = 0;

        if (row < 0 || row > rows) return -1;
        if (column < 0 || column > cols) return -1;

        // Check if move is valid
        if (!(row % 2 == 0 && column % 2 != 0 ||
                row % 2 != 0 && column % 2 == 0))
            return -1; // Not a valid move
        if (field[row][column] == FieldStates.Corner ||
                field[row][column] != FieldStates.Empty)
            return -1; // Not a valid move

        // Add a move made by a player
        if (row % 2 == 0) {
            field[row][column] = FieldStates.Horizontal;
        } else {
            field[row][column] = FieldStates.Vertical;
        }

        // Find completed cells
        if (field[row][column] == FieldStates.Horizontal) {
            result += setCellCompleted(row + 1, column, playersList.indexOf(p));
            result += setCellCompleted(row - 1, column, playersList.indexOf(p));
        }

        if (field[row][column] == FieldStates.Vertical) {
            result += setCellCompleted(row, column + 1, playersList.indexOf(p));
            result += setCellCompleted(row, column - 1, playersList.indexOf(p));
        }

        p.addScore(result);

        return result;
    }

    private int setCellCompleted(int row, int column, int playerInd) {
        if (isCellCompleted(getValueInRange(row, rows - 1),
                getValueInRange(column, cols - 1))
                && field[row][column] == FieldStates.Empty) {
            if (playerInd == 0) {
                field[row][column] = FieldStates.FirstScored;
            } else {
                field[row][column] = FieldStates.SecondScored;
            }
            return 1;
        }
        return 0;
    }

    private int getValueInRange(int value, int upperBound) {
        return Math.min(Math.max(value, 0), upperBound);
    }

    private boolean isCellCompleted(int row, int column) {
        // Check cells on same column
        if (field[getValueInRange(row - 1, rows - 1)][column] == FieldStates.Empty) return false;
        if (field[getValueInRange(row + 1, rows - 1)][column] == FieldStates.Empty) return false;
        // Check cells on same row
        if (field[row][getValueInRange(column - 1, cols - 1)] == FieldStates.Empty) return false;
        if (field[row][getValueInRange(column + 1, cols - 1)] == FieldStates.Empty) return false;

        return true;
    }

    public boolean isGameEnded() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i % 2 != 0 && j % 2 != 0) {
                    if (field[rows][cols] == FieldStates.Empty) return false;
                }
            }
        }
        return true;
    }

    public void print() {
        if (wrapFieldWithDigits) {
            System.out.print("  ");
            for (int i = 0; i < cols; i++) {
                System.out.printf("%2d", i);
            }
            System.out.println();
        }
        for (int i = 0; i < rows; i++) {
            if (wrapFieldWithDigits) {
                System.out.printf("%2d ", i);
            }
            for (int j = 0; j < cols; j++) {
                System.out.printf("%s ", enumStringify(field[i][j]));
            }


            System.out.println();

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (wrapFieldWithDigits) {
            sb.append("   ");
            for (int i = 0; i < cols; i++) {
                sb.append(String.format("%2d ", i++));
            }
            sb.append("\n");
        }
        for (int i = 0; i < rows; i++) {
            if (wrapFieldWithDigits) {
                sb.append(String.format("%2d ", i));
            }
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%s ", enumStringify(field[i][j])));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private String enumStringify(FieldStates state) {
        return switch (state) {
            case Corner -> "*";
            case Horizontal -> "-";
            case Vertical -> "|";
            case FirstScored -> "x";
            case SecondScored -> "o";
            default -> " ";
        };
    }
}
