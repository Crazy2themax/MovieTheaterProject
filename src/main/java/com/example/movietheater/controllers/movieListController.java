package com.example.movietheater.controllers;

import com.example.movietheater.Models.DataStore;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.movietheater.Models.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
    public void initialize() {
        // Set up table columns
        MovieIDColumnMovieList.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getpMovieID()).asObject()
        );
        MovieTitleColumnMovieList.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getpTitle())
        );
        MovieDurationColumnMovieList.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getpDuration()).asObject()
        );

        // Use DataStore.movieList directly
        movieTableView.setItems(DataStore.movieList);
    }

    @FXML
    private void onAddMovieMovieListClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/AddMovie.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Add Movie");
            stage.setScene(new Scene(root));

            // Refresh table when window closes
            stage.setOnHidden(e -> movieTableView.refresh());

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
            controller.setMovie(selected);

            Stage stage = new Stage();
            stage.setTitle("Edit Movie");
            stage.setScene(new Scene(root));

            // Refresh table when window closes
            stage.setOnHidden(e -> movieTableView.refresh());

            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onDeleteMovieMovieListClick() {
        Movie selected = movieTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a movie to delete.").showAndWait();
            return;
        }

        // Remove from DataStore (which automatically updates the TableView)
        DataStore.movieList.remove(selected);

        System.out.println("Deleted movie: " + selected.getpTitle());
    }

    @FXML
    private void onBackButtonMovieListClick() {
        Stage s = (Stage) backButton.getScene().getWindow();
        s.close();
    }
}