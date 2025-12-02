
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

public class showtimeViewController {

    @FXML
    private Button ShowTimeLogoutButton;

    @FXML
    private Button ShowTimeEditButton;

    @FXML
    private Button ShowTimeAddButton;

    @FXML
    private Button ShowTimeMovieListButton;

    @FXML
    private Button ShowTimeDeleteButton;

    @FXML
    private TableView<ShowTime> showtimeTableView;

    @FXML
    private TableColumn<ShowTime, String> movieTitleColumn;

    @FXML
    private TableColumn<ShowTime, String> timeColumn;

    @FXML
    private TableColumn<ShowTime, String> dateColumn;

    @FXML
    private TableColumn<ShowTime, Integer> durationColumn;

    private ObservableList<ShowTime> showtimeObservableList;


    @FXML
    public void initialize() {
        showtimeObservableList = FXCollections.observableList(DataStore.showTimes);
        showtimeTableView.setItems(showtimeObservableList);

        // Movie title column
        movieTitleColumn.setCellValueFactory(cellData -> {
            Movie m = DataStore.getMovieById(cellData.getValue().getpMovieID());
            return new javafx.beans.property.SimpleStringProperty(
                    m != null ? m.getpTitle() : "Unknown"
            );
        });

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
                return new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getpDate().toString()
                );
            }
            return new javafx.beans.property.SimpleStringProperty("Not set");
        });

        // Movie duration column
        durationColumn.setCellValueFactory(cellData -> {
            Movie m = DataStore.getMovieById(cellData.getValue().getpMovieID());
            return new javafx.beans.property.SimpleIntegerProperty(
                    m != null ? m.getpDuration() : 0
            ).asObject();
        });


    }


    @FXML
    private void onShowTimeAddButtonCLick() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/movietheater/AddShowtime.fxml")
            );
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Add Showtime");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void onShowTimeEditButtonClick() {
        ShowTime selected = showtimeTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a showtime to edit.").showAndWait();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/movietheater/EditShowtime.fxml")
            );
            Parent root = loader.load();

            EditShowtimeController controller = loader.getController();
            controller.setShowTime(selected);

            Stage stage = new Stage();
            stage.setTitle("Edit Showtime");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void onShowTimeDeleteButtonClick() {
        ShowTime selected = showtimeTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a showtime to delete.").showAndWait();
            return;
        }

        DataStore.showTimes.remove(selected);
        showtimeObservableList.remove(selected);
    }


    @FXML
    private void onShowTimeMovieListButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/movietheater/MovieList.fxml")
            );
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Movie List");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void onShowTimeLogoutButtoClickn() {
        Stage s = (Stage) ShowTimeLogoutButton.getScene().getWindow();
        s.close();
    }
}
