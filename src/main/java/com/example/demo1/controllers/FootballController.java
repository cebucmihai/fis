package com.example.demo1.controllers;

import com.example.demo1.Main;
import com.example.demo1.database.NitriteDB;
import com.example.demo1.entities.SportType;
import com.example.demo1.entities.User;
import com.example.demo1.exceptions.InsufficientSeats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class FootballController implements Initializable {
    @FXML
    private Label football;

    @FXML
    private Button back;
    @FXML
    private Label ticket_message;
    @FXML
    private TableView<com.example.demo1.entities.Event> table;
    @FXML
    private TableColumn<com.example.demo1.entities.Event,String> name;
    @FXML
    private TableColumn<com.example.demo1.entities.Event, String> date;
    @FXML
    private TableColumn<com.example.demo1.entities.Event,Integer> seats;
    @FXML
    private TableColumn<com.example.demo1.entities.Event,Double> price;
    NitriteDB db = NitriteDB.getInstance();
    ObservableList<com.example.demo1.entities.Event> list = FXCollections.observableList(db.readEvents().stream().filter(event -> event.getSportType().equals(SportType.FOOTBALL)).collect(Collectors.toList()));
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        name.setCellValueFactory(new PropertyValueFactory<com.example.demo1.entities.Event,String>("eventName"));
        date.setCellValueFactory(new PropertyValueFactory<com.example.demo1.entities.Event,String>("eventDate"));
        seats.setCellValueFactory(new PropertyValueFactory<com.example.demo1.entities.Event,Integer>("numberOfSeats"));
        price.setCellValueFactory(new PropertyValueFactory<com.example.demo1.entities.Event,Double>("ticketPrice"));

        table.setItems(list);
    }
    @FXML
    public void buyTicket(){

         try {
             db.addEventToUser(db.getCurrentUser(), table.getSelectionModel().getSelectedItems().get(0));
             try{
                db.findEvent(table.getSelectionModel().getSelectedItems().get(0));
                ticket_message.setText("Ticket bought successfully");
             } catch (InsufficientSeats insufficientSeats) {
                 ticket_message.setText("No more seats for this event!");
             }
         }catch(IndexOutOfBoundsException e){
             ticket_message.setText("Please select an event !");
         }
    }
    public void toSportList(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("sport-list.fxml");
    }
}
