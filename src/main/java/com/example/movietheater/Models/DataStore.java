package com.example.movietheater.Models;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

    public static List<Movie> movieList = new ArrayList<>();
    public static List<ShowRoom> showRooms = new ArrayList<>();
    public static List<ShowTime> showTimes = new ArrayList<>();

    //This will allow us to get a movie by its ID
    public static Movie getMovieById(int id) {
        for (Movie movie : movieList) {
            if (movie.getpMovieID() == id)
                return movie;
        }
        return null;
    }

    public static ShowRoom getShowRoomById(int id) {
        for (ShowRoom showRoom : showRooms) {
            if(showRoom.getpRoomID()==id) return showRoom;

        }
        return null;
    }
}
