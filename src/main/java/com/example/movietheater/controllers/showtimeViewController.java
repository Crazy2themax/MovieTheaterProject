package com.example.movietheater.controllers;

import com.example.movietheater.Models.DataStore;
import com.example.movietheater.Models.Movie;
import com.example.movietheater.Models.ShowTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class showtimeViewController {

    @FXML
    private Button LogOutShowTimeMangerViewButton;

    @FXML
    private Button editShowTimeMangerViewButton;

    @FXML
    private Button AddShowTimeMangerViewButton;

    @FXML
    private Button movieListShowTimeMangerViewButton;

    @FXML
    private Button DeleteShowTimeMangerViewButton;

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
        // Table columns
        movieTitleColumn.setCellValueFactory(cellData -> {
            Movie m = DataStore.getMovieById(cellData.getValue().getpMovieID());
            return new javafx.beans.property.SimpleStringProperty(m != null ? m.getpTitle() : "Unknown");
        });

        timeColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue().getpTime() != null)
                return new javafx.beans.property.SimpleStringProperty(cellData.getValue().getpTime().format(DateTimeFormatter.ofPattern("HH:mm")));
            return new javafx.beans.property.SimpleStringProperty("Not set");
        });

        dateColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue().getpDate() != null)
                return new javafx.beans.property.SimpleStringProperty(cellData.getValue().getpDate().toString());
            return new javafx.beans.property.SimpleStringProperty("Not set");
        });

        durationColumn.setCellValueFactory(cellData -> {
            Movie m = DataStore.getMovieById(cellData.getValue().getpMovieID());
            return new javafx.beans.property.SimpleIntegerProperty(m != null ? m.getpDuration() : 0).asObject();
        });

        showtimeObservableList = FXCollections.observableArrayList(DataStore.showTimes);
        showtimeTableView.setItems(showtimeObservableList);
    }

    @FXML
    private void onAddShowtime() {
        System.out.println("Add showtime clicked.");
        // TODO: open AddShowtime.fxml and add to DataStore.showTimes
    }

    @FXML
    private void onEditShowtime() {
        ShowTime selected = showtimeTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a showtime to edit.").showAndWait();
            return;
        }
        System.out.println("Edit showtime clicked: " + selected.getShowTimeID());
        // TODO: open EditShowtime.fxml with selected showtime
    }

    @FXML
    private void onDeleteShowtime() {
        ShowTime selected = showtimeTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a showtime to delete.").showAndWait();
            return;
        }
        DataStore.showTimes.remove(selected);
        showtimeObservableList.remove(selected);
        System.out.println("Deleted showtime: " + selected.getShowTimeID());
    }

    @FXML
    private void onOpenMovieList() {
        System.out.println("Open movie list clicked.");
        // TODO: open movie list view
    }

    @FXML
    private void onLogout() {
        Stage s = (Stage) LogOutShowTimeMangerViewButton.getScene().getWindow();
        s.close();
        System.out.println("Logout clicked.");
    }
}
