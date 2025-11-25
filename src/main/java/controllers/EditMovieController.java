package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the "Edit Movie" view.
 * <p>
 * Handles the interaction for editing an existing movie's information,
 * including movie ID, title, and duration. Provides functionality to save changes
 * or cancel the editing process.
 * </p>
 */
public class EditMovieController {

    /** TextField for editing the movie ID. */
    @FXML
    private TextField editMovieIDTextField;

    /** TextField for editing the movie title. */
    @FXML
    private TextField editMovieTitleTextField;

    /** TextField for editing the movie duration. */
    @FXML
    private TextField editMovieDurationTextField;

    /** Button to save the edited movie information. */
    @FXML
    private Button editMovieSaveButton;

    /** Button to cancel the edit operation. */
    @FXML
    private Button editMovieCancelButton;

    /**
     * Initializes the controller.
     * <p>
     * Called automatically after the FXML file has been loaded.
     * Can be used to preload the movie data passed by the caller.
     * </p>
     */
    @FXML
    public void initialize() {
        // preload movie data given by caller
    }

    /**
     * Handles saving the edited movie.
     * <p>
     * Validates and saves the updated movie information.
     * Curently prints a message to the console; extend this method to update the model.
     * </p>
     */
    @FXML
    private void onSaveMovie() {
        // validate & save updated movie
        System.out.println("Movie saved.");
    }

    /**
     * Handles cancelling the edit operation.
     * <p>
     * Closes the current window without saving changes.
     * </p>
     */
    @FXML
    private void onCancel() {
        Stage s = (Stage) editMovieCancelButton.getScene().getWindow();
        s.close();
    }
}
