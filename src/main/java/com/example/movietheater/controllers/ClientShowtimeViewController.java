package com.example.movietheater.controllers;

import com.example.movietheater.Models.DataStore;
import com.example.movietheater.Models.Movie;
import com.example.movietheater.Models.ShowTime;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class ClientShowtimeViewController
{
    @FXML
    private TableView<ShowTime> showtimeTable;

    @FXML
    private TableColumn<ShowTime, String> movieTitleColumn;

    @FXML
    private TableColumn<ShowTime, String> timeColumn;

    @FXML
    private TableColumn<ShowTime, String> dateColumn;

    @FXML
    private TableColumn<ShowTime, Integer> durationColumn;

    @FXML
    public void initialize() {

        // Bind to the same shared ObservableList used by the manager
        showtimeTable.setItems(DataStore.showTimes);

        // Reuse same cell value factories as manager
        movieTitleColumn.setCellValueFactory(cell -> {
            Movie m = DataStore.getMovieById(cell.getValue().getpMovieID());
            return new SimpleStringProperty(
                    m != null ? m.getpTitle() : "Unknown"
            );
        });

        timeColumn.setCellValueFactory(cell -> {
            if (cell.getValue().getpTime() != null) {
                return new SimpleStringProperty(
                        cell.getValue().getpTime().format(DateTimeFormatter.ofPattern("HH:mm"))
                );
            }
            return new SimpleStringProperty("Not set");
        });

        dateColumn.setCellValueFactory(cell -> {
            if (cell.getValue().getpDate() != null) {
                return new SimpleStringProperty(cell.getValue().getpDate().toString());
            }
            return new SimpleStringProperty("Not set");
        });

        durationColumn.setCellValueFactory(cell -> {
            Movie m = DataStore.getMovieById(cell.getValue().getpMovieID());
            return new SimpleIntegerProperty(
                    m != null ? m.getpDuration() : 0
            ).asObject();
        });
    }

    @FXML
    public void OnPurchaseButtonClick(ActionEvent actionEvent)
    {
        ShowTime selected = showtimeTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a showtime to purchase.");
            alert.showAndWait();

            return;

        }

        // Just show confirmation
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ticket purchased!");
        alert.showAndWait();
    }

    public void OnLogoutButtonClick(ActionEvent actionEvent)
    {
        Stage stage = (Stage) showtimeTable.getScene().getWindow();
        stage.close();
    }
}
