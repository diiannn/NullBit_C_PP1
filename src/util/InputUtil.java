package util;
import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInt(String info) { // static bisa dipanggil tanpa membuat objek, mengembalikan nilai int
        // parameter info teks yang akan ditampilkan sebagai petunjuk input.
        System.out.print(info + " : "); // petunjuk kepada pengguna agar tau apa yang harus diinput.
        while (true) { // perulangan tanpa batas sampai memasukkan input yang benar
            try {
                String input = scanner.nextLine(); // membaca input pengguna dari keyboard sebagai string
                return  Integer.parseInt(input); //Integer bisa menerima lebih banyak dan bisa di pakai di kelas generik
                // mengubah input bertipe
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka.");
            }
        }
    }

    public static String inputString(String info) {
        System.out.print(info + " :");
        return scanner.nextLine();
    }

    public static void tekanEnterUntukLanjut() {
        System.out.println("\nTekan ENTER untuk melanjutkan...");
        scanner.nextLine();
    }
}
