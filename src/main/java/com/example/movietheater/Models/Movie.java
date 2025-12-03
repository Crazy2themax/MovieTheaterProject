package com.example.movietheater.Models;

/**
 * Represents a movie in the theater system.
 * <p>
 * Contains basic information such as ID, title, and duration.
 * Movies can be scheduled for showtimes in various theater rooms.
 * </p>
 *
 * @author Movie Theater Application
 * @version 1.0
 */
public class Movie {

    /** The unique identifier for the movie. */
    private int aMovieID;

    /** The title of the movie. */
    private String aTitle;

    /** The duration of the movie in minutes. */
    private int aDuration;

    /**
     * Constructs a new Movie with the specified ID, title, and duration.
     *
     * @param pMovieID the unique identifier for the movie
     * @param pTitle the title of the movie
     * @param pDuration the duration of the movie in minutes
     */
    public Movie(int pMovieID, String pTitle, int pDuration) {
        this.aMovieID = pMovieID;
        this.aTitle = pTitle;
        this.aDuration = pDuration;
    }

    /**
     * Gets the movie ID.
     *
     * @return the unique identifier of this movie
     */
    public int getpMovieID() {
        return this.aMovieID;
    }

    /**
     * Sets the movie ID.
     *
     * @param pMovieID the new movie ID to set
     */
    public void setpMovieID(int pMovieID) {
        this.aMovieID = pMovieID;
    }

    /**
     * Gets the movie title.
     *
     * @return the title of this movie
     */
    public String getpTitle() {
        return this.aTitle;
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
     * Gets the movie duration.
     *
     * @return the duration of this movie in minutes
     */
    public int getpDuration() {
        return this.aDuration;
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
     * Returns a string representation of the movie.
     *
     * @return a string in the format "[ID]  [Title] ([Duration] mins)"
     */
    @Override
    public String toString() {
        return this.aMovieID + "  " + this.aTitle + " (" + this.aDuration + " mins)";
    }
}
