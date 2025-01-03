import java.util.Scanner;

public class fix {
    static final int ROWS = 5;
    static final int COLS = 5;
    static String[][] seats = new String[ROWS][COLS];
    static String[][] passengerDetails = new String[ROWS * COLS][6];
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
            System.out.println("5. Daftar Kursi Kosong");
            System.out.println("6. Hapus Tiket");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewSeats();
                case 2 -> bookTicket(scanner);
                case 3 -> viewBookings();
                case 4 -> updateBooking(scanner);
                case 5 -> viewEmptySeats();
                case 6 -> cancelTicket(scanner);
                case 7 -> System.out.println("Terima kasih telah menggunakan sistem ini.");
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (choice != 7);

        scanner.close();
    }

    static void initializeSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seats[i][j] = "[ ]";
            }
        }
    }

    static void viewSeats() {
        System.out.println("\n=== Status Kursi ===");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bookTicket(Scanner scanner) {
        System.out.print("\nMasukkan nomor baris (1-" + ROWS + "): ");
        int row = scanner.nextInt() ;
        System.out.print("Masukkan nomor kolom (1-" + COLS + "): ");
        int col = scanner.nextInt() ;

        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            if (seats[row][col].equals("[ ]")) {
                System.out.print("Masukkan nama penumpang: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.print("Masukkan nomor KTP: ");
                String ktp = scanner.next();
                System.out.print("Stasiun asal: ");
                String origin = scanner.next();
                System.out.print("Stasiun tujuan: ");
                String destination = scanner.next();
                System.out.print("Harga tiket: ");
                double price = scanner.nextDouble();

                seats[row][col] = "[X]";
                passengerDetails[bookingCount++] = new String[]{name, ktp, origin, destination, price + "", row + "," + col};
                System.out.println("Tiket berhasil dipesan untuk " + name);
            } else {
                System.out.println("Kursi sudah dipesan. Pilih kursi lain.");
            }
        } else {
            System.out.println("Nomor kursi tidak valid.");
        }
    }

    static void viewBookings() {
        System.out.println("\n=== Data Pemesanan ===");
        if (bookingCount == 0) {
            System.out.println("Tidak ada pemesanan.");
        } else {
            for (int i = 0; i < bookingCount; i++) {
                String[] details = passengerDetails[i];
                System.out.println("Nama: " + details[0] + "\nKTP: " + details[1] +
                        "\nAsal: " + details[2] + "\nTujuan: " + details[3] +
                        "\nHarga: " + details[4] + "\nKursi: " + details[5]);
                System.out.println("============================================");
            }
        }
    }

    static void updateBooking(Scanner scanner) {
        System.out.print("\nMasukkan nama penumpang yang ingin diupdate: ");
        String name = scanner.next();

        for (int i = 0; i < bookingCount; i++) {
            if (passengerDetails[i][0].equalsIgnoreCase(name)) {
                System.out.println("Mengupdate data untuk " + name);
                System.out.print("Masukkan No KTP baru: ");
                passengerDetails[i][2] = scanner.next();
                System.out.print("Masukkan stasiun asal baru: ");
                passengerDetails[i][3] = scanner.next();
                System.out.print("Masukkan stasiun tujuan baru: ");
                passengerDetails[i][4] = scanner.next();
                System.out.print("Masukkan Harga Baru: ");
                passengerDetails[i][5] = scanner.next();
                System.out.println("Data berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Penumpang tidak ditemukan.");
    }

    static void viewEmptySeats() {
        System.out.println("\n=== Kursi Kosong ===");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (seats[i][j].equals("[ ]")) {
                    System.out.print("[ ]"); // Menampilkan format baris-kolom kursi kosong
                } else {
                    System.out.print("[X]"); // Menampilkan kursi terisi sebagai "XX"
                }
            }
            System.out.println(); // Pindah ke baris berikutnya setelah satu baris selesai
        }
    }
    

    static void cancelTicket(Scanner scanner) {
        System.out.print("\nMasukkan nomor baris (1-" + ROWS + "): ");
            int row = scanner.nextInt() - 1;
            System.out.print("Masukkan nomor kolom (1-" + COLS + "): ");
            int col = scanner.nextInt() - 1;
    
            if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
                if (!seats[row][col].equals("Kosong")) {
                    System.out.println("Tiket untuk " + seats[row][col] + " berhasil dibatalkan.");
                    seats[row][col] = "[ ]";
                } else {
                    System.out.println("Kursi sudah kosong.");
                }
            } else {
                System.out.println("Nomor kursi tidak valid.");
            }
        }
       
    }


