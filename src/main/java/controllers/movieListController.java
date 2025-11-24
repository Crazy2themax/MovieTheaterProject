package controllers;
import javafx.fxml.FXML;


import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class movieListController {
    @FXML
    private ListView<?> movieListView; // change ? to Movie model when available

    @FXML
    private Button addMovieButton;

    @FXML
    private Button editMovieButton;

    @FXML
    private Button DeleteMovieButton;

    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
        // load movies into movieListView
    }

    @FXML
    private void onAddMovie() {
        // open AddMovie view
        System.out.println("Open Add Movie screen.");
    }

    @FXML
    private void onEditMovie() {
        // get selected and open edit view
        Object selected = movieListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            Alert a = new Alert(AlertType.WARNING, "Please select a movie to edit.");
            a.showAndWait();
            return;
        }
        System.out.println("Edit movie: " + selected);
    }

    @FXML
    private void onDeleteMovie() {
        Object selected = movieListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            Alert a = new Alert(AlertType.WARNING, "Please select a movie to delete.");
            a.showAndWait();
            return;
        }
        // TODO: confirm and delete from model/list
        System.out.println("Delete movie: " + selected);
    }

    @FXML
    private void onBack() {
        Stage s = (Stage) backButton.getScene().getWindow();
        s.close();
    }
}
