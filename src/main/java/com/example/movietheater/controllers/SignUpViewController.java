package com.example.movietheater.controllers;

import com.example.movietheater.Models.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpViewController
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
     * Text Field for entering the password
     */
    @FXML
    private TextField confirmTextPrompt;


    /**
     * Initializes the project
     */
    @FXML
    public void initialize()
    {

    }

    private LoginViewController loginController; // reference to main controller

    public void setLoginController(LoginViewController controller) {
        this.loginController = controller;
    }

    // Handles creating a new account
    @FXML
    public void OnCreateButtonClick(ActionEvent actionEvent) {

        String username = nameTextPrompt.getText();
        String password = passwordTextPrompt.getText();
        String confirm  = confirmTextPrompt.getText();

        // Validate input
        if (username.isEmpty() || password.isEmpty() || confirm.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Username or Password is empty!");
            alert.showAndWait();
            return;
        }

        if (!password.equals(confirm))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Passwords do not match!");
            alert.showAndWait();
            return;
        }

        // Check if username already exists
        if (loginController.usernameExists(username))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Username already taken!");
            alert.showAndWait();
            return;
        }

        // Create new user
        int newId = loginController.getNextUserId();
        Client newClient = new Client(newId, username, password);

        loginController.addUser(newClient);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Account created successfully!");
        alert.showAndWait();

        // Close window
        Stage stage = (Stage) passwordTextPrompt.getScene().getWindow();
        stage.close();
    }

    // Close window
    public void OnCancelButtonClick(ActionEvent actionEvent)
    {
        Stage stage = (Stage) passwordTextPrompt.getScene().getWindow();
        stage.close();
    }
}