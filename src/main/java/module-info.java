module com.example.movietheater {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.movietheater to javafx.fxml;
    exports com.example.movietheater;
    opens com.example.movietheater.controllers to javafx.fxml;
    exports com.example.movietheater.controllers;
    opens com.example.movietheater.Models to javafx.fxml;
    exports com.example.movietheater.Models;

}