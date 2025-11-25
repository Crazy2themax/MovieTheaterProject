package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

/**
 * Controller class for the "Edit Showtime" view.
 * <p>
 * Handles the interaction for editing an existing showtime, including movie ID,
 * room number, time, date, and an optional image. Provides functionality to save changes,
 * cancel editing, or browse for a new image.
 * </p>
 */
public class EditShowtimeController {

    /** TextField for editing the movie ID associated with the showtime. */
    @FXML
    private TextField editShowTimeMovieIDTextField;

    /** TextField for editing the room number of the showtime. */
    @FXML
    private TextField editShowTimeRoonNumberTextField;

    /** TextField for editing the time of the showtime. */
    @FXML
    private TextField editShowTimeTimeTextField;

    /** TextField for editing the date of the showtime. */
    @FXML
    private TextField editShowTimeDateTextField;

    /** TextField for displaying or editing the image file location. */
    @FXML
    private TextField editShowTimeImageLocationTextField;

    /** Button to save the edited showtime. */
    @FXML
    private Button editShowtimeSaveButton;

    /** Button to cancel the editing process. */
    @FXML
    private Button editShowTimeCancelButton;

    /** Button to browse for an image file. */
    @FXML
    private Button editShowTimeBrowserButton;

    /**
     * Initializes the controller.
     * <p>
     * Called automatically after the FXML file has been loaded.
     * Can be used to preload the selected showtime data into the text fields.
     * </p>
     */
    @FXML
    public void initialize() {
        // preload selected showtime data into fields
    }

    /**
     * Handles saving the edited showtime.
     * <p>
     * Validates and saves the changes to the showtime.
     * Currently prints a message to the console; extend this method to update the model.
     * </p>
     */
    @FXML
    private void onSaveEditShowtime() {
        // validate & save changes
        System.out.println("Save showtime edits.");
    }

    /**
     * Handles cancelling the edit showtime operation.
     * <p>
     * Closes the current window without saving changes.
     * </p>
     */
    @FXML
    private void onCancel() {
        Stage s = (Stage) editShowTimeCancelButton.getScene().getWindow();
        s.close();
    }

    /**
     * Handles browsing for a new image file for the showtime.
     * <p>
     * Opens a FileChooser dialog allowing the user to select an image.
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
        Stage s = (Stage) editShowTimeBrowserButton.getScene().getWindow();
        File sel = fileChooser.showOpenDialog(s);
        if (sel != null) {
            editShowTimeImageLocationTextField.setText(sel.getAbsolutePath());
            System.out.println("Selected image: " + sel.getAbsolutePath());
        }
    }
}
