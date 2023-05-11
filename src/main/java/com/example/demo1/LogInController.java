package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    Main m = new Main();
    NitriteDB db=new NitriteDB();
    public void userLogIn(ActionEvent event) throws IOException{
        checkLogin();
    }

    private void checkLogin() throws IOException{
    /*    if(!db.findUser(tf_username.getText(),tf_password.getText())){
            label_verify.setText("Wrong Credentials ! Try Again !");
        }else{
            //button_login.
            m.changeScene("hello-view.fxml");
        }*/
        if(tf_username.getText().toString().equals("user1") && tf_password.getText().toString().equals("pass")){
            m.changeScene("hello-view.fxml");
        }else {
            label_verify.setText("Wrong Credentials ! Try Again !");
        }
    }

}
