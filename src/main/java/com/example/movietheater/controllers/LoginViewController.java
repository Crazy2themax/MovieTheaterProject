package com.example.movietheater.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
     * Button to attempt a login, it fails if text fields are empty or have invalid inputs
     */
    @FXML
    private Button loginButton;

    /**
     * Button to close application
     */
    @FXML
    private Button exitButton;

    /**
     * Button to attempt a login as Manager, it fails if text fields are empty or have invalid inputs
     */
    @FXML
    private Button managerLoginButton;

    /**
     * Button to go to the sign-up view.
     */
    @FXML
    private Button signupButton;

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
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    public void OnManagerButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/showTime view.fxml"));
        Parent rootNode = loader.load();

        LoginViewController controller = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(rootNode));
        stage.show();
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