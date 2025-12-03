
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
    private Button ShowTimeDeleteButton;

    @FXML
    private TableView<ShowTime> showtimeTableView;

    @FXML
    private TableColumn<ShowTime, String> movieTitleColumn;

    @FXML
    private TableColumn<ShowTime, Integer> roomColumn;

    @FXML
    private TableColumn<ShowTime, String> timeColumn;

    @FXML
    private TableColumn<ShowTime, String> dateColumn;

    @FXML
    private TableColumn<ShowTime, Integer> durationColumn;

    private ObservableList<ShowTime> showtimeObservableList;



    @FXML
    public void initialize() {
        // Don't create a new list - use DataStore.showTimes directly!
        showtimeTableView.setItems(DataStore.showTimes);

        // Movie title column
        movieTitleColumn.setCellValueFactory(cellData -> {
            Movie m = DataStore.getMovieById(cellData.getValue().getpMovieID());
            return new javafx.beans.property.SimpleStringProperty(
                    m != null ? m.getpTitle() : "Unknown"
            );
        });
        showtimeObservableList = FXCollections.observableList(DataStore.showTimes);
        showtimeTableView.setItems(showtimeObservableList);

        // Movie title column
        movieTitleColumn.setCellValueFactory(cellData -> {
            Movie m = DataStore.getMovieById(cellData.getValue().getpMovieID());
            return new javafx.beans.property.SimpleStringProperty(
                    m != null ? m.getpTitle() : "Unknown"
            );
        });

        // room column
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
            stage.setOnHidden(e -> showtimeTableView.refresh());

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
            stage.setOnHidden(e -> showtimeTableView.refresh());
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

        // Just remove from DataStore - the TableView will update automatically!
        DataStore.showTimes.remove(selected);
        showtimeTableView.refresh();
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
    private void onShowTimeLogoutButtonClick() {
        Stage s = (Stage) ShowTimeLogoutButton.getScene().getWindow();
        s.close();
    }
}
