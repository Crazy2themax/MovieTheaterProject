package com.example.movietheater.controllers;

import com.example.movietheater.Models.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Controller class for the Movie List view.
 * Handles displaying, adding, editing, and deleting movies.
 */
public class movieListController {

    @FXML
    private ListView<Movie> movieListView;

    @FXML
    private Button addMovieButton;

    @FXML
    private Button editMovieButton;

    @FXML
    private Button DeleteMovieButton;

    @FXML
    private Button backButton;

    /**
     * Initializes the controller.
     * Loads sample movies into the ListView.
     */
    @FXML
    public void initialize() {
        movieListView.getItems().addAll(
                new Movie(1, "Moana", 107),
                new Movie(2, "Avengers Endgame", 181),
                new Movie(3, "Hangover", 100)
        );
    }

    /** Opens the AddMovie screen. */
    @FXML
    private void onAddMovie() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/AddMovie.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Add Movie");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Opens the EditMovie screen for the selected movie. */
    @FXML
    private void onEditMovie() {
        Movie selected = movieListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(AlertType.WARNING, "Please select a movie to edit.").showAndWait();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/EditMovie.fxml"));
            Parent root = loader.load();

            EditMovieController controller = loader.getController();
            controller.setMovie(selected); // pass selected movie to edit form

            Stage stage = new Stage();
            stage.setTitle("Edit Movie");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Deletes the selected movie from the list. */
    @FXML
    private void onDeleteMovie() {
        Movie selected = movieListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(AlertType.WARNING, "Please select a movie to delete.").showAndWait();
            return;
        }

        movieListView.getItems().remove(selected);
        System.out.println("Deleted movie: " + selected.getpTitle());
    }

    /** Closes the movie list window. */
    @FXML
    private void onBack() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
