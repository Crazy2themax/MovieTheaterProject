package com.example.movietheater.Models;

/**
 * Represents a show room in the movie theater.
 * <p>
 * Each show room has a unique identifier and can host movie showtimes.
 * This class provides basic information about theater rooms.
 * </p>
 *
 * @author Maxim Gosselin
 * @version 1.0
 */
public class ShowRoom {

    /** The unique identifier for this show room. */
    private int aRoomID;

    /**
     * Constructs a new ShowRoom with the specified room ID.
     *
     * @param pRoomID the unique identifier for this show room
     */
    public ShowRoom(int pRoomID) {
        this.aRoomID = pRoomID;
    }

    /**
     * Gets the room ID.
     *
     * @return the unique identifier of this show room
     */
    public int getpRoomID() {
        return this.aRoomID;
    }

    /**
     * Sets the room ID.
     *
     * @param pRoomID the new room ID to set
     */
    public void setpRoomID(int pRoomID) {
        this.aRoomID = pRoomID;
    }

    /**
     * Returns a string representation of the show room.
     *
     * @return a string in the format "Room [ID]"
     */
    @Override
    public String toString() {
        return "Room " + this.aRoomID;
    }
}