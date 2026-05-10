package model;

import java.io.Serializable;

public class Movie implements Serializable {
    private String title;
    private String genre;
    private int duration;

    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public String getTitle() { return title; }

    @Override
    public String toString() {
        return title + " | " + genre + " | " + duration + " min";
    }
}