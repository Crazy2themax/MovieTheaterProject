package com.example.movietheater.controllers;

import com.example.movietheater.Models.Movie;
import com.example.movietheater.Models.DataStore;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 * Controller class for the "Add com.example.movietheater.Models.Movie" view.
 * <p>
 * This class handles the interaction between the user and the "Add com.example.movietheater.Models.Movie" form,
 * allowing the user to input a movie ID, title, and duration, and either save or cancel the action.
 * </p>
 */
public class addMovieController {

    /** TextField for entering the movie ID. */
    @FXML
    private TextField addMovieIDTextField;

    /** TextField for entering the movie title. */
    @FXML
    private TextField addMovieTitleTextField;

    /** TextField for entering the movie duration. */
    @FXML
    private TextField addMovieDurationTextField;

    /** Button to save the movie information. */
    @FXML
    private Button addMovieSaveButton;

    /** Button to cancel adding a movie. */
    @FXML
    private Button addMovieCancelButton;

    /**
     * Initializes the controller.
     * <p>
     * This method is called automatically after the FXML file has been loaded.
     * You can use it to initialize any controls or data if needed.
     * </p>
     */
    @FXML
    public void initialize() {
        // initialize any controls
    }

    /**
     * Handles the action of saving a movie.
     * <p>
     * Retrieves the movie ID, title, and duration from the text fields,
     * prints them to the console, and can be extended to validate and add the movie to the model.
     * </p>
     */
    @FXML
    private void onAddMovieSaveButtonClick() {
        try {
            int id = Integer.parseInt(addMovieIDTextField.getText().trim());
            String title = addMovieTitleTextField.getText().trim();
            int duration = Integer.parseInt(addMovieDurationTextField.getText().trim());

            if(title.isEmpty()){
                new Alert(AlertType.WARNING,"Movie title cannot be empty").showAndWait();
                return;
            }

            // Check if ID already exists
            if (DataStore.getMovieById(id) != null) {
                new Alert(AlertType.WARNING, "A movie with ID " + id + " already exists.").showAndWait();
                return;
            }

            // Create the movie
            Movie newMovie = new Movie(id, title, duration);

            // ADD THIS LINE - Actually add it to the DataStore!
            DataStore.movieList.add(newMovie);

            // Close the window
            Stage s = (Stage) addMovieSaveButton.getScene().getWindow();
            s.close();

        } catch (Exception e) {
            new Alert(AlertType.ERROR,"Invalid ID or duration").showAndWait();
        }
    }

    /**
     * Handles the action of cancelling the add movie operation.
     * <p>
     * Closes the current window without saving any data.
     * </p>
     */
    @FXML
    private void onAddMovieCancelButtonClick() {
        Stage s = (Stage) addMovieCancelButton.getScene().getWindow();
        s.close();
    }
}
