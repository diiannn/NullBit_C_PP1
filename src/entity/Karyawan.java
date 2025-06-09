package entity;

import entity.Pelanggan;

// Class Karyawan mewakili data seorang pegawai salon (kapster)
public class Karyawan {

    // Atribut idKaryawan: ID unik dari karyawan
    // namaKaryawan: nama lengkap karyawan
    // spesialis: layanan yang dikuasai oleh karyawan
    private String idKaryawan, namaKaryawan;
    private boolean tersedia;  // Atribut tersedia menandakan apakah karyawan sedang tersedia untuk melayani pelanggan
    private Pelanggan sedangMelayani;

    // Konstruktor untuk menginisialisasi data karyawan baru dengan status tersedia
    public Karyawan(String idKaryawan, String namaKaryawan) {
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.tersedia = true;
        this.sedangMelayani = null;
    }

    // Getter dan Setter untuk Nama Karyawan
    public String getNamaKaryawan() { return namaKaryawan; }

    // Getter dan Setter untuk Status Ketersediaan
    public boolean isTersedia() { return tersedia; }
    public void setTersedia(boolean tersedia) { this.tersedia = tersedia; }

    // Getter dan Setter untuk Pelanggan yang sedang dilayani
    public Pelanggan getSedangMelayani() { return sedangMelayani; }
    public void setSedangMelayani(Pelanggan pelanggan) { this.sedangMelayani = pelanggan; }

    // Override method toString untuk menampilkan nama dan spesialis karyawan
    @Override
    public String toString() {
        return namaKaryawan + "(" + sedangMelayani + ")";
    }
}