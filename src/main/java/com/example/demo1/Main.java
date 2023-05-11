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
    private static Stage stg;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stg=primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("log-in.fxml"));
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("LogIn!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void changeScene( String fxml) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(fxml));

        Scene scene = new Scene(root, 600, 400);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();

    }
}