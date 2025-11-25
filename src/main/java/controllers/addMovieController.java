package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the "Add Movie" view.
 * <p>
 * This class handles the interaction between the user and the "Add Movie" form,
 * allowing the user to input a movie ID, title, and duration, and either save or cancel the action.
 * </p>
 */
public class addMovieController {

    /** TextField for entering the movie ID. */
    @FXML
    private TextField addMovieIDTextField;

    /** TextField for entering the movie title. */
    @FXML
    private TextField addMovieTitleTextField;

    /** TextField for entering the movie duration. */
    @FXML
    private TextField addMovieDurationTextField;

    /** Button to save the movie information. */
    @FXML
    private Button addMovieSaveButton;

    /** Button to cancel adding a movie. */
    @FXML
    private Button addMoveiCancelButton;

    /**
     * Initializes the controller.
     * <p>
     * This method is called automatically after the FXML file has been loaded.
     * You can use it to initialize any controls or data if needed.
     * </p>
     */
    @FXML
    public void initialize() {
        // initialize any controls
    }

    /**
     * Handles the action of saving a movie.
     * <p>
     * Retrieves the movie ID, title, and duration from the text fields,
     * prints them to the console, and can be extended to validate and add the movie to the model.
     * </p>
     */
    @FXML
    private void onSaveMovie() {
        String id = addMovieIDTextField.getText();
        String title = addMovieTitleTextField.getText();
        String duration = addMovieDurationTextField.getText();
        System.out.println("Saving movie: " + id + " - " + title + " (" + duration + ")");
        // TODO: validate & add to list/model
    }

    /**
     * Handles the action of cancelling the add movie operation.
     * <p>
     * Closes the current window without saving any data.
     * </p>
     */
    @FXML
    private void onCancel() {
        Stage s = (Stage) addMoveiCancelButton.getScene().getWindow();
        s.close();
    }
}
