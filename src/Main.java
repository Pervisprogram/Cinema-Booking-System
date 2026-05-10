import service.CinemaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CinemaService cinema = new CinemaService();
        cinema.load();
        cinema.addDemoData();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Show showtimes");
            System.out.println("2. Show seats");
            System.out.println("3. Book seat");
            System.out.println("4. Save & Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> cinema.showShowtimes();
                case 2 -> {
                    System.out.print("Show index: ");
                    int index = sc.nextInt();
                    cinema.showSeats(index);
                }
                case 3 -> {
                    System.out.print("Show index: ");
                    int show = sc.nextInt();
                    System.out.print("Seat number: ");
                    int seat = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Your name: ");
                    String name = sc.nextLine();
                    cinema.bookSeat(show, seat, name);
                }
                case 4 -> {
                    cinema.save();
                    return;
                }
            }
        }
    }
}