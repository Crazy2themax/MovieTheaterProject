package com.example.movietheater.controllers;

import com.example.movietheater.Models.DataStore;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.movietheater.Models.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Controller class for the Movie List view.
 * Handles displaying, adding, editing, and deleting movies.
 */
public class movieListController {

    @FXML
    private TableView<Movie> movieTableView;

    @FXML
    private TableColumn<Movie, Integer> MovieIDColumnMovieList;

    @FXML
    private TableColumn<Movie, String> MovieTitleColumnMovieList;

    @FXML
    private TableColumn<Movie, Integer> MovieDurationColumnMovieList;

    @FXML
    private Button backButton;

    @FXML
    private ObservableList<Movie> movieList = FXCollections.observableArrayList();

    /**
     * Initializes the controller.
     * Loads sample movies into the ListView.
     */
    @FXML
    public void initialize() {
        // Populate DataStore.movieList only if empty
            if (DataStore.movieList.isEmpty()) {
                DataStore.movieList.addAll(
                        new Movie(1, "Moana", 107),
                        new Movie(2, "Avengers Endgame", 181),
                        new Movie(3, "Hangover", 100)
                );
            }

            // Set up table
            MovieIDColumnMovieList.setCellValueFactory(
                    cellData -> new SimpleIntegerProperty(cellData.getValue().getpMovieID()).asObject()
            );
            MovieTitleColumnMovieList.setCellValueFactory(
                    cellData -> new SimpleStringProperty(cellData.getValue().getpTitle())
            );
            MovieDurationColumnMovieList.setCellValueFactory(
                    cellData -> new SimpleIntegerProperty(cellData.getValue().getpDuration()).asObject()
            );

            movieTableView.setItems(DataStore.movieList); // Use DataStore.movieList
        }



    /** Opens the AddMovie screen. */
    @FXML
    private void onAddMovieMovieListClick() {
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
    private void onEditMovieMovieListClick() {
        Movie selected = movieTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a movie to edit.").showAndWait();
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
    private void onDeleteMovieMovieListClick() {
        Movie selected = movieTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a movie to delete.").showAndWait();
            return;
        }

        movieTableView.getItems().remove(selected);
        System.out.println("Deleted movie: " + selected.getpTitle());
    }

    @FXML
    private void onBackButtonMovieListClick() {
        Stage s = (Stage) backButton.getScene().getWindow();
        s.close();
    }
}
