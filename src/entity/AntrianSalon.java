package entity;

/**
 * Class AntrianSalon merepresentasikan satu entri dalam antrian pelanggan salon.
 * Setiap entri berisi nomor antrian, waktu masuk, status, pelanggan, dan layanan.
 */
public class AntrianSalon {

    // Atribut utama: nomor antrian dan statusnya (menunggu, sedang dilayani)
    private String noAntrian, status;

    // Objek pelanggan yang sedang mengantri
    private Pelanggan pelanggan;

    // Objek layanan yang dipilih pelanggan
    private LayananSalon layanan;

    // Konstruktor: membuat objek antrian baru saat pelanggan mendaftar
    public AntrianSalon(String noAntrian, Pelanggan pelanggan, LayananSalon layanan) {
        this.noAntrian = noAntrian; // Inisialisasi nomor antrian
        this.pelanggan = pelanggan; // Menyimpan referensi ke objek pelanggan
        this.layanan = layanan;     // Menyimpan layanan yang dipilih
        this.status = "menunggu";   // Status default saat pendaftaran
    }

    // ====================== Getter ======================

    // Mengambil nilai nomor antrian
    public String getNoAntrian() {
        return noAntrian;
    }

    // Mengambil status antrian
    public String getStatus() {
        return status;
    }

    // Mengambil objek Pelanggan
    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    // Mengambil objek LayananSalon
    public LayananSalon getLayanan() {
        return layanan;
    }

    // ====================== Setter ======================

    // Mengatur status antrian (menunggu, sedang dilayani)
    public void setStatus(String status) {
        this.status = status;
    }
