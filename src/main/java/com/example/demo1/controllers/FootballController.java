package com.example.demo1.controllers;

import com.example.demo1.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class FootballController implements Initializable {
    @FXML
    private Label football;

    @FXML
    private Button back;
    @FXML
    private Label ticket_success;
    @FXML
    private TableView<Event> table;
    @FXML
    private TableColumn<Event,String> name;
    @FXML
    private TableColumn<Event, LocalDateTime> date;
    @FXML
    private TableColumn<Event,Integer> seats;
    @FXML
    private TableColumn<Event,Double> price;
   // ObservableList<Event> list = FXCollections.observableList()
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        name.setCellValueFactory(new PropertyValueFactory<Event,String>("name"));
        date.setCellValueFactory(new PropertyValueFactory<Event,LocalDateTime>("date"));
        seats.setCellValueFactory(new PropertyValueFactory<Event,Integer>("seats"));
        price.setCellValueFactory(new PropertyValueFactory<Event,Double>("price"));
    }
    public void toSportList(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("sport-list.fxml");
    }
}
