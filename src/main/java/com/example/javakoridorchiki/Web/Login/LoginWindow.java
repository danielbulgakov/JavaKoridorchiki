package com.example.javakoridorchiki.Web.Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginWindow.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 150);
        stage.setResizable(false);
        stage.setTitle("Welcome to game Koridorchiki!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}