package com.example.movietheater.Models;

/**
 * Represents a client user in the system.
 * Inherits from {@link User}.
 *
 * Fields:
 * - clientName: The name of the client.
 *
 * Methods:
 * - getRole(): Returns the role of this user as "com.example.movietheater.Models.Client".
 */
public class Client extends User {

    /**
     * Constructs a com.example.movietheater.Models.User object with the specified parameters.
     *
     * @param id       the unique identifier for the user
     * @param name     the name of the user
     * @param password the password of the user
     */
    public Client(int id, String name, String password) {
        super(id, name, password);
    }

    /**
     * Returns the role of this user.
     *
     * @return the string "Client"
     */
    @Override
    public String getRole() {
        return "Client";
    }
}
