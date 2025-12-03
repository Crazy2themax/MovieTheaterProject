package com.example.movietheater.Models;

/**
 * Abstract base class representing a generic user in the system.
 * All types of users (e.g., com.example.movietheater.Models.Client, Manager) should extend this class.
 *
 * Fields:
 * - Id: Unique identifier for the user.
 * - Name: The user's name.
 * - Email: The user's email address.
 * - Password: The user's password.
 *
 * Methods:
 * - getRole(): Abstract method that must be implemented by subclasses to return the user's role.
 */
public abstract class User {

    /** Unique identifier for the user. */
    protected int aId;

    /** Name of the user. */
    protected String aName;

    /** Password of the user. */
    protected String aPassword;

    /**
     * Constructs a com.example.movietheater.Models.User object with the specified parameters.
     *
     * @param pId the unique identifier for the user
     * @param pName the name of the user
     * @param pPassword the password of the user
     */
    public User(int pId, String pName, String pPassword) {
        this.aId = pId;
        this.aName = pName;
        this.aPassword = pPassword;
    }

    /**
     * Gets the name and returns it
     * @return aName
     */
    public String getName() {
        return aName;
    }

    /**
     * Gets the password and returns itW
     * @return aPassword
     */
    public String getPassword() {
        return aPassword;
    }

    /**
     * Returns the role of this user.
     * Subclasses must provide an implementation.
     *
     * @return a string representing the role of the user
     */

    public abstract String getRole();
}
