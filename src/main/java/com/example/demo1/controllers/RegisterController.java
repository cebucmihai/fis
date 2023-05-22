package com.example.demo1.controllers;

import com.example.demo1.Main;
import com.example.demo1.database.NitriteDB;
import com.example.demo1.exceptions.UserAlreadyExists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ChoiceBox<String> role;
    @FXML
    private Button register;
    @FXML
    private Button login;
    @FXML
    private Label usernameTaken;

    NitriteDB db = NitriteDB.getInstance();
    private final String[] roles = {"Customer", "Organizer"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        role.getItems().addAll(roles);
    }

    public void userRegister(ActionEvent event) throws IOException {
        checkRegister();
    }

    public void toLogin(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("log-in.fxml");
    }

    private void checkRegister() throws IOException{
        if(username.getText().isEmpty() ) {
            usernameTaken.setText("Please fill in the username field");
        }
        else if(password.getText().isEmpty()) {
            usernameTaken.setText("Please fill in the password field");
        }
        else if(role.getValue()==null) {
            usernameTaken.setText("Please fill in the role field");
        }
        else{
            try {
               // db.insertUser(username.getText(), password.getText(), (String) role.getValue());
                usernameTaken.setText("Account created successfully!");
            } catch (UserAlreadyExists e) {
                usernameTaken.setText(e.getMessage());
            }
        }
    }
}
