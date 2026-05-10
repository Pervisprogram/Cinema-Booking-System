package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Showtime implements Serializable {
    private Movie movie;
    private LocalDateTime dateTime;
    private List<Seat> seats = new ArrayList<>();

    public Showtime(Movie movie, LocalDateTime dateTime, int seatCount) {
        this.movie = movie;
        this.dateTime = dateTime;
        for (int i = 1; i <= seatCount; i++) {
            seats.add(new Seat(i));
        }
    }

    public Movie getMovie() { return movie; }
    public LocalDateTime getDateTime() { return dateTime; }
    public List<Seat> getSeats() { return seats; }

    @Override
    public String toString() {
        return movie + " | " + dateTime;
    }
}