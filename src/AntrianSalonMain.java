import entity.*;
import service.SalonQueue;
import util.InputUtil;
import util.MenuView;

import java.util.ArrayList;
import java.util.List;

public class AntrianSalonMain {
    public static void main(String[] args) {
        // Buat daftar layanan salon (bisa dikembangkan lagi)
        List<LayananSalon> daftarLayanan = new ArrayList<>();
        daftarLayanan.add(new LayananSalon("L1", "Potong Rambut", "Rambut", 25000, 30));
        daftarLayanan.add(new LayananSalon("L2", "Cuci Blow", "Rambut", 35000, 45));
        daftarLayanan.add(new LayananSalon("L3", "Pewarnaan Rambut", "Rambut", 80000, 90));
        daftarLayanan.add(new LayananSalon("L4", "Smoothing/Rebonding", "Rambut", 150000, 120));

        List<Karyawan> daftarKaryawan = new ArrayList<>();
        daftarKaryawan.add(new Karyawan("K1", "Dina"));        // Tanpa parameter spesialis
        daftarKaryawan.add(new Karyawan("K2", "Sari"));

        SalonQueue antrianSalon = new SalonQueue(10); // kapasitas antrian max 10

        int nomorAntrian = 1;

        while (true) {
            MenuView.displayHeader();
            int pilihan = MenuView.displayMenuUtama();

            switch (pilihan) {
                case 1: // Daftar Antrian (enqueue)
                    while (true) {
                        String namaPelanggan = InputUtil.inputString("Masukkan nama pelanggan (ketik 'done' untuk selesai)");
                        if (namaPelanggan.equalsIgnoreCase("done")) {
                            System.out.println("Selesai menambah pelanggan.");
                            break;
                        }

                        MenuView.displayLayanan();
                        int pilihanLayanan = InputUtil.inputInt("Pilih nomor layanan");

                        if (pilihanLayanan < 1 || pilihanLayanan > daftarLayanan.size()) {
                            System.out.println("Pilihan layanan tidak valid!");
                            continue;  // ulang input nama dan layanan
                        }

                        LayananSalon layananDipilih = daftarLayanan.get(pilihanLayanan - 1);
                        Pelanggan pelanggan = new Pelanggan("P" + nomorAntrian, namaPelanggan, layananDipilih);

                        AntrianSalon antrianBaru = new AntrianSalon("A" + nomorAntrian, pelanggan, layananDipilih);
                        antrianSalon.enqueue(antrianBaru);

//                        System.out.println("Pelanggan " + namaPelanggan + " ditambahkan ke antrian dengan nomor A" + nomorAntrian);

                        nomorAntrian++;
                    }
                    break;

                case 2: // Panggil Pelanggan Berikutnya (dequeue)
                    AntrianSalon dipanggil = antrianSalon.dequeue();
                    if (dipanggil != null) {
                        dipanggil.setStatus("sedang dilayani");
                        Pelanggan pelangganDipanggil = dipanggil.getPelanggan();
                        LayananSalon layananDipanggil = dipanggil.getLayanan();

                        // Cari karyawan yang tersedia (tanpa spesialisasi)
                        boolean ketemu = false;
                        for (Karyawan k : daftarKaryawan) {
                            if (k.isTersedia()) {  // Hanya cek tersedia atau tidak
                                k.setTersedia(false);
                                k.setSedangMelayani(pelangganDipanggil);
                                ketemu = true;
                                System.out.println("Memanggil pelanggan: " + pelangganDipanggil.getNama()
                                        + " dengan layanan " + layananDipanggil.getNamaLayanan()
                                        + ", dilayani oleh " + k.getNamaKaryawan());
                                break;
                            }
                        }
                        if (!ketemu) {
                            System.out.println("Maaf, semua karyawan sedang sibuk.");
                            antrianSalon.enqueue(dipanggil);
                            dipanggil.setStatus("menunggu");
                        }
                    } else {
                        System.out.println("Tidak ada antrian.");
                    }
                    break;


                case 3: // Lihat Antrian Selanjutnya (peek)
                    AntrianSalon selanjutnya = antrianSalon.peek();
                    if (selanjutnya != null) {
                        System.out.println("Antrian selanjutnya: " + selanjutnya.getPelanggan().getNama()
                                + " dengan layanan " + selanjutnya.getLayanan().getNamaLayanan());
                    } else {
                        System.out.println("Tidak ada antrian selanjutnya.");
                    }
                    break;

                case 4: // Tampilkan Semua Antrian
                    antrianSalon.display();
                    break;

                case 5: // Lihat Daftar Layanan
                    MenuView.displayLayanan();
                    break;

                case 6: // Lihat Status Karyawan
                    System.out.println("\n=== Status Karyawan ===");
                    for (int i = 0; i < daftarKaryawan.size(); i++) {
                        Karyawan k = daftarKaryawan.get(i);
                        System.out.print((i + 1) + ". " + k.getNamaKaryawan() + " ");  // Hapus bagian spesialis

                        if (k.isTersedia()) {
                            System.out.println("tersedia.");
                        } else {
                            Pelanggan p = k.getSedangMelayani();
                            if (p != null) {
                                System.out.println("sedang melayani pelanggan: " + p.getNama() + ".");
                            } else {
                                System.out.println("tidak tersedia.");
                            }
                        }
                    }
                    break;

                case 7: // Keluar
                    System.out.println("Terima kasih telah menggunakan sistem antrian salon.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }

            InputUtil.tekanEnterUntukLanjut();
            //System.out.println("\nTekan enter untuk melanjutkan...");
//            InputUtil.inputString("");
        }
    }
}