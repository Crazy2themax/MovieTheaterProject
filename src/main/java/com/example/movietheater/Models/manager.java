package com.example.movietheater.Models;

/**
 * Represents a com.example.movietheater.Models.manager user in the system.
 * Inherits from {@link User}.
 *
 * Fields:
 * - managerName: The name of the com.example.movietheater.Models.manager.
 *
 * Methods:
 * - getRole(): Returns the role of this user as "Manager".
 */
public class manager extends User {

    /** The name of the com.example.movietheater.Models.manager. */
    private String managerName;

    /**
     * Constructs a com.example.movietheater.Models.User object with the specified parameters.
     *
     * @param id       the unique identifier for the user
     * @param name     the name of the user
     * @param password the password of the user
     */
    public manager(int id, String name, String password) {
        super(id, name, password);
    }

    /**
     * Returns the role of this user.
     *
     * @return the string "Manager"
     */
    @Override
    public String getRole() {
        return "Manager";
    }
}
