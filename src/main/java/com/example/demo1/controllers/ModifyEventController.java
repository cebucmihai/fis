package com.example.demo1.controllers;

import com.example.demo1.Main;
import com.example.demo1.database.NitriteDB;
import com.example.demo1.entities.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.security.PublicKey;
import java.util.PrimitiveIterator;
import java.util.ResourceBundle;

public class ModifyEventController implements Initializable {

    @FXML
    private Button back;

    @FXML
    private Button select;

    @FXML
    private ChoiceBox<Event> eventChoiceBox = new ChoiceBox<>();

    NitriteDB db = NitriteDB.getInstance();

    @FXML
    public void toOrganizerMenu(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("organizer-menu.fxml");
    }

    @FXML
    public void toSelectedEvent(ActionEvent event) throws IOException {
        Main m = new Main();
        //jsdfnsa
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        eventChoiceBox.getItems().addAll(db.getCurrentUser().getEvents());
    }
}
