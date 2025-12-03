package com.example.movietheater.Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowTime {

    private int aShowTimeID;
    private int aMovieID;
    private ShowRoom aRoom;
    private LocalDate aDate;
    private LocalTime aTime;
    private String aTitle;
    private int aDuration;


    public ShowTime(int showTimeID, LocalDate date, LocalTime time, int movieID, int roomID, int duration ) {
        this.aShowTimeID = showTimeID;
        this.aMovieID = movieID;
        this.aRoom = new ShowRoom(roomID);
        this.aDate = date;
        this.aTime = time;
        this.aDuration = duration;

        var movie = DataStore.getMovieById(movieID);
        this.aTitle = (movie != null) ? movie.getpTitle() : "";
    }

    //Getters
    public int getaShowTimeID()
    { return aShowTimeID; }

    public int getpMovieID()
    { return aMovieID; }

    public int getpRoomID()
    { return aRoom.getpRoomID(); }

    public LocalDate getpDate()
    { return aDate; }

    public LocalTime getpTime()
    { return aTime; }

    public String getpTitle()
    { return aTitle; }

    public int getpDuration()
    { return aDuration; }

//Setters
    public void setpRoomID(int id)
    { this.aRoom.setpRoomID(id); }

    public void setpDate(LocalDate date)
    { this.aDate = date; }

    public void setpTime(LocalTime time)
    { this.aTime = time; }

    public void setpTitle(String title)
    { this.aTitle = title; }

    public void setpDuration(int duration)
    { this.aDuration = duration; }

    public void setpMovieID(int id) {
        this.aMovieID = id;

        Movie m = DataStore.getMovieById(id);
        if (m != null) {
            this.aTitle = m.getpTitle();
            this.aDuration = m.getpDuration();
        }
    }
}
