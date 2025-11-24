import java.time.LocalDate;
import java.time.LocalTime;

public class ShowTime {
    private int showTimeID;
    private LocalDate date;
    private LocalTime time;
    private int movieID;
    private int roomID;
    private int managerID;
    public ShowTime(int showTimeID, LocalDate date, LocalTime time, int movieID, int roomID, int managerID) {
        this.showTimeID =showTimeID;
        this.movieID = movieID;
        this.roomID = roomID;
        this.managerID = managerID;
        this.date = null;
        this.time = null;
    }

    //setters for later (will probably be changed later)
    public void setDate(LocalDate date) { this.date = date; }
    public void setTime(LocalTime time) { this.time = time; }
}

