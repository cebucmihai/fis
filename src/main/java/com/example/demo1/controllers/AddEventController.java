package com.example.demo1.controllers;

import com.example.demo1.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class AddEventController {
    @FXML
    private Label newEvent;

    @FXML
    private Button back;

    @FXML
    public void toOrganizerMenu(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("organizer-menu.fxml");
    }

}
