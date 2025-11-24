/**
 * Represents a ticket for a movie showing.
 * Contains information about the ticket ID, associated movie, seat, showtime, and client.
 */
public class Ticket {

    /** The unique identifier for this ticket. */
    private int ticketID;

    /** The ID of the movie associated with this ticket. */
    private int movieID;

    /** The ID of the seat assigned to this ticket. */
    private int seatID;

    /** The ID of the showtime for this ticket. */
    private int showtimeID;

    /** The ID of the client who purchased or holds this ticket. */
    private int clientID;
}
