import java.util.ArrayList;
import java.util.Scanner;

class Flight {
    String flightNumber;
    String destination;
    int availableSeats;

    public Flight(String flightNumber, String destination, int availableSeats) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }
}

class AirlineReservationSystem {
    private ArrayList<Flight> flights;

    public AirlineReservationSystem() {
        flights = new ArrayList<>();
        flights.add(new Flight("AI101", "New York", 5));
        flights.add(new Flight("AI102", "Los Angeles", 2));
        flights.add(new Flight("AI103", "Chicago", 3));
    }

    public void displayFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            System.out.println("Flight Number: " + flight.getFlightNumber() +
                               ", Destination: " + flight.getDestination() +
                               ", Available Seats: " + flight.getAvailableSeats());
        }
    }

    public void bookFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                if (flight.getAvailableSeats() > 0) {
                    flight.bookSeat();
                    System.out.println("Successfully booked flight " + flightNumber);
                    return;
                } else {
                    System.out.println("No available seats on flight " + flightNumber);
                    return;
                }
            }
        }
        System.out.println("Flight not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AirlineReservationSystem system = new AirlineReservationSystem();

        while (true) {
            System.out.println("\nWelcome to the Airline Reservation System");
            System.out.println("1. Display Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    system.displayFlights();
                    break;
                case 2:
                    System.out.print("Enter flight number to book: ");
                    String flightNumber = scanner.nextLine();
                    system.bookFlight(flightNumber);
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
