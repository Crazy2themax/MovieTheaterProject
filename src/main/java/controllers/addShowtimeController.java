package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

/**
 * Controller class for the "Add Showtime" view.
 * <p>
 * This class handles the user interactions for adding a new showtime,
 * including movie ID, room number, time, date, and an optional image.
 * </p>
 */
public class addShowtimeController {

    /** TextField for entering the movie ID. */
    @FXML
    private TextField addShowTimeMovieIDTextField;

    /** TextField for entering the room number for the showtime. */
    @FXML
    private TextField addShowTimeRoonNumberTextField;

    /** TextField for entering the time of the showtime. */
    @FXML
    private TextField addShowTimeTimeTextField;

    /** TextField for entering the date of the showtime. */
    @FXML
    private TextField addShowTimeDateTextField;

    /** TextField for entering or displaying the image file location. */
    @FXML
    private TextField addShowTimeImageLocationTextField;

    /** Button to save the showtime information. */
    @FXML
    private Button addShowtimeSaveButton;

    /** Button to cancel adding a showtime. */
    @FXML
    private Button addShowTimeCancelButton;

    /** Button to browse for an image file. */
    @FXML
    private Button addShowTimeBrowserButton;

    /**
     * Initializes the controller.
     * <p>
     * Called automatically after the FXML file has been loaded.
     * Can be used to initialize dropdowns, pickers, or other controls.
     * </p>
     */
    @FXML
    public void initialize() {
        // initialize dropdowns/pickers if any
    }

    /**
     * Handles saving a showtime.
     * <p>
     * Reads input from all text fields, prints the information to the console,
     * and can be extended to validate and store the showtime in a model or list.
     * </p>
     */
    @FXML
    private void onSaveShowtime() {
        String movieId = addShowTimeMovieIDTextField.getText();
        String room = addShowTimeRoonNumberTextField.getText();
        String time = addShowTimeTimeTextField.getText();
        String date = addShowTimeDateTextField.getText();
        String image = addShowTimeImageLocationTextField.getText();
        System.out.println("Saving showtime: " + movieId + ", room " + room + ", " + date + " " + time + ", image=" + image);
        // TODO: add validation and storage logic
    }

    /**
     * Handles cancelling the add showtime operation.
     * <p>
     * Closes the current window without saving any data.
     * </p>
     */
    @FXML
    private void onCancel() {
        Stage s = (Stage) addShowTimeCancelButton.getScene().getWindow();
        s.close();
    }

    /**
     * Handles browsing for an image file.
     * <p>
     * Opens a FileChooser dialog allowing the user to select an image file for the showtime.
     * Updates the image location text field with the selected file path.
     * </p>
     */
    @FXML
    private void onBrowseImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Movie Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        Stage s = (Stage) addShowTimeBrowserButton.getScene().getWindow();
        File sel = fileChooser.showOpenDialog(s);
        if (sel != null) {
            addShowTimeImageLocationTextField.setText(sel.getAbsolutePath());
            // optionally show preview if you have an ImageView
            System.out.println("Selected image: " + sel.getAbsolutePath());
        }
    }
}
