package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

/**
 * Controller class for the "Showtime Manager View".
 * <p>
 * Handles displaying showtimes and provides functionality for logging out,
 * adding, editing, deleting showtimes, and opening the movie list.
 * Optional AnchorPane references can be used for individual showtime cards.
 * </p>
 */
public class showtimeViewController {

    /** Button to log out from the showtime manager view. */
    @FXML
    private Button LogOutShowTimeMangerViewButton;

    /** Button to edit the selected showtime. */
    @FXML
    private Button editShowTimeMangerViewButton;

    /** Button to add a new showtime. */
    @FXML
    private Button AddShowTimeMangerViewButton;

    /** Button to open the movie list view. */
    @FXML
    private Button movieListShowTimeMangerViewButton;

    /** Button to delete the selected showtime. */
    @FXML
    private Button DeleteShowTimeMangerViewButton;

    /** Optional AnchorPane representing the first showtime card. */
    @FXML
    private AnchorPane showtimeCard1;

    /** Optional AnchorPane representing the second showtime card. */
    @FXML
    private AnchorPane showtimeCard2;

    /** Optional ListView to display showtimes as a list. */
    @FXML
    private ListView<?> showtimeListView;

    /**
     * Initializes the controller.
     * <p>
     * Called automatically after the FXML file has been loaded.
     * Can be used to load showtimes into the view or initialize UI elements.
     * </p>
     */
    @FXML
    public void initialize() {
        // load showtimes into view, e.g. showtimeListView
    }

    /**
     * Handles logout action.
     * <p>
     * Performs logout operations and navigates back to the login view.
     * </p>
     */
    @FXML
    private void onLogout() {
        System.out.println("Logout clicked.");
        // TODO: perform logout, navigate to login
    }

    /**
     * Handles editing the selected showtime.
     * <p>
     * Navigates to the edit showtime view with the selected showtime.
     * </p>
     */
    @FXML
    private void onEditShowtime() {
        System.out.println("Edit showtime clicked.");
        // TODO: go to editShowTime.fxml with selected showtime
    }

    /**
     * Handles adding a new showtime.
     * <p>
     * Opens the AddShowtime view for creating a new showtime.
     * </p>
     */
    @FXML
    private void onAddShowtime() {
        System.out.println("Add showtime clicked.");
        // TODO: open AddShowtime view
    }

    /**
     * Opens the movie list view.
     * <p>
     * Allows the user to view all movies associated with the showtimes.
     * </p>
     */
    @FXML
    private void onOpenMovieList() {
        System.out.println("Open movie list clicked.");
        // TODO: open movieList.fxml
    }

    /**
     * Handles deleting the selected showtime.
     * <p>
     * Deletes the showtime selected by the user.
     * </p>
     */
    @FXML
    private void onDeleteShowtime() {
        System.out.println("Delete showtime clicked.");
        // TODO: delete selected showtime
    }
}
