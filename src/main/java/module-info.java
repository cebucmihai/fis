module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires nitrite;


    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
    exports com.example.demo1.controllers;
    opens com.example.demo1.controllers to javafx.fxml;
    exports com.example.demo1.exceptions;
    opens com.example.demo1.exceptions to javafx.fxml;
    exports com.example.demo1.entities;
    opens com.example.demo1.entities to javafx.fxml;
    exports com.example.demo1.database;
    opens com.example.demo1.database to javafx.fxml;
    exports com.example.demo1.utils;
    opens com.example.demo1.utils to javafx.fxml;

}