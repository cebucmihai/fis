package com.example.demo1.controllers;

import com.example.demo1.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class BasketballController {
    @FXML
    private Label basketball;

    @FXML
    private Button back;

    public void toSportList(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("sport-list.fxml");
    }
}
