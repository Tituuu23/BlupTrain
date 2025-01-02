import java.util.Scanner;

public class BlupTrain {
    static final int baris = 5;
    static final int kolom = 5;
    static String[][] bangkuStrings = new String[baris][kolom];
    static String[][] penumpang = new String[baris * kolom][6];
    static int JumlahPenumpang = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        kursi();
        int pilihan;
       System.out.println("<<<<<< SELAMAT DATANG DI BLUP TRAIN >>>>>>"); 

        do {
            // System.out.println("\n<<<<<< SELAMAT DATANG DI BLUP TRAIN >>>>>>");
            System.out.println("\n=== Sistem Tiket Penumpang ===");
            System.out.println("1. Lihat Kursi");
            System.out.println("2. Pesan Tiket");
            System.out.println("3. Lihat Tiket");
            System.out.println("4. Update Tiket");
            System.out.println("5. Daftar Kursi Kosong");
            System.out.println("6. Hapus Tiket");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = s.nextInt();

            switch (pilihan) {
                case 1 -> LihatKursi();
                case 2 -> Create(s);
                case 3 -> Read();
                case 4 -> Update(s);
                case 5 -> KursiKosong();
                case 6 -> Delete(s);
                case 7 -> System.out.println("Terima kasih telah menggunakan sistem ini.");
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (pilihan != 7);

        s.close();
    }

    static void kursi() {
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                bangkuStrings[i][j] = "[ ]";
            }
        }
    }
        ///melihat kursi penumpang
    static void LihatKursi() {
        System.out.println("\n=== Status Kursi ===");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.print(bangkuStrings[i][j] + " ");
            }
            System.out.println();
        }
    }
    // pembuatan tiket
    static void Create(Scanner s) {
        System.out.print("\nMasukkan nomor baris (1-" + baris + "): ");
        int baris2 = s.nextInt() - 1;
        System.out.print("Masukkan nomor kolom (1-" + kolom + "): ");
        int kolom2 = s.nextInt() - 1;

        if (baris2 >= 0 && baris2 < baris && kolom2 >= 0 && kolom2 < kolom) {
            if (bangkuStrings[baris2][kolom2].equals("[ ]")) {
                System.out.print("Masukkan nama penumpang: ");
                s.nextLine();
                String name = s.nextLine();
                System.out.print("Masukkan nomor KTP: ");
                String ktp = s.next();
                System.out.print("Stasiun asal: ");
                String origin = s.next();
                System.out.print("Stasiun tujuan: ");
                String destination = s.next();
                System.out.print("Harga tiket: ");
                double price = s.nextDouble();

                bangkuStrings[baris2][kolom2] = "[X]";
                penumpang[JumlahPenumpang++] = new String[]{name, ktp, origin, destination, price + "", baris2 + "," + kolom2};
                System.out.println("Tiket berhasil dipesan untuk " + name);
            } else {
                System.out.println("Kursi sudah dipesan. Pilih kursi lain.");
            }
        } else {
            System.out.println("Nomor kursi tidak valid.");
        }
    }

    //melihat data penumpang
    static void Read() {
        System.out.println("\n=== Data Pemesanan ===");
        if (JumlahPenumpang == 0) {
            System.out.println("Tidak ada pemesanan.");
        } else {
            for (int i = 0; i < JumlahPenumpang; i++) {
                String[] details = penumpang[i];
                System.out.println("Nama: " + details[0] + "\nKTP: " + details[1] +
                        "\nAsal: " + details[2] + "\nTujuan: " + details[3] +
                        "\nHarga: " + details[4] + "\nKursi: " + details[5]);
                System.out.println("============================================");
            }
        }
    }

    //untuk update data penumpang
    static void Update(Scanner s) {
        System.out.print("\nMasukkan nama penumpang yang ingin diupdate: ");
        String name = s.next();

        for (int i = 0; i < JumlahPenumpang; i++) {
            if (penumpang[i][0].equalsIgnoreCase(name)) {
                System.out.println("Mengupdate data untuk " + name);
                System.out.print("Masukkan No KTP baru: ");
                penumpang[i][1] = s.next();
                System.out.print("Masukkan stasiun asal baru: ");
                penumpang[i][2] = s.next();
                System.out.print("Masukkan stasiun tujuan baru: ");
                penumpang[i][3] = s.next();
                System.out.print("Masukkan Harga Baru: ");
                penumpang[i][4] = s.next();
                System.out.println("Data berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Penumpang tidak ditemukan.");
    }

    //untuk melihat kursi kosong
    static void KursiKosong() {
        System.out.println("\n=== Kursi Kosong ===");
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                if (bangkuStrings[i][j].equals("[ ]")) {
                    System.out.print("[ ]"); // Menampilkan format baris-kolom kursi kosong
                } else {
                    System.out.print("[X]"); // Menampilkan kursi terisi sebagai "XX"
                }
            }
            System.out.println(); // Pindah ke baris berikutnya setelah satu baris selesai
        }
    }
    

    static void Delete(Scanner s) {
        System.out.print("\nMasukkan nomor baris (1-" + baris + "): ");
            int baris2 = s.nextInt() - 1;
            System.out.print("Masukkan nomor kolom (1-" + kolom + "): ");
            int kolom2 = s.nextInt() - 1;
    
            if (baris2 >= 0 && baris2 < baris && kolom2 >= 0 && kolom2 < kolom) {
                if (!bangkuStrings[baris2][kolom2].equals("Kosong")) {
                    System.out.println("Tiket untuk " + bangkuStrings[baris2][kolom2] + " berhasil dibatalkan.");
                    bangkuStrings[baris2][kolom2] = "[ ]";
                } else {
                    System.out.println("Kursi sudah kosong.");
                }
            } else {
                System.out.println("Nomor kursi tidak valid.");
            }
        }
       
    }

