package com.example.demo1.controllers;

import com.example.demo1.Main;
import com.example.demo1.database.NitriteDB;
import com.example.demo1.entities.Event;
import com.example.demo1.entities.SportType;
import com.example.demo1.exceptions.InsufficientSeatsException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class BasketballController implements Initializable {
    @FXML
    private Label basketball;
    @FXML
    private Button back;
    @FXML
    private Label ticket_message;
    @FXML
    private TableView<Event> table;
    @FXML
    private Button buy_ticket;
    @FXML
    private TableColumn<Event,String> name;
    @FXML
    private TableColumn<com.example.demo1.entities.Event, String> date;
    @FXML
    private TableColumn<com.example.demo1.entities.Event,Integer> seats;
    @FXML
    private TableColumn<com.example.demo1.entities.Event,Double> price;
    NitriteDB db = NitriteDB.getInstance();
    ObservableList<Event> list = FXCollections.observableList(db.readEvents().stream().filter(event -> event.getSportType().equals(SportType.BASKETBALL)).collect(Collectors.toList()));
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        name.setCellValueFactory(new PropertyValueFactory<Event,String>("eventName"));
        date.setCellValueFactory(new PropertyValueFactory<com.example.demo1.entities.Event,String>("eventDate"));
        seats.setCellValueFactory(new PropertyValueFactory<com.example.demo1.entities.Event,Integer>("numberOfSeats"));
        price.setCellValueFactory(new PropertyValueFactory<com.example.demo1.entities.Event,Double>("ticketPrice"));

        table.setItems(list);
    }
    @FXML
    public void buyTicket(){

        try {
            db.updateEvent(table.getSelectionModel().getSelectedItems().get(0));
            db.addEventToUser(db.getCurrentUser(), table.getSelectionModel().getSelectedItems().get(0));
            successfullBuy();
        }catch(IndexOutOfBoundsException e){
            ticket_message.setText("Please select an event !");
        } catch (InsufficientSeatsException insufficientSeats) {
            ticket_message.setText("No more seats for this event!");
        } catch (IOException e){

        }
    }
    public void successfullBuy() throws IOException{

                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setContentText("Ticket bought successfully");
                   Optional<ButtonType> result = alert.showAndWait();
                   if(result.isPresent() && result.get()== ButtonType.OK) {
                       Main m = new Main();

                       m.changeScene("basketball-list.fxml");
                   }

    }

    public void toSportList(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("sport-list.fxml");
    }
}
