package Entity;

// Class Karyawan mewakili data seorang pegawai salon (kapster)
public class Karyawan {

    // Atribut idKaryawan: ID unik dari karyawan
    // namaKaryawan: nama lengkap karyawan
    // spesialis: layanan yang dikuasai oleh karyawan
    private String idKaryawan, namaKaryawan;

    // Atribut tersedia menandakan apakah karyawan sedang tersedia untuk melayani pelanggan
    private boolean tersedia;

    // Atribut pelangganAktif menyimpan informasi pelanggan yang sedang dilayani saat ini (jika ada)
    private Pelanggan pelangganAktif; // Tambahan untuk menyimpan pelanggan yang sedang dilayani

    // Konstruktor untuk menginisialisasi data karyawan baru dengan status tersedia
    public Karyawan(String idKaryawan, String namaKaryawan) {
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.tersedia = true;
        this.pelangganAktif = null;
    }

    // Getter dan Setter untuk ID Karyawan
    public String getIdKaryawan() { return idKaryawan; }
    public void setIdKapster(String idKapster) { this.idKaryawan = idKapster; }

    // Getter dan Setter untuk Nama Karyawan
    public String getNamaKaryawan() { return namaKaryawan; }
    public void setNamaKaryawan(String namaKapster) { this.namaKaryawan = namaKapster; }

    // Getter dan Setter untuk Status Ketersediaan
    public boolean isTersedia() { return tersedia; }
    public void setTersedia(boolean tersedia) { this.tersedia = tersedia; }

    // Getter dan Setter untuk Pelanggan yang sedang dilayani
    public Pelanggan getSedangMelayani() { return pelangganAktif; }
    public void setSedangMelayani(Pelanggan pelanggan) { this.pelangganAktif = pelanggan; }

    // Override method toString untuk menampilkan nama dan spesialis karyawan
    @Override
    public String toString() {
        return namaKaryawan + "(" + sedangMelayani + ")";
    }
}
