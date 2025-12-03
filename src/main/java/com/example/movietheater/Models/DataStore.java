package com.example.movietheater.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataStore {

    public static ObservableList<Movie> movieList = FXCollections.observableArrayList();
    public static ObservableList<ShowRoom> showRooms = FXCollections.observableArrayList();
    public static ObservableList<ShowTime> showTimes = FXCollections.observableArrayList();

    static {
        // Populate some default movies at startup
        movieList.addAll(
                new Movie(1, "Moana", 107),
                new Movie(2, "Avengers Endgame", 181),
                new Movie(3, "Hangover", 100)
        );
    }

    public static Movie getMovieById(int id) {
        for (Movie movie : movieList) {
            if (movie.getpMovieID() == id) return movie;
        }
        return null;
    }

    public static ShowRoom getShowRoomById(int id) {
        for (ShowRoom showRoom : showRooms) {
            if (showRoom.getpRoomID() == id) return showRoom;
        }
        return null;
    }
}
