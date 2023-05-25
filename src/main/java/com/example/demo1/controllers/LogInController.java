package com.example.demo1.controllers;

import com.example.demo1.Main;
import com.example.demo1.database.NitriteDB;
import com.example.demo1.entities.SportType;
import com.example.demo1.entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;

public class LogInController {
    @FXML
    private Button button_login;
    @FXML
    private TextField tf_username;
    @FXML
    private PasswordField tf_password;
    @FXML
    private  Button button_sign_up;
    @FXML
    private  Label wrongLogin;

    NitriteDB db = NitriteDB.getInstance();

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }
    @FXML
    private void checkLogin() throws IOException{

        if(tf_username.getText().isEmpty() ) {
            wrongLogin.setText("Please fill in the username field");
        }
        else if(tf_password.getText().isEmpty()) {
            wrongLogin.setText("Please fill in the password field");
        }
        else if(db.findUser(tf_username.getText(),tf_password.getText()).isPresent()) {
            User user = db.findUser(tf_username.getText(),tf_password.getText()).get();
            db.setCurrentUser(user);
            System.out.println(user);
//            db.insertEvent("UCL FINAL", SportType.FOOTBALL,"10 Iunie",30,25.0);
//            db.insertEvent("NBA FINAL", SportType.BASKETBALL,"10 Iunie",30,25.0);
//            db.insertEvent("ROLAND GARROS FINAL", SportType.TENNIS,"10 Iunie",30,25.0);
            Main m = new Main();
            if(user.getRole().equals("Customer")) {
                m.changeScene("customer-menu.fxml");
            }
            else if(user.getRole().equals("Organizer")){
                m.changeScene("organizer-menu.fxml");
            }
        }
        else {
            wrongLogin.setText("User credentials are introduced wrong!");
        }


    }
    public void toRegister(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("register.fxml");
    }

}
