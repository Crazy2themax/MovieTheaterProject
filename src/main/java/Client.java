/**
 * Represents a client user in the system.
 * Inherits from {@link User}.
 *
 * Fields:
 * - clientName: The name of the client.
 *
 * Methods:
 * - getRole(): Returns the role of this user as "Client".
 */
public class Client extends User {

    /** The name of the client. */
    String clientName;

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
