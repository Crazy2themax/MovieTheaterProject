package controllers;

import javafx.fxml.FXML;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditMovieController {

    @FXML
    private TextField editMovieIDTextField;

    @FXML
    private TextField editMovieTitleTextField;

    @FXML
    private TextField editMovieDurationTextField;

    @FXML
    private Button editMovieSaveButton;

    @FXML
    private Button editMovieCancelButton;

    @FXML
    public void initialize() {
        // preload movie data given by caller
    }

    @FXML
    private void onSaveMovie() {
        // validate & save updated movie
        System.out.println("Movie saved.");
    }

    @FXML
    private void onCancel() {
        Stage s = (Stage) editMovieCancelButton.getScene().getWindow();
        s.close();
    }
}
