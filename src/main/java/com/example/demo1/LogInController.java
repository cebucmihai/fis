package com.example.demo1;

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
    @FXML
    private ChoiceBox<String> role;
    NitriteDB db = new NitriteDB();
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
        else if(db.findUser(new User(tf_username.getText(),tf_password.getText(),role.getValue()))) {
            Main m= new Main();
            if(role.getValue().equals("customer")) {
               // DataHolderForCurrentUser.setCurrentUser(new User(tf_username.getText(), tf_password.getText(), role.getValue()));
                m.changeScene("sport-list.fxml");
            }
            else if(role.getValue().equals("manager")){
                m.changeScene("manager.fxml");
            }
        }
        else {
            wrongLogin.setText("User credentials are introduced wrong!");
        }


    }

}
