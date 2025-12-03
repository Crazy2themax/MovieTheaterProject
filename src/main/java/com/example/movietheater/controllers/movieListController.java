package com.example.movietheater.controllers;

import com.example.movietheater.Models.DataStore;
import com.example.movietheater.Models.Movie;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Controller class for the Movie List view.
 * <p>
 * Manages the display and manipulation of the movie list in a TableView.
 * Provides functionality to add, edit, and delete movies.
 * </p>
 *
 * @author Movie Theater Application
 * @version 1.0
 */
public class movieListController {

    /** TableView displaying all movies. */
    @FXML
    private TableView<Movie> movieTableView;

    /** Column displaying movie IDs. */
    @FXML
    private TableColumn<Movie, Integer> MovieIDColumnMovieList;

    /** Column displaying movie titles. */
    @FXML
    private TableColumn<Movie, String> MovieTitleColumnMovieList;

    /** Column displaying movie durations. */
    @FXML
    private TableColumn<Movie, Integer> MovieDurationColumnMovieList;

    /** Button to return to the previous view. */
    @FXML
    private Button backButton;

    /**
     * Initializes the controller.
     * <p>
     * Sets up the table columns with cell value factories and binds
     * the TableView to the DataStore's movie list.
     * </p>
     */
    @FXML
    public void initialize() {
        // Set up table columns
        this.MovieIDColumnMovieList.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getpMovieID()).asObject()
        );
        this.MovieTitleColumnMovieList.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getpTitle())
        );
        this.MovieDurationColumnMovieList.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getpDuration()).asObject()
        );

        // Use DataStore.movieList directly
        this.movieTableView.setItems(DataStore.movieList);
    }

    /**
     * Handles the add movie button click event.
     * <p>
     * Opens a new window for adding a movie. Refreshes the table when the window closes.
     * </p>
     */
    @FXML
    private void onAddMovieMovieListClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/AddMovie.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Add Movie");
            stage.setScene(new Scene(root));

            // Refresh table when window closes
            stage.setOnHidden(e -> this.movieTableView.refresh());

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the edit movie button click event.
     * <p>
     * Opens a window for editing the selected movie. Shows a warning if no movie is selected.
     * Refreshes the table when the window closes.
     * </p>
     */
    @FXML
    private void onEditMovieMovieListClick() {
        Movie selected = this.movieTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a movie to edit.").showAndWait();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/EditMovie.fxml"));
            Parent root = loader.load();

            EditMovieController controller = loader.getController();
            controller.setMovie(selected);

            Stage stage = new Stage();
            stage.setTitle("Edit Movie");
            stage.setScene(new Scene(root));

            // Refresh table when window closes
            stage.setOnHidden(e -> this.movieTableView.refresh());

            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the delete movie button click event.
     * <p>
     * Deletes the selected movie from the DataStore. Shows a warning if no movie is selected.
     * </p>
     */
    @FXML
    private void onDeleteMovieMovieListClick() {
        Movie selected = this.movieTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a movie to delete.").showAndWait();
            return;
        }

        // Remove from DataStore (which automatically updates the TableView)
        DataStore.movieList.remove(selected);

        System.out.println("Deleted movie: " + selected.getpTitle());
    }

    /**
     * Handles the back button click event.
     * <p>
     * Closes the current window and returns to the previous view.
     * </p>
     */
    @FXML
    private void onBackButtonMovieListClick() {
        Stage stage = (Stage) this.backButton.getScene().getWindow();
        stage.close();
    }
}
