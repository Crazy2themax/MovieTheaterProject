package controllers;

import javafx.fxml.FXML;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class addMovieController {

    @FXML
    private TextField addMovieIDTextField;

    @FXML
    private TextField addMovieTitleTextField;

    @FXML
    private TextField addMovieDurationTextField;

    @FXML
    private Button addMovieSaveButton;

    @FXML
    private Button addMoveiCancelButton;


    @FXML
    public void initialize() {
        // initialize any controls
    }

    @FXML
    private void onSaveMovie() {
        String id = addMovieIDTextField.getText();
        String title = addMovieTitleTextField.getText();
        String duration = addMovieDurationTextField.getText();
        System.out.println("Saving movie: " + id + " - " + title + " (" + duration + ")");
        // TODO: validate & add to list/model
    }

    @FXML
    private void onCancel() {
        Stage s = (Stage) addMoveiCancelButton.getScene().getWindow();
        s.close();
    }
}
