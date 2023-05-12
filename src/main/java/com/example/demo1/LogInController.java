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
    private  Label label_verify;
    Utils m = new Utils();
    NitriteDB db=new NitriteDB();

    @FXML
    private void checkLogin(ActionEvent event) throws IOException{
       if(!db.findUser(tf_username.getText(),tf_password.getText())){
            label_verify.setText("Wrong Credentials ! Try Again !");
        }else{
            //button_login.
            m.changeScene(event,"register.fxml");
        }

    }

}
