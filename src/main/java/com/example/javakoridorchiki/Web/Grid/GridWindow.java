package com.example.javakoridorchiki.Web.Grid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GridWindow extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GridWindow.class.getResource("game-grid.fxml"));
        stage.setResizable(false);
        Scene scene = new Scene(fxmlLoader.load(), 1500, 1000);
        stage.setTitle("Koridorchiki");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
