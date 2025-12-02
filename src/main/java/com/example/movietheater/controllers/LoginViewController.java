package com.example.movietheater.controllers;

import com.example.movietheater.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController
{
    /**
     * Text Field for entering the username
     */
    @FXML
    private TextField nameTextPrompt;

    /**
     * Text Field for entering the password
     */
    @FXML
    private TextField passwordTextPrompt;

    /**
     * Initializes the project
     */
    @FXML
    public void initialize()
    {

    }

    /**
     *
     * @param event
     * @throws IOException
     */
    public void OnLoginButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/ShowtimeListClient.fxml"));
        Parent rootNode = loader.load();

        showtimeViewController controller = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(rootNode));
        stage.show();
    }

    /**
     *
     * @param event
     */
    public void OnExitButtonClick(ActionEvent event)
    {
        Stage stage = (Stage) passwordTextPrompt.getScene().getWindow();
        stage.close();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    public void OnManagerButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("showTimeView.fxml"));
        Parent rootNode = loader.load();

        showtimeViewController controller = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(rootNode));
        stage.setTitle("Showtime View");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.showAndWait();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    public void OnSignUpButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/SignUp.fxml"));
        Parent rootNode = loader.load();

        //SignUpViewController controller = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(rootNode));
        stage.show();
    }
}