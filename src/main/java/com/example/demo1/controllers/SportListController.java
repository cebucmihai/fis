package com.example.demo1.controllers;

import com.example.demo1.Main;
import com.example.demo1.database.NitriteDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SportListController implements Initializable {

    @FXML
    private Label sportListLabel;
    @FXML
    private Button back;

    @FXML
    private Button footballButton;

    @FXML
    private Button basketballButton;

    @FXML
    private Button tennisButton;

    @FXML
    private Button rugbyButton;
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color:-fx-shadow-highlight-color,#a4c2ed ;";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //footballButton.setStyle(IDLE_BUTTON_STYLE);
        footballButton.setOnMouseEntered(e -> footballButton.setStyle(HOVERED_BUTTON_STYLE));
        footballButton.setOnMouseExited(e -> footballButton.setStyle(IDLE_BUTTON_STYLE));
       // basketballButton.setStyle(IDLE_BUTTON_STYLE);
        basketballButton.setOnMouseEntered(e -> basketballButton.setStyle(HOVERED_BUTTON_STYLE));
        basketballButton.setOnMouseExited(e -> basketballButton.setStyle(IDLE_BUTTON_STYLE));
       // tennisButton.setStyle(IDLE_BUTTON_STYLE);
        tennisButton.setOnMouseEntered(e -> tennisButton.setStyle(HOVERED_BUTTON_STYLE));
        tennisButton.setOnMouseExited(e -> tennisButton.setStyle(IDLE_BUTTON_STYLE));
        //rugbyButton.setStyle(IDLE_BUTTON_STYLE);
        rugbyButton.setOnMouseEntered(e -> rugbyButton.setStyle(HOVERED_BUTTON_STYLE));
        rugbyButton.setOnMouseExited(e -> rugbyButton.setStyle(IDLE_BUTTON_STYLE));

    }
    NitriteDB nitriteDB = NitriteDB.getInstance();

    public void toFootball(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("football-list.fxml");
    }

    public void toBasketball(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("basketball-list.fxml");
    }
    public void toTennis(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("tennis-list.fxml");
    }
    public void toRugby(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("rugby-list.fxml");
    }

    public void toCustomerMenu(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("customer-menu.fxml");
    }
}
