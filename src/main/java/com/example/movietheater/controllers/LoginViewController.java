package com.example.movietheater.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
     * Button to go to the sign up view.
     */
    @FXML
    private Button signupButton;

    @FXML
    public void initialize()
    {

    }

    public void onLoginButtonClick(ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/ShowtimeListClient.fxml"));
        Parent rootNode = loader.load();

        showtimeViewController controller = loader.getController();
        controller.setComposite(composite);

        Stage stage = new Stage();
        stage.setTitle(composite.getName());
        stage.setScene(new Scene(rootNode));
        stage.show();
    }

    public void onExitButtonClick(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void onManagerButtonClick(ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/showTime view.fxml"));
        Parent rootNode = loader.load();

        LoginViewController controller = loader.getController();
        controller.setComposite(composite);

        Stage stage = new Stage();
        stage.setTitle(composite.getName());
        stage.setScene(new Scene(rootNode));
        stage.show();
    }

    public void onSignUpButtonClick(ActionEvent event)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/SignUp.fxml"));
        Parent rootNode = loader.load();

        SignUpViewController controller = loader.getController();
        controller.setComposite(composite);

        Stage stage = new Stage();
        stage.setTitle(composite.getName());
        stage.setScene(new Scene(rootNode));
        stage.show();
    }
}