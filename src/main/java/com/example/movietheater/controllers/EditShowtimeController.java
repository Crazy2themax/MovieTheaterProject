package com.example.movietheater.controllers;

import com.example.movietheater.Models.ShowTime;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;
import com.example.movietheater.Models.Movie;
import com.example.movietheater.Models.DataStore;


/**
 * Controller class for the "Edit Showtime" view.
 * <p>
 * Handles the interaction for editing an existing showtime, including movie ID,
 * room number, time, date, and an optional image. Provides functionality to save changes,
 * cancel editing, or browse for a new image.
 * </p>
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

    /**
     * Initializes the controller.
     * <p>
     * Called automatically after the FXML file has been loaded.
     * Can be used to preload the selected showtime data into the text fields.
     * </p>
     */
    @FXML
    public void initialize() {
        // preload selected showtime data into fields
    }
    private ShowTime currentShowtime;
    public void setShowTime(ShowTime showtime){
        this.currentShowtime = showtime;

        editShowTimeMovieIDTextField.setText(String.valueOf(showtime.getpMovieID()));
        editShowTimeRoomNumberTextField.setText(String.valueOf(showtime.getpRoomID()));
        editShowTimeTimeTextField.setText(showtime.getpTime() != null ? showtime.getpTime().toString() : "");
        editShowTimeDateTextField.setText((showtime.getpDate()!= null ? showtime.getpDate().toString() : ""));
}

    @FXML
    private void onEditShowtimeSaveButtonClick() {
        try {
            String movieIdText = editShowTimeMovieIDTextField.getText().trim();
            if (movieIdText.isEmpty()) {
                showError("Movie ID cannot be empty.");
                return;
            }

            int movieID;
            try {
                movieID = Integer.parseInt(movieIdText);
            } catch (NumberFormatException e) {
                showError("Movie ID must be a number.\nInvalid value: \"" + movieIdText + "\"");
                return;
            }

            var movie = DataStore.getMovieById(movieID);
            if (movie == null) {
                showError("No movie found with ID: " + movieID);
                return;
            }

            // Validate Room Number
            String roomText = editShowTimeRoomNumberTextField.getText().trim();
            if (roomText.isEmpty()) {
                showError("Room Number cannot be empty.");
                return;
            }
            int roomID;
            try {
                roomID = Integer.parseInt(roomText);
            } catch (NumberFormatException e) {
                showError("Room Number must be a number.\nInvalid value: \"" + roomText + "\"");
                return;
            }
            if (roomID < 1 || roomID > 5) {
                showError("Room number must be between 1 and 5.");
                return;
            }

            String timeText = editShowTimeTimeTextField.getText().trim();
            if (timeText.isEmpty()) {
                showError("Time cannot be empty.");
                return;
            }

            LocalTime time;
            try {
                time = LocalTime.parse(timeText);
            } catch (Exception e) {
                showError("Time must be in format HH:MM (e.g., 14:30).\nInvalid value: \"" + timeText + "\"");
                return;
            }

            String dateText = editShowTimeDateTextField.getText().trim();
            if (dateText.isEmpty()) {
                showError("Date cannot be empty.");
                return;
            }

            LocalDate date;
            try {
                date = LocalDate.parse(dateText);
            } catch (Exception e) {
                showError("Date must be in format YYYY-MM-DD.\nInvalid value: \"" + dateText + "\"");
                return;
            }

            LocalTime newStart = time;
            LocalTime newEnd = time.plusMinutes(movie.getpDuration());

            for (ShowTime existing : DataStore.showTimes) {

                // skip the current showtime so it doesn't conflict with itself
                if (existing.getShowTimeID() == currentShowtime.getShowTimeID()) {
                    continue;
                }

                if (existing.getpRoomID() == roomID && existing.getpDate().equals(date)) {
                    LocalTime existingStart = existing.getpTime();
                    LocalTime existingEnd = existing.getpTime().plusMinutes(existing.getpDuration());

                    boolean overlap = !newEnd.isBefore(existingStart) && !newStart.isAfter(existingEnd);
                    if (overlap) {
                        showError("This room is already booked for that time.");
                        return;
                    }
                }
            }

            currentShowtime.setpMovieID(movieID);
            currentShowtime.setpRoomID(roomID);
            currentShowtime.setpTime(time);
            currentShowtime.setpDate(date);
            currentShowtime.setpTitle(movie.getpTitle());
            currentShowtime.setpDuration(movie.getpDuration());

            // Close window
            Stage s = (Stage) editShowtimeSaveButton.getScene().getWindow();
            s.close();

        } catch (Exception e) {
            showError("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void showError(String msg) {
        new Alert(Alert.AlertType.ERROR, msg).showAndWait();
    }

    @FXML
    private void onEditShowtimeCancelButtonClick() {
        Stage s = (Stage) editShowtimeCancelButton.getScene().getWindow();
        s.close();
    }
}
