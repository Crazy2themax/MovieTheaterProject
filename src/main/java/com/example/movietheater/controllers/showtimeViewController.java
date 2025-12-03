package com.example.movietheater.controllers;

import com.example.movietheater.Models.DataStore;
import com.example.movietheater.Models.Movie;
import com.example.movietheater.Models.ShowTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

/**
 * Controller class for the "Showtime View" in the Movie Theater Application.
 * <p>
 * Manages the display and interaction of showtimes in the application, including
 * adding, editing, deleting showtimes, viewing the movie list, and logging out.
 * Handles binding data to the TableView and its columns.
 * </p>
 *
 * @author Maxim Gosselin
 * @version 1.0
 */
public class showtimeViewController {

    /** Button for logging out of the showtime manager view. */
    @FXML
    private Button LogOutShowTimeMangerViewButton;

    /** Button to delete the selected showtime. */
    @FXML
    private Button ShowTimeDeleteButton;

    /** TableView displaying all showtimes. */
    @FXML
    private TableView<ShowTime> showtimeTableView;

    /** Column displaying the title of the movie for each showtime. */
    @FXML
    private TableColumn<ShowTime, String> movieTitleColumn;

    /** Column displaying the room number for each showtime. */
    @FXML
    private TableColumn<ShowTime, Integer> roomColumn;

    /** Column displaying the start time of each showtime. */
    @FXML
    private TableColumn<ShowTime, String> timeColumn;

    /** Column displaying the date of each showtime. */
    @FXML
    private TableColumn<ShowTime, String> dateColumn;

    /** Column displaying the duration of the movie for each showtime. */
    @FXML
    private TableColumn<ShowTime, Integer> durationColumn;

    /** Observable list used to populate the TableView. */
    private ObservableList<ShowTime> showtimeObservableList;

    /**
     * Initializes the controller.
     * <p>
     * Sets up the TableView columns and binds them to the appropriate
     * properties of the ShowTime objects. Also sets the TableView's
     * items to the DataStore's list of showtimes.
     * </p>
     */
    @FXML
    public void initialize() {
        showtimeTableView.setItems(DataStore.showTimes);
        showtimeObservableList = FXCollections.observableList(DataStore.showTimes);

        // Movie title column
        movieTitleColumn.setCellValueFactory(cellData -> {
            Movie m = DataStore.getMovieById(cellData.getValue().getpMovieID());
            return new javafx.beans.property.SimpleStringProperty(
                    m != null ? m.getpTitle() : "Unknown"
            );
        });

        // Room column
        roomColumn.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getpRoomID()).asObject()
        );

        // Time column
        timeColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue().getpTime() != null) {
                return new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getpTime().format(DateTimeFormatter.ofPattern("HH:mm"))
                );
            }
            return new javafx.beans.property.SimpleStringProperty("Not set");
        });

        // Date column
        dateColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue().getpDate() != null) {
                return new javafx.beans.property.SimpleStringProperty(cellData.getValue().getpDate().toString());
            }
            return new javafx.beans.property.SimpleStringProperty("Not set");
        });

        // Duration column
        durationColumn.setCellValueFactory(cellData -> {
            Movie m = DataStore.getMovieById(cellData.getValue().getpMovieID());
            return new javafx.beans.property.SimpleIntegerProperty(m != null ? m.getpDuration() : 0).asObject();
        });

        showtimeTableView.setItems(showtimeObservableList);
    }

    /**
     * Handles the "Add ShowTime" button click.
     * <p>
     * Opens the AddShowtime view in a new window and refreshes the TableView
     * after the window is closed.
     * </p>
     */
    @FXML
    private void onShowTimeAddButtonCLick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/AddShowtime.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Add Showtime");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setOnHidden(e -> showtimeTableView.refresh());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the "Edit ShowTime" button click.
     * <p>
     * Opens the EditShowtime view for the selected showtime.
     * If no showtime is selected, displays a warning alert.
     * Refreshes the TableView after the edit window is closed.
     * </p>
     */
    @FXML
    private void onShowTimeEditButtonClick() {
        ShowTime selected = showtimeTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a showtime to edit.").showAndWait();
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/EditShowtime.fxml"));
            Parent root = loader.load();

            EditShowtimeController controller = loader.getController();
            controller.setShowTime(selected);

            Stage stage = new Stage();
            stage.setTitle("Edit Showtime");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setOnHidden(e -> showtimeTableView.refresh());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the "Delete ShowTime" button click.
     * <p>
     * Removes the selected showtime from the DataStore.
     * If no showtime is selected, displays a warning alert.
     * </p>
     */
    @FXML
    private void onShowTimeDeleteButtonClick() {
        ShowTime selected = showtimeTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a showtime to delete.").showAndWait();
            return;
        }

        DataStore.showTimes.remove(selected);
        showtimeTableView.refresh();
    }

    /**
     * Handles the "Movie List" button click.
     * <p>
     * Opens the MovieList view in a new window.
     * </p>
     */
    @FXML
    private void onShowTimeMovieListButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/MovieList.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Movie List");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the "Logout" button click.
     * <p>
     * Closes the current showtime manager view window.
     * </p>
     */
    @FXML
    private void onShowTimeLogoutButtonClick() {
        Stage currentStage = (Stage) LogOutShowTimeMangerViewButton.getScene().getWindow();
        currentStage.close();
    }
}
