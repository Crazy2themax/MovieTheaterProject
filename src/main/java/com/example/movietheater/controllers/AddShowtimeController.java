package com.example.movietheater.controllers;

import com.example.movietheater.Models.DataStore;
import com.example.movietheater.Models.ShowTime;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddShowtimeController {

    @FXML
    private TextField addShowTimeMovieIDTextField;

    @FXML
    private TextField addShowTimeRoomNumberTextField;

    @FXML
    private TextField addShowTimeTimeTextField;

    @FXML
    private TextField addShowTimeDateTextField;

    @FXML
    private Button addShowtimeSaveButton;

    @FXML
    private Button addShowTimeCancelButton;

    @FXML
    private void onAddShowtimeSaveButtonClick() {

        // Validate Movie ID
        String movieIdText = addShowTimeMovieIDTextField.getText().trim();
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

        // Lookup movie in DataStore
        var movie = DataStore.getMovieById(movieID);
        if (movie == null) {
            showError("No movie found with ID: " + movieID);
            return;
        }
        // Validate Room Number
        String roomText = addShowTimeRoomNumberTextField.getText().trim();
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

        // Validate Time
        String timeText = addShowTimeTimeTextField.getText().trim();
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

        // Validate Date
        String dateText = addShowTimeDateTextField.getText().trim();
        if (dateText.isEmpty()) {
            showError("Date cannot be empty.");
            return;
        }
        LocalDate date;
        try {
            date = LocalDate.parse(dateText);
        } catch (Exception e) {
            showError("Date must be in format YYYY-MM-DD (e.g., 2025-12-31).\nInvalid value: \"" + dateText + "\"");
            return;
        }

        // Save Showtime and set movie title/duration
        ShowTime newShowtime = new ShowTime(
                DataStore.showTimes.size() + 1,
                date,
                time,
                movieID,
                roomID,
                1
        );
        LocalTime newStart = time; // the time entered
        LocalTime newEnd = time.plusMinutes(movie.getpDuration()); // add movie duration

        for (ShowTime existing : DataStore.showTimes) {
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

        newShowtime.setpTitle(movie.getpTitle());
        newShowtime.setpDuration(movie.getpDuration());

        DataStore.showTimes.add(newShowtime);

        // Close window
        ((Stage) addShowtimeSaveButton.getScene().getWindow()).close();

        System.out.println("Showtime added: " + newShowtime.getpDate() +
                ", Movie: " + newShowtime.getpTitle() +
                ", Duration: " + newShowtime.getpDuration());


    }

    private void showError(String msg) {
        new Alert(Alert.AlertType.ERROR, msg).showAndWait();
    }

    @FXML
    private void onAddShowtimeCancelButtonClick() {
        Stage s = (Stage) addShowTimeCancelButton.getScene().getWindow();
        s.close();
    }
}
