package com.example.movietheater.controllers;

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
    private TextField editShowTimeRoonNumberTextField;

    /** TextField for editing the time of the showtime. */
    @FXML
    private TextField editShowTimeTimeTextField;

    /** TextField for editing the date of the showtime. */
    @FXML
    private TextField editShowTimeDateTextField;

    /** TextField for displaying or editing the image file location. */
    @FXML
    private TextField editShowTimeImageLocationTextField;

    /** Button to save the edited showtime. */
    @FXML
    private Button EditShowtimeSaveButton;

    /** Button to cancel the editing process. */
    @FXML
    private Button editShowtimeCancelButton;

    /** Button to browse for an image file. */
    @FXML
    private Button EditShowtimeCancelButton;

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
        editShowTimeRoonNumberTextField.setText(String.valueOf(showtime.getpRoomID()));
        editShowTimeTimeTextField.setText(showtime.getpTime() != null ? showtime.getpTime().toString() : "");
        editShowTimeDateTextField.setText((showtime.getpDate()!= null ? showtime.getpDate().toString() : ""));
}

    /**
     * Handles saving the edited showtime.
     * <p>
     * Validates and saves the changes to the showtime.
     * Currently prints a message to the console; extend this method to update the model.
     * </p>
     */
    @FXML
    private void onEditShowtimeSaveButtonClick() {
        try{
           int movieID = Integer.parseInt(editShowTimeMovieIDTextField.getText());
           int roomID = Integer.parseInt((editShowTimeRoonNumberTextField.getText()));
            LocalTime time = LocalTime.parse(editShowTimeTimeTextField.getText());
            LocalDate date = LocalDate.parse(editShowTimeDateTextField.getText());
            currentShowtime.setpMovieID(movieID);
            currentShowtime.setpRoomID(roomID);
            currentShowtime.setTime(time);
            currentShowtime.setDate(date);

            Stage s = (Stage) EditShowtimeSaveButton.getScene().getWindow();
            s.close();
            System.out.println("Showtime edited: " + currentShowtime.getShowTimeID());
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "Something went wrong").showAndWait();
        }

    }

    /**
     * Handles cancelling the edit showtime operation.
     * <p>
     * Closes the current window without saving changes.
     * </p>
     */
    @FXML
    private void onEditShowtimeCancelButtonClick() {
        Stage s = (Stage) editShowtimeCancelButton.getScene().getWindow();
        s.close();
    }
}
