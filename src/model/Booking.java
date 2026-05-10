package model;

import java.io.Serializable;

public class Booking implements Serializable {
    private User user;
    private Showtime showtime;
    private Seat seat;

    public Booking(User user, Showtime showtime, Seat seat) {
        this.user = user;
        this.showtime = showtime;
        this.seat = seat;
    }

    @Override
    public String toString() {
        return user + " booked " + seat + " for " + showtime;
    }
}