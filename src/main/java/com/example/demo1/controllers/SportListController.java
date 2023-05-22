package com.example.demo1.controllers;

import com.example.demo1.Main;
import com.example.demo1.database.NitriteDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class SportListController {

    @FXML
    private Label sportListLabel;

    @FXML
    private Button footballButton;

    @FXML
    private Button basketballButton;

    @FXML
    private Button tennisButton;

    @FXML
    private Button rugbyButton;

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
}
