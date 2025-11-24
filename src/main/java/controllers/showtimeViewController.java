package controllers;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
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

    // If you have panes for showtime cards, reference them (optional)
    @FXML
    private AnchorPane showtimeCard1;

    @FXML
    private AnchorPane showtimeCard2;

    @FXML
    private ListView<?> showtimeListView; // optional: if you change to a list view

    @FXML
    public void initialize() {
        // load showtimes into view, e.g. showtimeListView
    }

    @FXML
    private void onLogout() {
        // TODO: perform logout, navigate to login
        System.out.println("Logout clicked.");
    }

    @FXML
    private void onEditShowtime() {
        // TODO: go to editShowTime.fxml with selected showtime
        System.out.println("Edit showtime clicked.");
    }

    @FXML
    private void onAddShowtime() {
        // TODO: open AddShowtime view
        System.out.println("Add showtime clicked.");
    }

    @FXML
    private void onOpenMovieList() {
        // TODO: open movieList.fxml
        System.out.println("Open movie list clicked.");
    }

    @FXML
    private void onDeleteShowtime() {
        // TODO: delete selected showtime
        System.out.println("Delete showtime clicked.");
    }
}


