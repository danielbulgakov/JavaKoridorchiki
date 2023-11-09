package com.example.javakoridorchiki.Web.Grid;

import com.example.javakoridorchiki.Client.Client;
import com.example.javakoridorchiki.Common.CellType;
import com.example.javakoridorchiki.Common.ClientInfo;
import com.example.javakoridorchiki.Server.Game.GameCore;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.text.TextAlignment;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GridController implements IObserver {
    private static final Logger LOGGER = Logger.getLogger(GameCore.class.getName());
    private final Client c = new Client.Builder().build();
    @FXML
    public SplitPane splitPane;
    @FXML
    public GridPane gridPane;
    public VBox playersList;

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

    @FXML
    public void initialize() {
        initializeGameGrid();
        initializePlayerList();
    }

    private void initializePlayerList() {
        if (c.getClients() == null) return;
        playersList.getChildren().clear();

        for (ClientInfo player : c.getClients()) {
            playersList.getChildren().add(createPlayerRow(player));
        }

        if (c.getNextMoveBy() != null) {
            playersList.getChildren().add(createWhosMoveLabel(c.getNextMoveBy().getName()));
        }
    }

    private VBox createPlayerRow(ClientInfo player) {
        VBox playerRow = new VBox();
        playerRow.setAlignment(Pos.CENTER);

        Label nameLabel = new Label(player.getName());
        nameLabel.setMaxWidth(200);
        nameLabel.setFont(new Font("Arial", 18));

        Label scoreLabel = new Label("Score: " + player.getScore());
        scoreLabel.setFont(new Font("Arial", 16));

        Label winLabel = new Label("Wins: " + player.getWins());
        winLabel.setFont(new Font("Arial", 16));

        playerRow.getChildren().addAll(nameLabel, scoreLabel, winLabel);

        return playerRow;
    }

    private Label createWhosMoveLabel(String playerName) {
        Label whosLabel = new Label("Whos move: " + playerName);
        whosLabel.setFont(new Font("Arial", 16));

        return whosLabel;
    }

    private void initializeGameGrid() {
        int rows = Integer.parseInt(properties.getProperty("rows"));
        int cols = Integer.parseInt(properties.getProperty("cols"));

        gridPane.getChildren().clear();

        gridPane.setPrefSize(1000, 1000);
        gridPane.setGridLinesVisible(false);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Pane cell = createCell(row, col);
                gridPane.add(cell, col, row);
            }
        }
    }

    private Pane createCell(int row, int col) {
        Pane cell = new Pane();
        cell.setPrefSize(65, 65);

        int localRow = (row * 2) + 1;
        int localColumn = (col * 2) + 1;

        if (c.getField() != null && c.getField()[0][0] != null && c.getField()[localRow][localColumn] != CellType.Empty) {
            Text symbol = createSymbolText(c.getField()[localRow][localColumn]);
            cell.getChildren().add(symbol);
        }

        drawBorders(cell, localRow, localColumn);

        return cell;
    }

    private Text createSymbolText(CellType cellType) {
        Text symbol = new Text(cellType == CellType.Player0 ? "X" : "O");
        symbol.setFont(new Font(30));
        symbol.setTextAlignment(TextAlignment.CENTER);
        symbol.setLayoutX(22);
        symbol.setLayoutY(45);
        return symbol;
    }

    private void drawBorders(Pane cell, int row, int col) {
        Line topBorder = createBorderLine(row - 1, col, 0);
        Line rightBorder = createBorderLine(row, col + 1, 1);
        Line bottomBorder = createBorderLine(row + 1, col, 2);
        Line leftBorder = createBorderLine(row, col - 1, 3);

        topBorder.setUserData(new int[]{row - 1, col, 0});
        rightBorder.setUserData(new int[]{row, col + 1, 1});
        bottomBorder.setUserData(new int[]{row + 1, col, 2});
        leftBorder.setUserData(new int[]{row, col - 1, 3});

        topBorder.setStroke(getColor(row - 1, col));
        rightBorder.setStroke(getColor(row, col + 1));
        bottomBorder.setStroke(getColor(row + 1, col));
        leftBorder.setStroke(getColor(row, col - 1));

        cell.getChildren().addAll(topBorder, rightBorder, bottomBorder, leftBorder);

        topBorder.setOnMouseClicked(this::handleLineClick);
        rightBorder.setOnMouseClicked(this::handleLineClick);
        bottomBorder.setOnMouseClicked(this::handleLineClick);
        leftBorder.setOnMouseClicked(this::handleLineClick);
    }

    private Line createBorderLine(int row, int col, int direction) {
        Line border = new Line();

        if (c.getField() != null) {
            border.setStrokeWidth(5);

            switch (direction) {
                case 0:
                    border.setStartX(0);
                    border.setStartY(0);
                    border.setEndX(65);
                    border.setEndY(0);
                    break;
                case 1:
                    border.setStartX(65);
                    border.setStartY(0);
                    border.setEndX(65);
                    border.setEndY(65);
                    break;
                case 2:
                    border.setStartX(65);
                    border.setStartY(65);
                    border.setEndX(0);
                    border.setEndY(65);
                    break;
                case 3:
                    border.setStartX(0);
                    border.setStartY(65);
                    border.setEndX(0);
                    border.setEndY(0);
                    break;
            }
        }

        return border;
    }

    private Color getColor(int row, int col) {
        Color you = Color.BLUE;
        Color opponent = Color.RED;

        if (c.getField() != null && c.getField()[row][col] != CellType.Empty) {
            int playerIndex = getPlayerIndexForRowCol(row, col);
            if (playerIndex != -1) {
                ClientInfo player = c.getClients().get(playerIndex);
                return player.getName().equals(c.getClientInfo().getName()) ? you : opponent;
            }
        }
        return Color.LIGHTGRAY;
    }

    private int getPlayerIndexForRowCol(int row, int col) {
        for (int i = 0; i < c.getClients().size(); i++) {
            if (c.getField()[row][col] == CellType.values()[i]) {
                return i;
            }
        }
        return -1;
    }

    private void handleLineClick(MouseEvent event) {
        if (c.getNextMoveBy() != null && !c.getNextMoveBy().getName().equals(c.getClientInfo().getName())) {
            // Show alert that player cant make move
            showInvalidMoveDialog();
            return;
        }

        Node source = (Node) event.getSource();
        int rowIndex = ((int[]) source.getUserData())[0];
        int columnIndex = ((int[]) source.getUserData())[1];

        c.sendMove(rowIndex, columnIndex);
        LOGGER.log(Level.INFO, "Line clicked at row: " + rowIndex + ", column: " + columnIndex);
    }

    @Override
    public void update() {
        // Update game field and list of players
        Platform.runLater(() -> {
            if (c.getWinner() != null) {
                showWinnerDialog(c.getWinner().getName());
            }
            initializeGameGrid();
            initializePlayerList();
        });
    }

    private void showWinnerDialog(String winnerName) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("The winner is");
        alert.setHeaderText("We have a winner");
        alert.setContentText(winnerName);
        alert.showAndWait();
    }

    private void showInvalidMoveDialog() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Move");
        alert.setHeaderText("It's not your turn to make a move.");
        alert.setContentText("Please wait for your turn.");
        alert.showAndWait();
    }
}