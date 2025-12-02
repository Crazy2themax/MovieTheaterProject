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

/**
 * Controller class for the "Add Showtime" view.
 * <p>
 * This class handles the user interactions for adding a new showtime,
 * including movie ID, room number, time, date, and an optional image.
 * </p>
 */
public class addShowtimeController {

    /** TextField for entering the movie ID. */
    @FXML
    private TextField addShowTimeMovieIDTextField;

    /** TextField for entering the room number for the showtime. */
    @FXML
    private TextField addShowTimeRoonNumberTextField;

    /** TextField for entering the time of the showtime. */
    @FXML
    private TextField addShowTimeTimeTextField;

    /** TextField for entering the date of the showtime. */
    @FXML
    private TextField addShowTimeDateTextField;

    /** TextField for entering or displaying the image file location. */
    @FXML
    private TextField addShowTimeImageLocationTextField;

    /** Button to save the showtime information. */
    @FXML
    private Button AddShowtimeSaveButton;

    /** Button to cancel adding a showtime. */
    @FXML
    private Button AddShowtimeCancelButton;


    /**
     * Initializes the controller.
     * <p>
     * Called automatically after the FXML file has been loaded.
     * Can be used to initialize dropdowns, pickers, or other controls.
     * </p>
     */
    @FXML
    public void initialize() {
        // initialize dropdowns/pickers if any
    }

    /**
     * Handles saving a showtime.
     * <p>
     * Reads input from all text fields, prints the information to the console,
     * and can be extended to validate and store the showtime in a model or list.
     * </p>
     */
    @FXML
    private void AddShowtimeSaveButton() {
        try {
            int movieID = Integer.parseInt(addShowTimeDateTextField.getText());
            int roomID = Integer.parseInt(addShowTimeRoonNumberTextField.getText());
            LocalTime time = LocalTime.parse(addShowTimeTimeTextField.getText());
            LocalDate date = LocalDate.parse(addShowTimeDateTextField.getText());

            ShowTime newShowtime = new ShowTime(
                    DataStore.showTimes.size() + 1, date, time, movieID, roomID, 1
            );

            newShowtime.setDate(date);
            newShowtime.setTime(time);

            DataStore.showTimes.add(newShowtime);
            Stage s = (Stage) AddShowtimeSaveButton.getScene().getWindow();
            s.close();
            System.out.println("Showtime added:" + newShowtime.getpDate());
        }catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Invalid input. Check ID's , Time , and date format.").showAndWait();
        }
    }

    /**
     * Handles cancelling the add showtime operation.
     * <p>
     * Closes the current window without saving any data.
     * </p>
     */
    @FXML
    private void AddShowtimeCancelButton() {
        Stage stage = (Stage) AddShowtimeCancelButton.getScene().getWindow();
        stage.close();
    }
}
