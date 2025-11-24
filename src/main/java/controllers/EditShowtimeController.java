package controllers;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
public class EditShowtimeController {


    @FXML
    private TextField editShowTimeMovieIDTextField;

    @FXML
    private TextField editShowTimeRoonNumberTextField;

    @FXML
    private TextField editShowTimeTimeTextField;

    @FXML
    private TextField editShowTimeDateTextField;

    @FXML
    private TextField editShowTimeImageLocationTextField;

    @FXML
    private Button editShowtimeSaveButton;

    @FXML
    private Button editShowTimeCancelButton;

    @FXML
    private Button editShowTimeBrowserButton;

    @FXML
    public void initialize() {
        // preload selected showtime data into fields
    }

    @FXML
    private void onSaveEditShowtime() {
        // validate & save changes
        System.out.println("Save showtime edits.");
    }

    @FXML
    private void onCancel() {
        Stage s = (Stage) editShowTimeCancelButton.getScene().getWindow();
        s.close();
    }

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
