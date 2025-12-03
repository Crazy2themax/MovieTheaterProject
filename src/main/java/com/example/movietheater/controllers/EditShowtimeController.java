package com.example.movietheater.controllers;

import com.example.movietheater.Models.DataStore;
import com.example.movietheater.Models.Movie;
import com.example.movietheater.Models.ShowTime;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Controller class for the "Edit Showtime" view.
 * <p>
 * Handles the interaction for editing an existing showtime, including movie ID,
 * room number, time, and date. Provides functionality to save changes or cancel editing.
 * Validates all input and checks for scheduling conflicts.
 * </p>
 *
 * @author Movie Theater Application
 * @version 1.0
 */
public class EditShowtimeController {

    /** TextField for editing the movie ID associated with the showtime. */
    @FXML
    private TextField editShowTimeMovieIDTextField;

    /** TextField for editing the room number of the showtime. */
    @FXML
    private TextField editShowTimeRoomNumberTextField;

    /** TextField for editing the time of the showtime. */
    @FXML
    private TextField editShowTimeTimeTextField;

    /** TextField for editing the date of the showtime. */
    @FXML
    private TextField editShowTimeDateTextField;

    /** Button to save the edited showtime. */
    @FXML
    private Button editShowtimeSaveButton;

    /** Button to cancel the editing process. */
    @FXML
    private Button editShowtimeCancelButton;

    /** The showtime being edited. */
    private ShowTime aCurrentShowtime;

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
     * Sets the showtime to be edited and populates the form fields.
     *
     * @param pShowtime the showtime to edit
     */
    public void setShowTime(ShowTime pShowtime) {
        this.aCurrentShowtime = pShowtime;

        this.editShowTimeMovieIDTextField.setText(String.valueOf(pShowtime.getpMovieID()));
        this.editShowTimeRoomNumberTextField.setText(String.valueOf(pShowtime.getpRoomID()));
        this.editShowTimeTimeTextField.setText(
                pShowtime.getpTime() != null ? pShowtime.getpTime().toString() : ""
        );
        this.editShowTimeDateTextField.setText(
                pShowtime.getpDate() != null ? pShowtime.getpDate().toString() : ""
        );
    }

    /**
     * Handles the save button click event.
     * <p>
     * Validates all input fields, checks for scheduling conflicts (excluding the current showtime),
     * and updates the showtime if validation passes.
     * </p>
     */
    @FXML
    private void onEditShowtimeSaveButtonClick() {
        try {
            // Validate Movie ID
            String movieIdText = this.editShowTimeMovieIDTextField.getText().trim();
            if (movieIdText.isEmpty()) {
                this.showError("Movie ID cannot be empty.");
                return;
            }

            int movieID;
            try {
                movieID = Integer.parseInt(movieIdText);
            } catch (NumberFormatException e) {
                this.showError("Movie ID must be a number.\nInvalid value: \"" + movieIdText + "\"");
                return;
            }

            Movie movie = DataStore.getMovieById(movieID);
            if (movie == null) {
                this.showError("No movie found with ID: " + movieID);
                return;
            }

            // Validate Room Number
            String roomText = this.editShowTimeRoomNumberTextField.getText().trim();
            if (roomText.isEmpty()) {
                this.showError("Room Number cannot be empty.");
                return;
            }

            int roomID;
            try {
                roomID = Integer.parseInt(roomText);
            } catch (NumberFormatException e) {
                this.showError("Room Number must be a number.\nInvalid value: \"" + roomText + "\"");
                return;
            }

            if (roomID < 1 || roomID > 5) {
                this.showError("Room number must be between 1 and 5.");
                return;
            }

            // Validate Time
            String timeText = this.editShowTimeTimeTextField.getText().trim();
            if (timeText.isEmpty()) {
                this.showError("Time cannot be empty.");
                return;
            }

            LocalTime time;
            try {
                time = LocalTime.parse(timeText);
            } catch (Exception e) {
                this.showError("Time must be in format HH:MM (e.g., 14:30).\nInvalid value: \"" + timeText + "\"");
                return;
            }

            // Validate Date
            String dateText = this.editShowTimeDateTextField.getText().trim();
            if (dateText.isEmpty()) {
                this.showError("Date cannot be empty.");
                return;
            }

            LocalDate date;
            try {
                date = LocalDate.parse(dateText);
            } catch (Exception e) {
                this.showError("Date must be in format YYYY-MM-DD.\nInvalid value: \"" + dateText + "\"");
                return;
            }

            // Check for scheduling conflicts (excluding the current showtime)
            LocalTime newStart = time;
            LocalTime newEnd = time.plusMinutes(movie.getpDuration());

            for (ShowTime existing : DataStore.showTimes) {
                // Skip the current showtime so it doesn't conflict with itself
                if (existing.getaShowTimeID() == this.aCurrentShowtime.getaShowTimeID()) {
                    continue;
                }

                if (existing.getpRoomID() == roomID && existing.getpDate().equals(date)) {
                    LocalTime existingStart = existing.getpTime();
                    LocalTime existingEnd = existing.getpTime().plusMinutes(existing.getpDuration());

                    boolean overlap = !newEnd.isBefore(existingStart) && !newStart.isAfter(existingEnd);
                    if (overlap) {
                        this.showError("This room is already booked for that time.");
                        return;
                    }
                }
            }

            // Update the showtime
            this.aCurrentShowtime.setpMovieID(movieID);
            this.aCurrentShowtime.setpRoomID(roomID);
            this.aCurrentShowtime.setpTime(time);
            this.aCurrentShowtime.setpDate(date);
            this.aCurrentShowtime.setpTitle(movie.getpTitle());
            this.aCurrentShowtime.setpDuration(movie.getpDuration());

            // Close window
            Stage stage = (Stage) this.editShowtimeSaveButton.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            this.showError("Unexpected error: " + e.getMessage());
            e.printStackTrace();
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
     * Closes the window without saving any changes.
     * </p>
     */
    @FXML
    private void onEditShowtimeCancelButtonClick() {
        Stage stage = (Stage) this.editShowtimeCancelButton.getScene().getWindow();
        stage.close();
    }
}
