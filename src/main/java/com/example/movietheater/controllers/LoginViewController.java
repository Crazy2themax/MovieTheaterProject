package com.example.movietheater.controllers;

import com.example.movietheater.HelloApplication;
import com.example.movietheater.Models.Client;
import com.example.movietheater.Models.User;
import com.example.movietheater.Models.manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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
     * List to store user objects
     */
    private List<User> users = new ArrayList<>();

    @FXML
    public void initialize() {
        // Premade manager credentials
        users.add(new manager(1, "manager", "password123"));

        // Temp user
        users.add(new Client(2, "Riley", "Bandit"));
    }

    public void OnLoginButtonClick(ActionEvent event) throws IOException {

        String enteredName = nameTextPrompt.getText();
        String enteredPassword = passwordTextPrompt.getText();

        // Validate input
        if (enteredName == null || enteredPassword == null ||
                enteredName.isEmpty() || enteredPassword.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Username or Password is empty!");
            alert.showAndWait();
            return;
        }

        // Check each user
        for (User u : users) {
            if (u.getName().equals(enteredName) &&
                    u.getPassword().equals(enteredPassword)) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Login successful! Role: " + u.getRole());
                alert.showAndWait();

                if (u.getRole().equals("Manager")) {
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("showTimeView.fxml"));
                    Parent rootNode = loader.load();

                    showtimeViewController controller = loader.getController();

                    Stage stage = new Stage();
                    stage.setScene(new Scene(rootNode));
                    stage.setTitle("Showtime View Manager");
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.initOwner(((Node) event.getSource()).getScene().getWindow());
                    stage.showAndWait();
                } else if (u.getRole().equals("Client")) {
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

                return;
            }
        }


        // If reached here, no match was found
        Alert alert = new Alert(Alert.AlertType.ERROR, "Account not found! Try signing in?");
        alert.showAndWait();
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
    public void OnSignUpButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/movietheater/SignUp.fxml"));
        Parent rootNode = loader.load();

        SignUpViewController controller = loader.getController();
        controller.setLoginController(this);

        Stage stage = new Stage();
        stage.setScene(new Scene(rootNode));
        stage.setTitle("Create Account");
        stage.show();
    }

    public boolean usernameExists(String name) {
        return users.stream().anyMatch(u -> u.getName().equalsIgnoreCase(name));
    }

    public int getNextUserId() {
        return users.size() + 1;
    }

    public void addUser(User user) {
        users.add(user);
    }
}