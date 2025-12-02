package com.example.movietheater.Models;

/**
 * Represents a movie in the system.
 * Contains basic information such as ID, title, and duration.
 *
 * Fields:
 * - movieID: The unique identifier for the movie.
 * - Title: The title of the movie.
 * - duration: The duration of the movie in minutes.
 */
public class Movie {

    /** The unique identifier for the movie. */
    private int aMovieID;

    /** The title of the movie. */
    private String aTitle;

    /** The duration of the movie in minutes. */
    private int aDuration;


    public Movie (int movieID, String title, int duration) {
        this.aMovieID = movieID;
        this.aTitle = title;
        this.aDuration = duration;
    }

    //properties
    public int getpMovieID() {
        return aMovieID;
    }

    public void setpMovieID(int aMovieID) {
        this.aMovieID = aMovieID;
    }

    public String getpTitle() {
        return aTitle;
    }

    public void setpTitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public int getpDuration() {
        return aDuration;
    }
    public void setpDuration(int aDuration) {
        this.aDuration = aDuration;
    }

    @Override
    public String toString() {
        return aMovieID + "  " + aTitle + " (" + aDuration + " mins";
    }

}
