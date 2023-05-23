package com.example.demo1.controllers;

import com.example.demo1.Main;
import com.example.demo1.database.NitriteDB;
import com.example.demo1.entities.Event;
import com.example.demo1.entities.SportType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class RugbyController implements Initializable {
    @FXML
    private Label rugby;

    @FXML
    private Button back;
    @FXML
    private Label ticket_success;
    @FXML
    private TableView<Event> table;
    @FXML
    private TableColumn<Event,String> name;
    @FXML
    private TableColumn<com.example.demo1.entities.Event, String> date;
    @FXML
    private TableColumn<com.example.demo1.entities.Event,Integer> seats;
    @FXML
    private TableColumn<com.example.demo1.entities.Event,Double> price;
    NitriteDB db = NitriteDB.getInstance();
    ObservableList<Event> list = FXCollections.observableList(db.readEvents().stream().filter(event -> event.getSportType().equals(SportType.RUGBY)).collect(Collectors.toList()));
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        name.setCellValueFactory(new PropertyValueFactory<Event,String>("eventName"));
        date.setCellValueFactory(new PropertyValueFactory<com.example.demo1.entities.Event,String>("eventDate"));
        seats.setCellValueFactory(new PropertyValueFactory<com.example.demo1.entities.Event,Integer>("numberOfSeats"));
        price.setCellValueFactory(new PropertyValueFactory<com.example.demo1.entities.Event,Double>("ticketPrice"));

        table.setItems(list);
    }

    public void toSportList(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("sport-list.fxml");
    }
}
