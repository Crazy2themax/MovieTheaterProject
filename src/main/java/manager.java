/**
 * Represents a manager user in the system.
 * Inherits from {@link User}.
 *
 * Fields:
 * - managerName: The name of the manager.
 *
 * Methods:
 * - getRole(): Returns the role of this user as "Manager".
 */
public class manager extends User {

    /** The name of the manager. */
    private String managerName;

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
