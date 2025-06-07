package util;

public class MenuView {
    public static void displayHeader() {
        System.out.println("═══════════════════════════════════");
        System.out.println("    SISTEM ANTRIAN SALON CANTIK    ");
        System.out.println("                                   ");
        System.out.println("═══════════════════════════════════");
    }

    public static int displayMenuUtama() {
        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║        MENU UTAMA SALON         ║");
        System.out.println("╠═════════════════════════════════╣");
        System.out.println("║ 1. Tambah Daftar Antrian        ║");
        System.out.println("║ 2. Panggil Pelanggan Berikutnya ║");
        System.out.println("║ 3. Lihat Antrian Selanjutnya    ║");
        System.out.println("║ 4. Tampilkan Semua Antrian      ║");
        System.out.println("║ 5. Lihat Daftar Layanan         ║");
        System.out.println("║ 6. Lihat Status Karyawan        ║");
        System.out.println("║ 7. Keluar                       ║");
        System.out.println("╚═════════════════════════════════╝");

        return InputUtil.inputInt("Pilih menu");
    }

    public static void displayLayanan() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║                    DAFTAR LAYANAN SALON                ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ No │ Layanan              │ Harga    │ Waktu │ Kategori║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ 1  │ Potong Rambut        │ Rp 25000 │ 30min │ Rambut  ║");
        System.out.println("║ 2  │ Cuci Blow            │ Rp 35000 │ 45min │ Rambut  ║");
        System.out.println("║ 3  │ Pewarnaan Rambut     │ Rp 80000 │ 90min │ Rambut  ║");
        System.out.println("║ 4  │ Smoothing/Rebonding  │ Rp150000 │120min │ Rambut  ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
