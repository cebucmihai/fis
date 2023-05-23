package com.example.demo1.controllers;

import com.example.demo1.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class CustomerMenuController {
    @FXML
    private Button showEvents;

    @FXML
    private Button showOrders;

    @FXML
    public void toShowEvents(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("sport-list.fxml");
    }

    @FXML
    public void toShowOrders(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("show-orders.fxml");
    }
}
