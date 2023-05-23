package com.example.demo1.controllers;

import com.example.demo1.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class ShowOrdersController {
    @FXML
    private Button back;

    @FXML
    public void toCustomerMenu(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("customer-menu.fxml");
    }
}
