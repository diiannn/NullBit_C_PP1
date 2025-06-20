import entity.*;
import service.SalonQueue;
import util.InputUtil;
import util.MenuView;

import java.util.ArrayList;
import java.util.List;

public class AntrianSalonMain {
    public static void main(String[] args) {
        LayananSalon[] daftarLayananSalon = new LayananSalon[4];
        daftarLayananSalon[0] = new LayananSalon("Potong Rambut");
        daftarLayananSalon[1] = new LayananSalon("Cuci Blow");
        daftarLayananSalon[2] = new LayananSalon( "Pewarnaan Rambut");
        daftarLayananSalon[3] = new LayananSalon("Smoothing/Rebonding"); // Perbaikan di sini, sebelumnya ada typo

        Karyawan[] daftarKaryawan = new Karyawan[2];
        daftarKaryawan[0] = new Karyawan("k1", "Dina");
        daftarKaryawan[1] = new Karyawan("k2", "Sari");

        SalonQueue antrianSalon = new SalonQueue(10); // kapasitas antrian max 10

        int nomorAntrian = 1;

        while (true) {
            MenuView.displayHeader();
            int pilihan = MenuView.displayMenuUtama();

            switch (pilihan) {
                case 1: // Tambah Daftar Antrian (enqueue)
                    while (true) {
                        String namaPelanggan = InputUtil.inputString("Masukkan nama pelanggan (ketik 'done' untuk selesai)");
                        if (namaPelanggan.equalsIgnoreCase("done")) {
                            System.out.println("Selesai menambah pelanggan.");
                            break;
                        }

                        MenuView.displayLayanan();
                        int pilihanLayanan = InputUtil.inputInt("Pilih nomor layanan");

                        if (pilihanLayanan < 1 || pilihanLayanan > daftarLayananSalon.length) {
                            System.out.println("Pilihan layanan tidak valid!");
                            continue; //ulang input nama dan layanan`
                        }

                        LayananSalon layananDipilih = daftarLayananSalon[pilihanLayanan - 1];
                        Pelanggan pelanggan = new Pelanggan("" + namaPelanggan, layananDipilih);

                        AntrianSalon antrianBaru = new AntrianSalon("A" + nomorAntrian, pelanggan, layananDipilih);
                        antrianSalon.enqueue(antrianBaru);

                        nomorAntrian++;
                    }
                    break;

                case 2: // Panggil Pelanggan Berikutnya (dequeue)
                    Karyawan availableKaryawan = null;
                    for (Karyawan k : daftarKaryawan) {
                        if (k.isTersedia()) {
                            availableKaryawan = k;
                            break;
                        }
                    }

                    if (availableKaryawan != null) {
                        AntrianSalon dipanggil = antrianSalon.peek();
                        if (dipanggil != null) {
                            dipanggil.setStatus("sedang dilayani");
                            Pelanggan pelangganDipanggil = dipanggil.getPelanggan();
                            LayananSalon layananDipanggil = dipanggil.getLayanan();

                            availableKaryawan.setTersedia(false);
                            availableKaryawan.setSedangMelayani(pelangganDipanggil);

                            antrianSalon.dequeue();

                            System.out.println("Memanggil pelanggan: " + pelangganDipanggil.getNama()
                                    + " dengan layanan " + layananDipanggil.getNamaLayanan()
                                    + ", dilayani oleh " + availableKaryawan.getNamaKaryawan());
                        } else {
                            System.out.println("Tidak ada antrian.");
                        }
                    } else {
                        System.out.println("Maaf, semua karyawan sedang sibuk");
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

                case 6: // Lihat Status Karyawan DAN Selesaikan Layanan
                    System.out.println("\n=== Status Karyawan ===");
                    boolean adaKaryawanSibuk = false;
                    for (int i = 0; i < daftarKaryawan.length; i++) {
                        Karyawan k = daftarKaryawan[i];
                        System.out.print((i + 1) + ". " + k.getNamaKaryawan() + " ");

                        if (k.isTersedia()) {
                            System.out.println("tersedia.");
                        } else {
                            adaKaryawanSibuk = true;
                            Pelanggan p = k.getSedangMelayani();
                            if (p != null) {
                                System.out.println("sedang melayani pelanggan: " + p.getNama() + ".");
                            } else {
                                System.out.println("tidak tersedia"); // Ini perbaikan typo dari sebelumnya
                            }
                        }
                    }

                    if (adaKaryawanSibuk) {
                        boolean konfirmasiSelesai = InputUtil.inputBoolean("Apakah ada karyawan yang sudah selesai melayani?");
                        if (konfirmasiSelesai) {
                            System.out.println("\n--- Tandai Karyawan Selesai ---");
                            for (int i = 0; i < daftarKaryawan.length; i++) {
                                Karyawan k = daftarKaryawan[i];
                                if (!k.isTersedia()) {
                                    Pelanggan p = k.getSedangMelayani();
                                    System.out.println((i + 1) + ". " + k.getNamaKaryawan() + " - Sedang melayani: " + (p != null ? p.getNama() : "Tidak diketahui"));
                                }
                            }
                            int pilihanKaryawanSelesai = InputUtil.inputInt("Pilih nomor karyawan yang selesai melayani");
                            if (pilihanKaryawanSelesai >= 1 && pilihanKaryawanSelesai <= daftarKaryawan.length) {
                                Karyawan karyawanSelesai = daftarKaryawan[pilihanKaryawanSelesai - 1];
                                if (!karyawanSelesai.isTersedia()) {
                                    Pelanggan pelangganSelesai = karyawanSelesai.getSedangMelayani();
                                    System.out.println("Layanan untuk pelanggan " + pelangganSelesai.getNama() + " oleh " + karyawanSelesai.getNamaKaryawan() + " telah selesai.");

                                    karyawanSelesai.setTersedia(true);
                                    karyawanSelesai.setSedangMelayani(null);

                                    System.out.println("Karyawan " + karyawanSelesai.getNamaKaryawan() + " kini tersedia.");
                                } else {
                                    System.out.println("Karyawan tersebut sudah tersedia atau tidak sedang melayani siapa pun.");
                                }
                            } else {
                                System.out.println("Pilihan karyawan tidak valid.");
                            }
                        }
                    } else {
                        System.out.println("Semua karyawan tersedia. Tidak ada layanan yang perlu diselesaikan.");
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
        }
    }
}