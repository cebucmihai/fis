package com.example.demo1.controllers;

import com.example.demo1.Main;
import com.example.demo1.database.NitriteDB;
import com.example.demo1.entities.SportType;
import com.example.demo1.exceptions.EventAlreadyExistException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.ResourceBundle;

public class AddEventController implements Initializable {

    @FXML
    private TextField eventName;

    @FXML
    private TextField numberOfSeats;

    @FXML
    private DatePicker eventDate;

    @FXML
    private TextField ticketPrice;

    @FXML
    private ChoiceBox<SportType> sportTypeChoiceBox = new ChoiceBox<>();
    @FXML
    private Button back;

    @FXML
    private Button createEvent;

    @FXML
    private Label eventLabel;

    NitriteDB db = NitriteDB.getInstance();

    @FXML
    public void toOrganizerMenu(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("organizer-menu.fxml");
    }

    @FXML
    public void createEvent(ActionEvent event) {
        checkEvent();
    }

    public void checkEvent() {
        if(eventName.getText().isEmpty()) {
            eventLabel.setText("Please fill event name!");
        } else if(numberOfSeats.getText().isEmpty()) {
            eventLabel.setText("Please fill number of seats!");
        } else if(eventDate.getValue().isBefore(LocalDate.now())) {
            eventLabel.setText("Change event date!");
        } else if(ticketPrice.getText().isEmpty()) {
            eventLabel.setText("Please fill ticket price!");
        } else {
            try {
                double price = Double.parseDouble(ticketPrice.getText());
                int number = Integer.parseInt(numberOfSeats.getText());
                db.insertEvent(eventName.getText(), sportTypeChoiceBox.getValue(), eventDate.getValue().toString(), number, price );
                eventLabel.setText("Event created!");
            } catch (EventAlreadyExistException eventAlreadyExistException) {
                eventLabel.setText(eventAlreadyExistException.getMessage());
            } catch (NumberFormatException numberFormatException) {
                eventLabel.setText("Ticket price and number of seats should be a number!");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sportTypeChoiceBox.getItems().addAll(Arrays.asList(SportType.FOOTBALL, SportType.BASKETBALL, SportType.TENNIS, SportType.RUGBY));
    }
}
