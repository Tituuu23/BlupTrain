import java.util.Scanner;

class Ticket {
    private String ticketId;
    private String passengerName;
    private String destination;
    private double price;

    // Constructor
    public Ticket(String ticketId, String passengerName, String destination, double price) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.destination = destination;
        this.price = price;
    }

    // Method to display ticket details
    public void displayTicket() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Destination: " + destination);
        System.out.println("Price: " + price);
    }

    // Getters and setters (optional)
    public String getTicketId() {
        return ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }
}
