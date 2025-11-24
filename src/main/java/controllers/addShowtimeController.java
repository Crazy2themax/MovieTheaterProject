package controllers;
import javafx.fxml.FXML;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class addShowtimeController {

    @FXML
    private TextField addShowTimeMovieIDTextField;

    @FXML
    private TextField addShowTimeRoonNumberTextField;

    @FXML
    private TextField addShowTimeTimeTextField;

    @FXML
    private TextField addShowTimeDateTextField;

    @FXML
    private TextField addShowTimeImageLocationTextField;

    @FXML
    private Button addShowtimeSaveButton;

    @FXML
    private Button addShowTimeCancelButton;

    @FXML
    private Button addShowTimeBrowserButton;

    @FXML
    public void initialize() {
        // initialize dropdowns/pickers if any
    }

    @FXML
    private void onSaveShowtime() {
        // read fields, validate, save to model/list
        String movieId = addShowTimeMovieIDTextField.getText();
        String room = addShowTimeRoonNumberTextField.getText();
        String time = addShowTimeTimeTextField.getText();
        String date = addShowTimeDateTextField.getText();
        String image = addShowTimeImageLocationTextField.getText();
        System.out.println("Saving showtime: " + movieId + ", room " + room + ", " + date + " " + time + ", image=" + image);
        // TODO: add validation and storage logic
    }

    @FXML
    private void onCancel() {
        // close window or navigate back
        Stage s = (Stage) addShowTimeCancelButton.getScene().getWindow();
        s.close();
    }


    //for the image more planning will be required. TODO later this week
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
