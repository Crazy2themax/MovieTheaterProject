package com.example.movietheater.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Centralized data storage class for the movie theater application.
 * <p>
 * This class manages all in-memory data including movies, show rooms, and showtimes.
 * It provides static observable lists that can be bound to JavaFX UI components
 * and utility methods for retrieving specific entities by ID.
 * </p>
 *
 * @author Maxim Gosselin
 * @version 1.0
 */
public class DataStore {

    /** Observable list containing all movies in the system. */
    public static ObservableList<Movie> movieList = FXCollections.observableArrayList();

    /** Observable list containing all show rooms in the system. */
    public static ObservableList<ShowRoom> showRooms = FXCollections.observableArrayList();

    /** Observable list containing all showtimes in the system. */
    public static ObservableList<ShowTime> showTimes = FXCollections.observableArrayList();

    static {
        // Populate some default movies at startup
        movieList.addAll(
                new Movie(1, "Moana", 107),
                new Movie(2, "Avengers Endgame", 181),
                new Movie(3, "Hangover", 100)
        );
    }

    /**
     * Retrieves a movie by its unique ID.
     *
     * @param pId the ID of the movie to retrieve
     * @return the Movie object with the matching ID, or null if not found
     */
    public static Movie getMovieById(int pId) {
        for (Movie movie : movieList) {
            if (movie.getpMovieID() == pId) {
                return movie;
            }
        }
        return null;
    }

    /**
     * Retrieves a show room by its unique ID.
     *
     * @param pId the ID of the show room to retrieve
     * @return the ShowRoom object with the matching ID, or null if not found
     */
    public static ShowRoom getShowRoomById(int pId) {
        for (ShowRoom showRoom : showRooms) {
            if (showRoom.getpRoomID() == pId) {
                return showRoom;
            }
        }
        return null;
    }
}
