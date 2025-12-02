package com.example.movietheater.Models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a scheduled showtime for a movie.
 * Contains information about the showtime's ID, date, time, associated movie, room, and com.example.movietheater.Models.manager.
 */
public class ShowTime {

    /** The unique identifier for this showtime. */
    private int aShowTimeID;

    /** The date of the showtime. */
    private LocalDate aDate;

    /** The time of the showtime. */
    private LocalTime aTime;

    /** The ID of the movie being shown. */
    private int aMovieID;

    /** The ID of the room where the showtime takes place. */
    private int aRoomID;

    private String aTitle;
    private int aDuration;

    /** The ID of the com.example.movietheater.Models.manager who created/owns this showtime. */
    private int aManagerID;



    /**
     * Constructs a com.example.movietheater.Models.ShowTime object with the given IDs.
     * The date and time are initialized as null and can be set later.
     *
     * @param showTimeID the unique identifier of the showtime
     * @param date the date of the showtime (currently ignored, initialized as null)
     * @param time the time of the showtime (currently ignored, initialized as null)
     * @param movieID the ID of the movie
     * @param roomID the ID of the room
     * @param managerID the ID of the com.example.movietheater.Models.manager
     */
    public ShowTime(int showTimeID, LocalDate date, LocalTime time, int movieID, int roomID, int managerID) {
        this.aShowTimeID = showTimeID;
        this.aMovieID = movieID;
        this.aRoomID = roomID;
        this.aManagerID = managerID;
        this.aDate = date;
        this.aTime = time;
    }

    /**
     * Sets the date of the showtime.
     *
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.aDate = date;
    }

    /**
     * Sets the time of the showtime.
     *
     * @param time the time to set
     */
    public void setTime(LocalTime time) {
        this.aTime = time;
    }



    //getters
    public int getShowTimeID()
    {return aShowTimeID;}

    public int getpMovieID() {return aMovieID;}
    public int getpRoomID() {return aRoomID;}
    public int getpManagerID() {return aManagerID;}
    public LocalDate getpDate() {return aDate;}
    public LocalTime getpTime() {return aTime;}
    public String getpTitle() { return aTitle; }
    public int getpDuration() { return aDuration; }



    // Properties (setters)=======================================>
    public void setpShowTimeID(int showTimeID) {
        this.aShowTimeID = showTimeID;
    }

    public void setpDate(LocalDate date) {
        this.aDate = date;
    }

    public void setpTime(LocalTime time) {
        this.aTime = time;
    }

    public void setpMovieID(int movieID) {
        this.aMovieID = movieID;
    }

    public void setpRoomID(int roomID) {
        this.aRoomID = roomID;
    }

    public void setpManagerID(int managerID) {
        this.aManagerID = managerID;
    }
    public void setpTitle(String movieTitle) { this.aTitle = movieTitle; }
    public void setpDuration(int duration) { this.aDuration = duration; }


    @Override
    public String toString() {
        return "ShowTime ID: " + aShowTimeID + ", Movie ID: " + aMovieID + ", Room ID: " + aRoomID +
                ", Date: " + (aDate != null ? aDate.toString() : "N/A") +
                ", Time: " + (aTime != null ? aTime.toString() : "N/A");
            }
    }



