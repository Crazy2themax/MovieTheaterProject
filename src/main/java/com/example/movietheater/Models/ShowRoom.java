package com.example.movietheater.Models;

public class ShowRoom {

    private int aRoomID;

    public ShowRoom(int roomID) {
        this.aRoomID = roomID;
    }

    public int getpRoomID() {
        return aRoomID;
    }

    public void setpRoomID(int roomID) {
        this.aRoomID = roomID;
    }

    @Override
    public String toString() {
        return "Room " + aRoomID;
    }
}
