package com.example.movietheater.controllers;

import com.example.movietheater.Models.DataStore;
import com.example.movietheater.Models.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the "Edit Movie" view.
 * <p>
 * Handles the interaction for editing an existing movie's information,
 * including movie ID, title, and duration. Provides functionality to save changes
 * or cancel the editing process. Validates all input and checks for duplicate IDs.
 * </p>
 *
 * @author Maxim Gosselin
 * * @version 1.0
 */
public class EditMovieController {

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
    private Button editMovieSaveButton;

    /** Button to cancel the edit operation. */
    @FXML
    private Button EditMovieCancelButton;

    /** The movie being edited. */
    private Movie aMovie;

    /**
     * Initializes the controller.
     * <p>
     * Called automatically after the FXML file has been loaded.
     * Can be used for additional initialization if needed.
     * </p>
     */
    @FXML
    public void initialize() {
    }

    /**
     * Sets the movie to be edited and populates the form fields.
     *
     * @param pMovie the movie to edit
     */
    public void setMovie(Movie pMovie) {
        this.aMovie = pMovie;
        this.editMovieIDTextField.setText(String.valueOf(pMovie.getpMovieID()));
        this.editMovieTitleTextField.setText(pMovie.getpTitle());
        this.editMovieDurationTextField.setText(String.valueOf(pMovie.getpDuration()));
    }

    /**
     * Handles the save button click event.
     * <p>
     * Validates and saves the updated movie information.
     * Checks for empty fields, valid numbers, positive values, and duplicate IDs
     * (allowing the movie to keep its current ID).
     * </p>
     */
    @FXML
    private void onEditMovieSaveButtonClick() {
        try {
            // Get and trim inputs
            String idText = this.editMovieIDTextField.getText().trim();
            String newTitle = this.editMovieTitleTextField.getText().trim();
            String durationText = this.editMovieDurationTextField.getText().trim();

            // Check if fields are empty
            if (idText.isEmpty()) {
                this.showError("Movie ID cannot be empty.");
                return;
            }
            if (newTitle.isEmpty()) {
                this.showError("Title cannot be empty.");
                return;
            }
            if (durationText.isEmpty()) {
                this.showError("Duration cannot be empty.");
                return;
            }

            // Parse numbers
            int newID = Integer.parseInt(idText);
            int newDuration = Integer.parseInt(durationText);

            // Validate ID is positive
            if (newID <= 0) {
                this.showError("Movie ID must be a positive number.");
                return;
            }

            // Validate duration is positive
            if (newDuration <= 0) {
                this.showError("Duration must be a positive number.");
                return;
            }

            // Check if the new ID already exists (but allow keeping the same ID)
            if (newID != this.aMovie.getpMovieID()) {
                Movie existingMovie = DataStore.getMovieById(newID);
                if (existingMovie != null) {
                    this.showError("A movie with ID " + newID + " already exists.");
                    return;
                }
            }

            // Update the movie
            this.aMovie.setpMovieID(newID);
            this.aMovie.setpTitle(newTitle);
            this.aMovie.setpDuration(newDuration);

            // Close the window
            Stage stage = (Stage) this.editMovieSaveButton.getScene().getWindow();
            stage.close();

        } catch (NumberFormatException e) {
            this.showError("ID and Duration must be valid numbers.");
        }
    }

    /**
     * Displays an error dialog with the specified message.
     *
     * @param pMessage the error message to display
     */
    private void showError(String pMessage) {
        new Alert(Alert.AlertType.ERROR, pMessage).showAndWait();
    }

    /**
     * Handles the cancel button click event.
     * <p>
     * Closes the current window without saving changes.
     * </p>
     */
    @FXML
    private void onEditMovieCancelButtonClick() {
        Stage stage = (Stage) this.EditMovieCancelButton.getScene().getWindow();
        stage.close();
    }
}