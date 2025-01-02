import java.util.Scanner;

public class puti {

    static final int ROWS = 5;
    static final int COLS = 5;
    static String[][] seats = new String[ROWS][COLS]; // 2D array for seat arrangement
    static String[][] bookings = new String[100][7]; // Array to store booking details
    static int bookingCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeSeats();
        
        int choice;
        do {
            System.out.println("\nTicketing System:");
            System.out.println("1. Create Booking");
            System.out.println("2. View Bookings");
            System.out.println("3. Update Booking");
            System.out.println("4. Delete Booking");
            System.out.println("5. View Seats");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createBooking(scanner);
                case 2 -> viewBookings();
                case 3 -> updateBooking(scanner);
                case 4 -> deleteBooking(scanner);
                case 5 -> viewSeats();
                case 6 -> System.out.println("Exiting the system...");
                default -> System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    static void initializeSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seats[i][j] = "[ ]"; // Empty seat
            }
        }
    }
// untuk codingan lihat bangku penumpang
    static void viewSeats() {
        System.out.println("\nSeat Arrangement:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void createBooking(Scanner scanner) {
        System.out.println("\nEnter booking details:");
        System.out.print("ID: ");
        String id = scanner.next();
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("KTP Number: ");
        String ktp = scanner.next();
        System.out.print("Origin Station: ");
        String origin = scanner.next();
        System.out.print("Destination Station: ");
        String destination = scanner.next();
        System.out.print("Number of Tickets: ");
        int tickets = scanner.nextInt();
        System.out.print("Payment Amount: ");
        double payment = scanner.nextDouble();

        if (assignSeats(tickets)) {
            bookings[bookingCount][0] = id;
            bookings[bookingCount][1] = name;
            bookings[bookingCount][2] = ktp;
            bookings[bookingCount][3] = origin;
            bookings[bookingCount][4] = destination;
            bookings[bookingCount][5] = String.valueOf(tickets);
            bookings[bookingCount][6] = String.valueOf(payment);
            bookingCount++;
            System.out.println("Booking successfully created.");
        } else {
            System.out.println("Not enough seats available.");
        }
    }

    static boolean assignSeats(int tickets) {
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (seats[i][j].equals("[ ]")) {
                    seats[i][j] = "[X]"; // Mark as booked
                    count++;
                    if (count == tickets) return true;
                }
            }
        }
        return false; // Not enough seats available
    }

    

    static void updateBooking(Scanner scanner) {
        System.out.print("\nEnter booking ID to update: ");
        String id = scanner.next();

        for (int i = 0; i < bookingCount; i++) {
            if (bookings[i][0].equals(id)) {
                System.out.println("Updating details for booking ID: " + id);
                System.out.print("New Name: ");
                bookings[i][1] = scanner.next();
                System.out.print("New KTP Number: ");
                bookings[i][2] = scanner.next();
                System.out.print("New Origin Station: ");
                bookings[i][3] = scanner.next();
                System.out.print("New Destination Station: ");
                bookings[i][4] = scanner.next();
                System.out.print("New Number of Tickets: ");
                bookings[i][5] = scanner.next();
                System.out.print("New Payment Amount: ");
                bookings[i][6] = scanner.next();
                System.out.println("Booking updated successfully.");
                return;
            }
        }
        System.out.println("Booking ID not found.");
    }

    static void deleteBooking(Scanner scanner) {
        System.out.print("\nEnter booking ID to delete: ");
        String id = scanner.next();

        for (int i = 0; i < bookingCount; i++) {
            if (bookings[i][0].equals(id)) {
                for (int j = i; j < bookingCount - 1; j++) {
                    bookings[j] = bookings[j + 1];
                }
                bookingCount--;
                System.out.println("Booking deleted successfully.");
                return;
            }
        }
        System.out.println("Booking ID not found.");
    }
}
