import java.util.Scanner;
public class tiket {
    public static void main(String[] args) {
        int pilihan;
        int harga = 60000;
        int harga1 = 120000;
        int harga2 = 85000;
        int nik = 0;
        String nama = "";
        String email = "";
        Scanner s = new Scanner (System.in);
        System.out.println("<<<<<<SELAMAT DATANG DI BLUP TRAIN>>>>>>\n");
        System.out.print(" 1. create\n 2. read\n 3. update\n 4. delete");
        System.out.print("\nPilih no berapa: ");
        pilihan = s.nextInt();
        s.nextLine();// Membersihkan buffer setelah nextInt()
        clearScreen(); // Membersihkan layar setelah input data
        if (pilihan == 1){
            System.out.println("<<<<<<< REGISTRASI >>>>>>>>>>>");
            System.out.print("Nama: ");
            nama = s.nextLine();
            System.out.print("NIK: ");
            nik = s.nextInt();
            s.nextLine(); // Membersihkan buffer setelah nextInt()
            System.out.print("Email: ");
            email = s.nextLine();
            clearScreen(); // Membersihkan layar setelah input data

            System.out.println("<<<<<< KATEGORI >>>>>>");
            System.out.println("list asal dan tujuan:\n1. Purwokerto -> Purworejo\n2. Purwokerto -> Yogyakarta\n3. Purworejo -> Purwokerto\n4. Yogyakarta -> Purwokerto\n5. Purworejo -> Yogyakarta\n6. Yogyakarta -> Purworejo");
            System.out.print("Asal stasiun: ");
            String asal = s.nextLine();
            System.out.print("Tujuan stasiun: ");
            String tujuan = s.nextLine();
            clearScreen(); // Membersihkan layar setelah input data

            System.out.println("------ Jadwal Keberangkatan ------");
            System.out.print("Masukkan tanggal: ");
            int tanggal = s.nextInt();
            System.out.print("Masukkan bulan (angka): ");
            int bulan = s.nextInt();
            System.out.print("Masukkan tahun: ");
            int tahun = s.nextInt();
            System.out.print("jam keberangkatan:\n1. 08.00\n2. 12.00\n3. 16.00\njam berapa:  ");
            int jam = s.nextInt();
            clearScreen();

            System.out.println("<<<<<<< KERETA DAN KURSI >>>>>>");
            System.out.print("Pilih kereta:\n1. Ekonomi\n2. eksekutive\npilih nomor berapa: ");
            int kereta = s.nextInt();
            clearScreen();

            System.out.println("<<<<<< ISI DATA PENUMPANG >>>>>>");
            System.out.print("Dewasa: ");
            int dewasa = s.nextInt();
            if (kereta == 1){
            harga = harga * dewasa;
            System.out.print("Anak (umur diatas 3 tahun): ");
            int bayi = s.nextInt();
            harga = (harga * dewasa) + (harga * bayi);
            clearScreen();
            System.out.println("<<<<<< PEMBAYARAN >>>>>>");
            System.out.print("total = Rp." + harga);
            System.out.print("\npembayaran menggunakan E-wallet\n1. Dana\n2. Ovo\n3. Linkaja\n4. BlupTrainpay\n5. m-banking\npilih apa (inputkan nomornya): ");
            int pembayaran = s.nextInt();
            clearScreen();
            }
            else {
            harga = 2 * harga * dewasa;
            System.out.print("Anak (umur diatas 3 tahun): ");
            int bayi = s.nextInt();
            harga = 2 * ((harga * dewasa) + (harga * bayi));
            clearScreen();
            System.out.println("<<<<<< PEMBAYARAN >>>>>>");
            System.out.print("total = Rp." + harga);
            System.out.print("\npembayaran menggunakan E-wallet\n1. Dana\n2. Ovo\n3. Linkaja\n4. BlupTrainpay\n5. m-banking\npilih apa (inputkan nomornya): ");
            int pembayaran = s.nextInt();
            clearScreen();
            }
            

            System.out.println("<<<<<< E-TICKET >>>>>>");
            System.out.print("E-Ticket anda sudah dikirim ke Email anda");
        }
    
    }public static void clearScreen() {
        System.out.print("\033[H\033[2J"); // Escape sequence ANSI untuk membersihkan layar
        System.out.flush();
    }
}
