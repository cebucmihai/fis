package com.example.demo1.controllers;

import com.example.demo1.Main;
import com.example.demo1.database.NitriteDB;
import com.example.demo1.entities.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.security.PublicKey;
import java.util.PrimitiveIterator;
import java.util.ResourceBundle;

public class ModifyEventController implements Initializable {

    @FXML
    private Label selectEvent;
    @FXML
    private Button back;

    @FXML
    private Button select;

    @FXML
    private ChoiceBox<Event> eventChoiceBox;

    NitriteDB db = NitriteDB.getInstance();
    @FXML
    public void modifyEvent(ActionEvent event) throws IOException {
        selectEvent();
    }

    public void selectEvent() throws IOException {
    if(  eventChoiceBox.getValue()==null){
        selectEvent.setText("Please select an event");
    }else{
        db.selectedEvent(eventChoiceBox.getValue());
        Main m = new Main();
        m.changeScene("modify-selected-event.fxml");
    }

}
    @FXML
    public void toOrganizerMenu(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("organizer-menu.fxml");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        eventChoiceBox.getItems().addAll(db.getCurrentUser().getEvents());
    }
}
