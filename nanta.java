import java.util.Scanner;

public class nanta {
    static final int ROWS = 5; // Jumlah baris kursi
    static final int COLUMNS = 5; // Jumlah kolom kursi
    static String[][] seats = new String[ROWS][COLUMNS]; // Array 2D untuk kursi
    static int bookingCount = 0;
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            initializeSeats();
            int choice;
    
            do {
                System.out.println("\n=== Sistem Tiket Penumpang ===");
                System.out.println("1. Lihat Kursi");
                System.out.println("2. Pesan Tiket");
                System.out.println("3. Lihat Tiket");
                System.out.println("4. Update Tiket");
                System.out.println("5. Daftar kursi kosong");
                System.out.println("6. Hapus Tiket");
                System.out.println("7. Keluar");
                System.out.print("Pilih menu: ");
                choice = scanner.nextInt();
    
                switch (choice) {
                    case 1:
                        viewSeats();
                        break;
                    case 2:
                        bookTicket(scanner);
                        break;
                    case 3:
                        viewBookings();
                        break;
                    case 4:
                        updateBooking(scanner);
                        break;
                    case 5:
                        listPassengers();
                        break;
                    case 6:
                        cancelTicket(scanner);
                        break;
                    case 7:
                        System.out.println("Terima kasih telah menggunakan sistem ini.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Coba lagi.");
                }
            } while (choice != 5);
    
            scanner.close();
        }
    
        // Inisialisasi kursi dengan status kosong
        public static void initializeSeats() {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLUMNS; j++) {
                    seats[i][j] = "[ ]";
                }
            }
        }
    
        // Menampilkan status kursi
        public static void viewSeats() {
            System.out.println("\n=== Status Kursi ===");
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLUMNS; j++) {
                    System.out.print(seats[i][j] + " ");
                }
                System.out.println();
            }
        }
        static void viewBookings() {
            System.out.println("\nBooking Details:");
            if (bookingCount == 0) {
                System.out.println("No bookings found.");
            } else {
                for (int i = 0; i < bookingCount; i++) {
                    
                }
            }
        }
    
        // Memesan tiket
        public static void bookTicket(Scanner scanner) {
            System.out.print("\nMasukkan nomor baris (1-" + ROWS + "): ");
            int row = scanner.nextInt() - 1;
            System.out.print("Masukkan nomor kolom (1-" + COLUMNS + "): ");
            int col = scanner.nextInt() - 1;
            if (row >= 0 && row < ROWS && col >= 0 && col < COLUMNS) {
                if (seats[row][col].equals("[ ]")) {
                    System.out.print("Masukkan nama penumpang: ");
                    scanner.nextLine(); // Membersihkan buffer
                    String nama = scanner.nextLine();
                    System.out.println("\nEnter booking details:");
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("KTP Number: ");
                    int ktp = scanner.nextInt();
                    System.out.print("Asal Station: ");
                    String origin = scanner.next();
                    System.out.print("Tujuan Station: ");
                    String destination = scanner.next();
                    System.out.print("Jumlah Tiket: ");
                    int tickets = scanner.nextInt();
                    System.out.print("Harga: ");
                    double payment = scanner.nextDouble();
                    seats[row][col] = "[X]";
                    System.out.println("Tiket berhasil dipesan untuk " + nama);
                    
                } else {
                    System.out.println("Kursi sudah dipesan. Pilih kursi lain.");
                }
            } else {
                System.out.println("Nomor kursi tidak valid.");
            }
        }
    
        // Membatalkan tiket
        public static void cancelTicket(Scanner scanner) {
            System.out.print("\nMasukkan nomor baris (1-" + ROWS + "): ");
            int row = scanner.nextInt() - 1;
            System.out.print("Masukkan nomor kolom (1-" + COLUMNS + "): ");
            int col = scanner.nextInt() - 1;
    
            if (row >= 0 && row < ROWS && col >= 0 && col < COLUMNS) {
                if (!seats[row][col].equals("Kosong")) {
                    System.out.println("Tiket untuk " + seats[row][col] + " berhasil dibatalkan.");
                    seats[row][col] = "Kosong";
                } else {
                    System.out.println("Kursi sudah kosong.");
                }
            } else {
                System.out.println("Nomor kursi tidak valid.");
            }
        }static void updateBooking(Scanner scanner) {
            System.out.print("\nEnter booking ID to update: ");
            String id = scanner.next();
    
            for (int i = 0; i < bookingCount; i++) {
            if (seats[i][0].equals(id)) {
                System.out.println("Updating details for booking ID: " + id);
                System.out.print("New Name: ");
                seats[i][1] = scanner.next();
                System.out.print("New KTP Number: ");
                seats[i][2] = scanner.next();
                System.out.print("New Origin Station: ");
                seats[i][3] = scanner.next();
                System.out.print("New Destination Station: ");
                seats[i][4] = scanner.next();
                System.out.print("New Number of Tickets: ");
                seats[i][5] = scanner.next();
                System.out.print("New Payment Amount: ");
                seats[i][6] = scanner.next();
                System.out.println("Booking updated successfully.");
                return;
            }
        }
        System.out.println("Booking ID not found.");
    }

    // Menampilkan daftar penumpang
    public static void listPassengers() {
        System.out.println("\n=== Daftar Penumpang ===");
        boolean hasPassengers = false;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (!seats[i][j].equals("Kosong")) {
                    System.out.println("Baris " + (i + 1) + " Kolom " + (j + 1) + ": " + seats[i][j]);
                    hasPassengers = true;
                }
            }
        }
        if (!hasPassengers) {
            System.out.println("Tidak ada penumpang.");
        }
    } 
    // public static void listPassengers() {
    //     System.out.println("\n=== Daftar Penumpang ===");
    //         if (bookingCount == 0) {
    //             System.out.println("No bookings found.");
    //         } else {
    //             for (int i = 0; i < bookingCount; i++) {
    //                 System.out.println((i + 1) + ". ID: " + seats[i][0] + ", Name: " + seats[i][1] + ", KTP: " + seats[i][2]
    //                         + ", Origin: " + seats[i][3] + ", Destination: " + seats[i][4] + ", Tickets: " + seats[i][5]
    //                         + ", Payment: " + seats[i][6]);
    //             }
    //         }
        
    // }

}
