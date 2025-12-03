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
 * Controller class for the "Add Showtime" view.
 * <p>
 * Handles user interaction for adding new showtimes to the system.
 * Validates input data including movie ID, room number, time, and date.
 * Checks for scheduling conflicts before adding the showtime.
 * </p>
 *
 * @author Movie Theater Application
 * @version 1.0
 */
public class AddShowtimeController {

    /** TextField for entering the movie ID. */
    @FXML
    private TextField addShowTimeMovieIDTextField;

    /** TextField for entering the room number. */
    @FXML
    private TextField addShowTimeRoomNumberTextField;

    /** TextField for entering the showtime time. */
    @FXML
    private TextField addShowTimeTimeTextField;

    /** TextField for entering the showtime date. */
    @FXML
    private TextField addShowTimeDateTextField;

    /** Button to save the new showtime. */
    @FXML
    private Button addShowtimeSaveButton;

    /** Button to cancel adding a showtime. */
    @FXML
    private Button addShowTimeCancelButton;

    /**
     * Handles the save button click event.
     * <p>
     * Validates all input fields, checks for scheduling conflicts,
     * and adds the new showtime to the DataStore if validation passes.
     * </p>
     */
    @FXML
    private void onAddShowtimeSaveButtonClick() {

        // Validate Movie ID
        String movieIdText = this.addShowTimeMovieIDTextField.getText().trim();
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

        // Lookup movie in DataStore
        Movie movie = DataStore.getMovieById(movieID);
        if (movie == null) {
            this.showError("No movie found with ID: " + movieID);
            return;
        }

        // Validate Room Number
        String roomText = this.addShowTimeRoomNumberTextField.getText().trim();
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
        String timeText = this.addShowTimeTimeTextField.getText().trim();
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
        String dateText = this.addShowTimeDateTextField.getText().trim();
        if (dateText.isEmpty()) {
            this.showError("Date cannot be empty.");
            return;
        }

        LocalDate date;
        try {
            date = LocalDate.parse(dateText);
        } catch (Exception e) {
            this.showError("Date must be in format YYYY-MM-DD (e.g., 2025-12-31).\nInvalid value: \"" + dateText + "\"");
            return;
        }

        // Check for scheduling conflicts
        LocalTime newStart = time;
        LocalTime newEnd = time.plusMinutes(movie.getpDuration());

        for (ShowTime existing : DataStore.showTimes) {
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

        // Create and save the new showtime
        ShowTime newShowtime = new ShowTime(
                DataStore.showTimes.size() + 1,
                date,
                time,
                movieID,
                roomID,
                movie.getpDuration()
        );

        newShowtime.setpTitle(movie.getpTitle());
        newShowtime.setpDuration(movie.getpDuration());

        DataStore.showTimes.add(newShowtime);

        // Close window
        ((Stage) this.addShowtimeSaveButton.getScene().getWindow()).close();

        System.out.println("Showtime added: " + newShowtime.getpDate() +
                ", Movie: " + newShowtime.getpTitle() +
                ", Duration: " + newShowtime.getpDuration());
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
     * Closes the window without saving any data.
     * </p>
     */
    @FXML
    private void onAddShowtimeCancelButtonClick() {
        Stage stage = (Stage) this.addShowTimeCancelButton.getScene().getWindow();
        stage.close();
    }
}
