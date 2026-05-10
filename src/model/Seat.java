package model;

import java.io.Serializable;

public class Seat implements Serializable {
    private int number;
    private boolean booked;

    public Seat(int number) {
        this.number = number;
        this.booked = false;
    }

    public int getNumber() { return number; }
    public boolean isBooked() { return booked; }

    public void book() { this.booked = true; }

    @Override
    public String toString() {
        return "Seat " + number + (booked ? " (Booked)" : " (Free)");
    }
}