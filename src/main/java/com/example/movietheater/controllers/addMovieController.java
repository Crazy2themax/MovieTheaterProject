package com.example.movietheater.controllers;

import com.example.movietheater.Models.DataStore;
import com.example.movietheater.Models.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the "Add Movie" view.
 * <p>
 * Handles the interaction between the user and the "Add Movie" form,
 * allowing the user to input a movie ID, title, and duration, and either save or cancel the action.
 * Validates all input before adding the movie to the DataStore.
 * </p>
 *
 * @author Movie Theater Application
 * @version 1.0
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
     * Called automatically after the FXML file has been loaded.
     * Can be used for additional initialization if needed.
     * </p>
     */
    @FXML
    public void initialize() {
        // Additional initialization if needed
    }

    /**
     * Handles the save button click event.
     * <p>
     * Retrieves and validates the movie ID, title, and duration from the text fields.
     * Checks for empty fields, valid numbers, positive values, and duplicate IDs.
     * Adds the movie to the DataStore if all validations pass.
     * </p>
     */
    @FXML
    private void onAddMovieSaveButtonClick() {
        try {
            // Get and trim inputs
            String idText = this.addMovieIDTextField.getText().trim();
            String title = this.addMovieTitleTextField.getText().trim();
            String durationText = this.addMovieDurationTextField.getText().trim();

            // Check if fields are empty
            if (idText.isEmpty()) {
                new Alert(AlertType.WARNING, "Movie ID cannot be empty.").showAndWait();
                return;
            }
            if (title.isEmpty()) {
                new Alert(AlertType.WARNING, "Movie title cannot be empty.").showAndWait();
                return;
            }
            if (durationText.isEmpty()) {
                new Alert(AlertType.WARNING, "Movie duration cannot be empty.").showAndWait();
                return;
            }

            // Parse numbers
            int id = Integer.parseInt(idText);
            int duration = Integer.parseInt(durationText);

            // Validate ID is positive
            if (id <= 0) {
                new Alert(AlertType.WARNING, "Movie ID must be a positive number.").showAndWait();
                return;
            }

            // Validate duration is positive
            if (duration <= 0) {
                new Alert(AlertType.WARNING, "Duration must be a positive number.").showAndWait();
                return;
            }

            // Check if ID already exists
            if (DataStore.getMovieById(id) != null) {
                new Alert(AlertType.ERROR, "A movie with ID " + id + " already exists.").showAndWait();
                return;
            }

            // Create and add the movie
            Movie newMovie = new Movie(id, title, duration);
            DataStore.movieList.add(newMovie);

            // Close the window
            Stage stage = (Stage) this.addMovieSaveButton.getScene().getWindow();
            stage.close();

        } catch (NumberFormatException e) {
            new Alert(AlertType.ERROR, "ID and duration must be valid numbers.").showAndWait();
        }
    }

    /**
     * Handles the cancel button click event.
     * <p>
     * Closes the current window without saving any data.
     * </p>
     */
    @FXML
    private void onAddMovieCancelButtonClick() {
        Stage stage = (Stage) this.addMovieCancelButton.getScene().getWindow();
        stage.close();
    }
}