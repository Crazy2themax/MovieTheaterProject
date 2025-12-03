package com.example.movietheater.Models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a scheduled showtime for a movie in a specific room.
 * <p>
 * A showtime combines a movie, a show room, a date, and a time.
 * It automatically retrieves and stores the movie's title and duration
 * for convenient access without repeated lookups.
 * </p>
 *
 * @author Movie Theater Application
 * @version 1.0
 */
public class ShowTime {

    /** The unique identifier for this showtime. */
    private int aShowTimeID;

    /** The ID of the movie being shown. */
    private int aMovieID;

    /** The show room where the movie will be shown. */
    private ShowRoom aRoom;

    /** The date of the showtime. */
    private LocalDate aDate;

    /** The time of the showtime. */
    private LocalTime aTime;

    /** The title of the movie (cached from movie data). */
    private String aTitle;

    /** The duration of the movie in minutes (cached from movie data). */
    private int aDuration;

    /**
     * Constructs a new ShowTime with the specified details.
     * <p>
     * Automatically retrieves the movie title from the DataStore based on the movie ID.
     * </p>
     *
     * @param pShowTimeID the unique identifier for this showtime
     * @param pDate the date of the showtime
     * @param pTime the time of the showtime
     * @param pMovieID the ID of the movie being shown
     * @param pRoomID the ID of the show room
     * @param pDuration the duration of the movie in minutes
     */
    public ShowTime(int pShowTimeID, LocalDate pDate, LocalTime pTime,
                    int pMovieID, int pRoomID, int pDuration) {
        this.aShowTimeID = pShowTimeID;
        this.aMovieID = pMovieID;
        this.aRoom = new ShowRoom(pRoomID);
        this.aDate = pDate;
        this.aTime = pTime;
        this.aDuration = pDuration;

        Movie movie = DataStore.getMovieById(pMovieID);
        this.aTitle = (movie != null) ? movie.getpTitle() : "";
    }

    /**
     * Gets the showtime ID.
     *
     * @return the unique identifier of this showtime
     */
    public int getaShowTimeID() {
        return this.aShowTimeID;
    }

    /**
     * Gets the movie ID.
     *
     * @return the ID of the movie being shown
     */
    public int getpMovieID() {
        return this.aMovieID;
    }

    /**
     * Gets the room ID.
     *
     * @return the ID of the show room
     */
    public int getpRoomID() {
        return this.aRoom.getpRoomID();
    }

    /**
     * Gets the showtime date.
     *
     * @return the date of this showtime
     */
    public LocalDate getpDate() {
        return this.aDate;
    }

    /**
     * Gets the showtime time.
     *
     * @return the time of this showtime
     */
    public LocalTime getpTime() {
        return this.aTime;
    }

    /**
     * Gets the movie title.
     *
     * @return the title of the movie being shown
     */
    public String getpTitle() {
        return this.aTitle;
    }

    /**
     * Gets the movie duration.
     *
     * @return the duration of the movie in minutes
     */
    public int getpDuration() {
        return this.aDuration;
    }

    /**
     * Sets the room ID.
     *
     * @param pId the new room ID to set
     */
    public void setpRoomID(int pId) {
        this.aRoom.setpRoomID(pId);
    }

    /**
     * Sets the showtime date.
     *
     * @param pDate the new date to set
     */
    public void setpDate(LocalDate pDate) {
        this.aDate = pDate;
    }

    /**
     * Sets the showtime time.
     *
     * @param pTime the new time to set
     */
    public void setpTime(LocalTime pTime) {
        this.aTime = pTime;
    }

    /**
     * Sets the movie title.
     *
     * @param pTitle the new title to set
     */
    public void setpTitle(String pTitle) {
        this.aTitle = pTitle;
    }

    /**
     * Sets the movie duration.
     *
     * @param pDuration the new duration in minutes to set
     */
    public void setpDuration(int pDuration) {
        this.aDuration = pDuration;
    }

    /**
     * Sets the movie ID and automatically updates the title and duration.
     * <p>
     * This method retrieves the movie from the DataStore and updates
     * the cached title and duration fields.
     * </p>
     *
     * @param pId the new movie ID to set
     */
    public void setpMovieID(int pId) {
        this.aMovieID = pId;

        Movie movie = DataStore.getMovieById(pId);
        if (movie != null) {
            this.aTitle = movie.getpTitle();
            this.aDuration = movie.getpDuration();
        }
    }
}
