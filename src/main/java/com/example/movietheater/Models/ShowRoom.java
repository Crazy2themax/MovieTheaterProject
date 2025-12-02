package com.example.movietheater.Models;


public class ShowRoom {

    /**
     * The unique identifier for the room.
     */
    private int aRoomID;

    /**
     * The maximum number of people the room can hold.
     */
    private int aCapacity;

    /**
     * The room number or name.
     */
    private String aRoomNumber;

    //constructor
    public ShowRoom(int roomID, int capacity, String roomNumber) {
        this.aRoomID = roomID;
        this.aCapacity = capacity;
        this.aRoomNumber = roomNumber;
    }

    //Properties
    public int getpRoomID() {
        return aRoomID;
    }
    public int getpCapacity() {
        return aCapacity;
    }
    public String getpRoomNumber() {
        return aRoomNumber;
    }

    //properties (Setters)
    public void setpRoomID(int roomID) {
        this.aRoomID = roomID;
    }
    public void setpCapacity(int capacity) {
        this.aCapacity = capacity;

    }

    public void setpRoomNumber(String roomNumber) {
        this.aRoomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Room " + aRoomNumber + " (Capacity: " + aCapacity + ")";
    }
}