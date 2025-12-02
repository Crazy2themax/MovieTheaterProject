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
     * Button to create a new account
     */
    @FXML
    private Button createButton;

    /**
     * Button to cancel the sign-up application
     */
    @FXML
    private Button cancelButton;

    /**
     * Initializes the project
     */
    @FXML
    public void initialize()
    {

    }
}