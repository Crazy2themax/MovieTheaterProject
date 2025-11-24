import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a scheduled showtime for a movie.
 * Contains information about the showtime's ID, date, time, associated movie, room, and manager.
 */
public class ShowTime {

    /** The unique identifier for this showtime. */
    private int showTimeID;

    /** The date of the showtime. */
    private LocalDate date;

    /** The time of the showtime. */
    private LocalTime time;

    /** The ID of the movie being shown. */
    private int movieID;

    /** The ID of the room where the showtime takes place. */
    private int roomID;

    /** The ID of the manager who created/owns this showtime. */
    private int managerID;

    /**
     * Constructs a ShowTime object with the given IDs.
     * The date and time are initialized as null and can be set later.
     *
     * @param showTimeID the unique identifier of the showtime
     * @param date the date of the showtime (currently ignored, initialized as null)
     * @param time the time of the showtime (currently ignored, initialized as null)
     * @param movieID the ID of the movie
     * @param roomID the ID of the room
     * @param managerID the ID of the manager
     */
    public ShowTime(int showTimeID, LocalDate date, LocalTime time, int movieID, int roomID, int managerID) {
        this.showTimeID = showTimeID;
        this.movieID = movieID;
        this.roomID = roomID;
        this.managerID = managerID;
        this.date = null;
        this.time = null;
    }

    /**
     * Sets the date of the showtime.
     *
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Sets the time of the showtime.
     *
     * @param time the time to set
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }
}
