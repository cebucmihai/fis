package com.example.demo1;

import com.example.demo1.database.NitriteDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    private static Stage stage;
    private NitriteDB db = NitriteDB.getInstance();
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setResizable(false);
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("log-in.fxml"));
        primaryStage.setTitle("Sport Events!");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    public void changeScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stage.getScene().setRoot(root);
    }
    public static void main(String[] args) {
        launch(args);
    }
}