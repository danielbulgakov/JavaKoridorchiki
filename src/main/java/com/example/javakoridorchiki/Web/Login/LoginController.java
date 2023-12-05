package com.example.javakoridorchiki.Web.Login;

import GRPC.RegisterResponse;
import com.example.javakoridorchiki.GRPC.Client.ClientGRPC;
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
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
    private final ClientGRPC client = new ClientGRPC.Builder().build();

    @FXML
    private TextField nicknameField;

    @FXML
    private Button findGameButton;

    @FXML
    protected void handleFindGame(ActionEvent mouseEvent) {
        String nickname = nicknameField.getText();
        LOGGER.log(Level.INFO, "Nickname: " + nickname);

        RegisterResponse response = client.registerName(nickname);

        if (!response.getConnected()) {
            double x = ((Node)(mouseEvent.getSource())).getScene().getWindow().getX();
            double y = ((Node)(mouseEvent.getSource())).getScene().getWindow().getY();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setX(x);
            alert.setY(y);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(response.getComment());

            alert.showAndWait();
            nicknameField.setText("");
        } else {
            ClientGRPC.clientInfo = response.getIdentity();
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
            stage.setTitle("Koridorchiki, Login=" + ClientGRPC.clientInfo.getName());
            stage.setScene(scene);
            stage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();

            GridController gridController = fxmlLoader.getController();
            gridController.update();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}