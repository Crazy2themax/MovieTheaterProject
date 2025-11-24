/**
 * Abstract base class representing a generic user in the system.
 * All types of users (e.g., Client, Manager) should extend this class.
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
    protected int Id;

    /** Name of the user. */
    protected String Name;

    /** Email of the user. */
    protected String Email;

    /** Password of the user. */
    protected String Password;

    /**
     * Constructs a User object with the specified parameters.
     *
     * @param id the unique identifier for the user
     * @param name the name of the user
     * @param email the email address of the user
     * @param password the password of the user
     */
    public User(int id, String name, String email, String password) {
        // Implementation can initialize the fields
    }

    /**
     * Returns the role of this user.
     * Subclasses must provide an implementation.
     *
     * @return a string representing the role of the user
     */
    public abstract String getRole();
}
