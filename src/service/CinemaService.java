package service;

import model.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CinemaService {

    private List<Showtime> showtimes = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private final String FILE = "cinema.dat";

    public void addDemoData() {
        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        showtimes.add(new Showtime(movie, LocalDateTime.now().plusDays(1), 10));
    }

    public void showShowtimes() {
        for (int i = 0; i < showtimes.size(); i++) {
            System.out.println(i + ". " + showtimes.get(i));
        }
    }

    public void showSeats(int index) {
        showtimes.get(index).getSeats().forEach(System.out::println);
    }

    public void bookSeat(int showIndex, int seatNumber, String userName) {
        Showtime showtime = showtimes.get(showIndex);
        Seat seat = showtime.getSeats().get(seatNumber - 1);

        if (!seat.isBooked()) {
            seat.book();
            bookings.add(new Booking(new User(userName), showtime, seat));
            System.out.println("Booking successful!");
        } else {
            System.out.println("Seat already booked!");
        }
    }

    public void save() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(showtimes);
            oos.writeObject(bookings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE))) {
            showtimes = (List<Showtime>) ois.readObject();
            bookings = (List<Booking>) ois.readObject();
        } catch (Exception ignored) {}
    }
}