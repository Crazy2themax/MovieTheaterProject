package com.example.movietheater.controllers;

import com.example.movietheater.Models.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;


/**
 * Controller class for the "Edit com.example.movietheater.Models.Movie" view.
 * <p>
 * Handles the interaction for editing an existing movie's information,
 * including movie ID, title, and duration. Provides functionality to save changes
 * or cancel the editing process.
 * </p>
 */
public class EditMovieController {

    private Movie movie;

    public void setMovie(Movie aMovie) {
        this.movie = aMovie;
        editMovieIDTextField.setText(String.valueOf(movie.getpMovieID()));
        editMovieTitleTextField.setText(movie.getpTitle());
        editMovieDurationTextField.setText(String.valueOf(movie.getpDuration()));
    }
    /** TextField for editing the movie ID. */
    @FXML
    private TextField editMovieIDTextField;

    /** TextField for editing the movie title. */
    @FXML
    private TextField editMovieTitleTextField;

    /** TextField for editing the movie duration. */
    @FXML
    private TextField editMovieDurationTextField;

    /** Button to save the edited movie information. */
    @FXML
    private Button EditMovieSaveButton;

    /** Button to cancel the edit operation. */
    @FXML
    private Button EditMovieCancelButton;

    /**
     * Initializes the controller.
     * <p>
     * Called automatically after the FXML file has been loaded.
     * Can be used to preload the movie data passed by the caller.
     * </p>
     */
    @FXML
    public void initialize() {
        // preload movie data given by caller
    }

    /**
     * Handles saving the edited movie.
     * <p>
     * Validates and saves the updated movie information.
     * Curently prints a message to the console; extend this method to update the model.
     * </p>
     */
    @FXML
    private void EditMovieSaveButton() {
        try {
            int newID = Integer.parseInt(editMovieIDTextField.getText().trim());
            String newTitle = editMovieTitleTextField.getText().trim();
            int newDuration = Integer.parseInt(editMovieDurationTextField.getText().trim());

            if (newTitle.isEmpty()) {
                showError("Title cannot be empty.");
                return;
            }

            movie.setpMovieID(newID);
            movie.setpTitle(newTitle);
            movie.setpDuration(newDuration);

            Stage s = (Stage) EditMovieSaveButton.getScene().getWindow();
            s.close();
        } catch (NumberFormatException e) {
            showError("ID and Duration must be valid numbers.");
        }
    }

    private void showError(String msg) {
        new Alert(Alert.AlertType.ERROR, msg).showAndWait();
    }


    /**
     * Handles cancelling the edit operation.
     * <p>
     * Closes the current window without saving changes.
     * </p>
     */
    @FXML
    private void EditMovieCancelButton() {
        Stage s = (Stage) EditMovieCancelButton.getScene().getWindow();
        s.close();
    }

}
