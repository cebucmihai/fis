package com.example.demo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setResizable(false);
        root = FXMLLoader.load(getClass().getResource("log-in.fxml"));
        scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Sport Events!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void changeScene(String fxml) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxml));
        stage.getScene().setRoot(root);
    }
    public static void main(String[] args) {
        launch();

    }
}