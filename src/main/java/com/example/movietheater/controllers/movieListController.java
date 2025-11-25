package com.example.movietheater.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Controller class for the "com.example.movietheater.Models.Movie List" view.
 * <p>
 * Handles displaying the list of movies and provides functionality to add,
 * edit, or delete movies. Also allows navigating back to the previous screen.
 * </p>
 */
public class movieListController {

    /** ListView displaying the movies. Replace '?' with the com.example.movietheater.Models.Movie model when available. */
    @FXML
    private ListView<?> movieListView;

    /** Button to open the Add com.example.movietheater.Models.Movie screen. */
    @FXML
    private Button addMovieButton;

    /** Button to edit the selected movie. */
    @FXML
    private Button editMovieButton;

    /** Button to delete the selected movie. */
    @FXML
    private Button DeleteMovieButton;

    /** Button to go back to the previous screen. */
    @FXML
    private Button backButton;

    /**
     * Initializes the controller.
     * <p>
     * Loads movies into the ListView when the view is initialized.
     * </p>
     */
    @FXML
    public void initialize() {
        // load movies into movieListView
    }

    /**
     * Opens the Add com.example.movietheater.Models.Movie view.
     */
    @FXML
    private void onAddMovie() {
        System.out.println("Open Add com.example.movietheater.Models.Movie screen.");
        // open AddMovie view
    }

    /**
     * Handles editing the selected movie.
     * <p>
     * If no movie is selected, shows a warning alert.
     * Otherwise, opens the edit movie view for the selected movie.
     * </p>
     */
    @FXML
    private void onEditMovie() {
        Object selected = movieListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            Alert a = new Alert(AlertType.WARNING, "Please select a movie to edit.");
            a.showAndWait();
            return;
        }
        System.out.println("Edit movie: " + selected);
        // get selected and open edit view
    }

    /**
     * Handles deleting the selected movie.
     * <p>
     * If no movie is selected, shows a warning alert.
     * Otherwise, confirms and deletes the movie from the model/list.
     * </p>
     */
    @FXML
    private void onDeleteMovie() {
        Object selected = movieListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            Alert a = new Alert(AlertType.WARNING, "Please select a movie to delete.");
            a.showAndWait();
            return;
        }
        System.out.println("Delete movie: " + selected);
        // TODO: confirm and delete from model/list
    }

    /**
     * Handles navigating back to the previous screen.
     * <p>
     * Closes the current stage/window.
     * </p>
     */
    @FXML
    private void onBack() {
        Stage s = (Stage) backButton.getScene().getWindow();
        s.close();
    }
}
