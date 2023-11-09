package com.example.javakoridorchiki.Web.Login;

import com.example.javakoridorchiki.Client.Client;
import com.example.javakoridorchiki.Server.Game.GameCore;
import com.example.javakoridorchiki.Web.Grid.GridController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {
    private static final Logger LOGGER = Logger.getLogger(GameCore.class.getName());
    private final Client client = new Client.Builder().build();

    @FXML
    private TextField nicknameField;

    @FXML
    private Button findGameButton;

    @FXML
    protected void handleFindGame(ActionEvent mouseEvent) {
        String nickname = nicknameField.getText();
        LOGGER.log(Level.INFO, "Nickname: " + nickname);

        client.init();
        String response = client.tryConnectWithNickName(nickname);

        if (!client.isConnected()) {
            double x = ((Node)(mouseEvent.getSource())).getScene().getWindow().getX();
            double y = ((Node)(mouseEvent.getSource())).getScene().getWindow().getY();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setX(x);
            alert.setY(y);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(response);

            alert.showAndWait();
            nicknameField.setText("");
        } else {
            openGridWindow(mouseEvent);
        }
    }

    public void openGridWindow(Event event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game-grid.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root1, 1500, 1000);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Koridorchiki, Login=" + client.getClientInfo().getName());
            stage.setScene(scene);
            stage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();

            GridController gridController = fxmlLoader.getController();
            client.addObserver(gridController);
            gridController.update();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}