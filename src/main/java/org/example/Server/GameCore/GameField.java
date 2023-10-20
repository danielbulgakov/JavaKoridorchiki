package org.example.Server.GameCore;

public class GameField {
    private int rwidth, cwidth;
    private int rows, cols;
    private GameStates[][] field;
    private boolean digitsWrapper;

    /**
     * @param _rows    rows of the field (max = 15)
     * @param _columns height of the field (max = 15)
     */
    public GameField(int _rows, int _columns, boolean _digitsWrapper) {
        int maxSize = 15;
        rows = Math.min(_rows, maxSize);
        cols = Math.min(_columns, maxSize);

        rwidth = rows * 2 + 1;
        cwidth = cols * 2 + 1;

        field = new GameStates[rwidth][cwidth];
        digitsWrapper = _digitsWrapper;

        for (int i = 0; i < rwidth; i++) {
            for (int j = 0; j < cwidth; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    field[i][j] = GameStates.Corner;
                } else {
                    field[i][j] = GameStates.Empty;
                }
            }
        }
    }

    public GameField(int _rows, int _columns) {
        this(_rows, _columns, true);
    }


    public int tryMakeMove(int _row, int _column, int _player) {
        int score = 0;

        if (_row < 0 || _row > rwidth) return -1;
        if (_column < 0 || _column > cwidth) return -1;

        // Check if move is valid
        if (!(_row % 2 == 0 && _column % 2 != 0 ||
                _row % 2 != 0 && _column % 2 == 0))
            return -1; // Not a valid move
        if (field[_row][_column] == GameStates.Corner ||
                field[_row][_column] != GameStates.Empty)
            return -1; // Not a valid move

        // Add a move made by a player
        if (_row % 2 == 0) {
            field[_row][_column] = GameStates.Horizontal;
        } else {
            field[_row][_column] = GameStates.Vertical;
        }

        // Find completed cells
        //
        if (field[_row][_column] == GameStates.Horizontal) {
            score += setCellCompleted(_row + 1, _column, _player);
            score += setCellCompleted(_row - 1, _column, _player);
        }

        if (field[_row][_column] == GameStates.Vertical) {
            score += setCellCompleted(_row, _column + 1, _player);
            score += setCellCompleted(_row, _column - 1, _player);
        }

        return score;
    }

    private int setCellCompleted(int _row, int _column, int _player) {
        if (isCellCompleted(getValueInRange(_row, rwidth - 1),
                getValueInRange(_column, cwidth - 1))
                && field[_row][_column] == GameStates.Empty) {
            if (_player == 0) {
                field[_row][_column] = GameStates.FirstScored;
            } else {
                field[_row][_column] = GameStates.SecondScored;
            }
            return 1;
        }
        return 0;
    }

    private int getValueInRange(int _value, int _upperBound) {
        return Math.min(Math.max(_value, 0), _upperBound);
    }

    private boolean isCellCompleted(int _row, int _column) {
        // Check cells on same column
        if (field[getValueInRange(_row - 1, rwidth - 1)][_column] == GameStates.Empty) return false;
        if (field[getValueInRange(_row + 1, rwidth - 1)][_column] == GameStates.Empty) return false;
        // Check cells on same row
        if (field[_row][getValueInRange(_column - 1, cwidth - 1)] == GameStates.Empty) return false;
        if (field[_row][getValueInRange(_column + 1, cwidth - 1)] == GameStates.Empty) return false;

        return true;
    }

    public void print() {
        int rcnt = 1, ccnt = 1;
        if (digitsWrapper) {
            System.out.print("   ");
            for (int i = 0; i < cwidth; i++) {
                if (i % 2 != 0) System.out.printf("%2d ", ccnt++);
                else System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < rwidth; i++) {
            if (digitsWrapper) {
                if (i % 2 != 0) System.out.printf("%2d ", rcnt++);
                else System.out.print("   ");
            }
            for (int j = 0; j < cwidth; j++) {
                System.out.printf("%s ", enumStringify(field[i][j]));
            }


            System.out.println();

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int rcnt = 1, ccnt = 1;
        if (digitsWrapper) {
            sb.append("   ");
            for (int i = 0; i < cwidth; i++) {
                if (i % 2 != 0) {
                    sb.append(String.format("%2d ", ccnt++));
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        for (int i = 0; i < rwidth; i++) {
            if (digitsWrapper) {
                if (i % 2 != 0) {
                    sb.append(String.format("%2d ", rcnt++));
                } else {
                    sb.append("   ");
                }
            }
            for (int j = 0; j < cwidth; j++) {
                sb.append(String.format("%s ", enumStringify(field[i][j])));
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    private String enumStringify(GameStates _state) {
        return switch (_state) {
            case Corner -> "*";
            case Horizontal -> "-";
            case Vertical -> "|";
            case FirstScored -> "x";
            case SecondScored -> "o";
            default -> " ";
        };
    }


}
