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
        daftarKaryawan.add(new Karyawan("K1", "Dina", "Potong Rambut"));
        daftarKaryawan.add(new Karyawan("K2", "Sari", "Cuci Blow"));
        daftarKaryawan.add(new Karyawan("K3", "Rina", "Pewarnaan Rambut"));
        daftarKaryawan.add(new Karyawan("K4", "Risa", "Smoothing/Rebonding")); // Perbaiki typo

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

                case 2: // Panggil / Ganti Pelanggan yang Sedang Dilayani
                    // 1. Tampilkan karyawan yang sedang melayani pelanggan
                    List<Karyawan> karyawanSibuk = new ArrayList<>();
                    System.out.println("\n=== Karyawan yang sedang melayani pelanggan ===");
                    int idx = 1;
                    for (Karyawan k : daftarKaryawan) {
                        if (!k.isTersedia()) {
                            System.out.println(idx + ". " + k.getNamaKaryawan() + " melayani " + k.getSedangMelayani().getNama());
                            karyawanSibuk.add(k);
                            idx++;
                        }
                    }

                    if (karyawanSibuk.isEmpty()) {
                        System.out.println("Belum ada karyawan yang sedang melayani pelanggan.");
                    } else {
                        int pilihKaryawan = InputUtil.inputInt("Pilih karyawan yang sudah selesai melayani (0 untuk batal)");
                        if (pilihKaryawan > 0 && pilihKaryawan <= karyawanSibuk.size()) {
                            Karyawan selesai = karyawanSibuk.get(pilihKaryawan - 1);

                            // Tandai karyawan selesai melayani
                            System.out.println("Pelanggan " + selesai.getSedangMelayani().getNama() + " selesai dilayani oleh " + selesai.getNamaKaryawan());
                            selesai.setTersedia(true);
                            selesai.setSedangMelayani(null);

                            // Cari pelanggan baru dari antrian yang cocok untuk karyawan ini
                            AntrianSalon pelangganBaru = null;
                            List<AntrianSalon> tempQueue = new ArrayList<>();

                            while (!antrianSalon.isEmpty()) {
                                AntrianSalon calon = antrianSalon.dequeue();
                                if (calon.getLayanan().getNamaLayanan().equals(selesai.getSpesialis())) {
                                    pelangganBaru = calon;
                                    break;
                                } else {
                                    tempQueue.add(calon);
                                }
                            }

                            // Kembalikan antrian yang tidak cocok ke antrian utama
                            for (AntrianSalon a : tempQueue) {
                                antrianSalon.enqueue(a);
                            }

                            if (pelangganBaru != null) {
                                // Panggil pelanggan baru
                                pelangganBaru.setStatus("sedang dilayani");
                                selesai.setTersedia(false);
                                selesai.setSedangMelayani(pelangganBaru.getPelanggan());

                                System.out.println("Memanggil pelanggan baru: " + pelangganBaru.getPelanggan().getNama()
                                        + " dengan layanan " + pelangganBaru.getLayanan().getNamaLayanan()
                                        + ", dilayani oleh " + selesai.getNamaKaryawan());
                            } else {
                                System.out.println("Tidak ada pelanggan baru yang cocok dengan spesialis " + selesai.getSpesialis());
                            }
                        }
                    }

                    // 2. Panggil pelanggan baru untuk karyawan yang masih tersedia (jika ada)
                    boolean adaDipanggil = false;
                    List<AntrianSalon> tempQueue2 = new ArrayList<>();

                    for (Karyawan k : daftarKaryawan) {
                        if (k.isTersedia()) {
                            AntrianSalon pelangganUntukKaryawan = null;

                            while (!antrianSalon.isEmpty()) {
                                AntrianSalon calon = antrianSalon.dequeue();
                                if (calon.getLayanan().getNamaLayanan().equals(k.getSpesialis())) {
                                    pelangganUntukKaryawan = calon;
                                    break;
                                } else {
                                    tempQueue2.add(calon);
                                }
                            }

                            // Kembalikan antrian yang tidak cocok ke antrian utama
                            for (AntrianSalon a : tempQueue2) {
                                antrianSalon.enqueue(a);
                            }
                            tempQueue2.clear();

                            if (pelangganUntukKaryawan != null) {
                                pelangganUntukKaryawan.setStatus("sedang dilayani");
                                k.setTersedia(false);
                                k.setSedangMelayani(pelangganUntukKaryawan.getPelanggan());

                                System.out.println("Memanggil pelanggan: " + pelangganUntukKaryawan.getPelanggan().getNama()
                                        + " dengan layanan " + pelangganUntukKaryawan.getLayanan().getNamaLayanan()
                                        + ", dilayani oleh " + k.getNamaKaryawan());

                                adaDipanggil = true;
                            }
                        }
                    }

                    if (!adaDipanggil) {
                        System.out.println("Tidak ada pelanggan baru yang bisa dilayani saat ini.");
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
                        System.out.print((i + 1) + ". " + k.getNamaKaryawan() + " (Spesialis: " + k.getSpesialis() + ") ");

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