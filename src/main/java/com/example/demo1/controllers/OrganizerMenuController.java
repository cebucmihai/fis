package com.example.demo1.controllers;

import com.example.demo1.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class OrganizerMenuController {
    @FXML
    private Button modifyEvent;

    @FXML
    private Button createEvent;

    @FXML
    public void toCreateEvent(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("add-event.fxml");
    }

    @FXML
    public void toModifyEvent(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("modify-event.fxml");
    }
}
