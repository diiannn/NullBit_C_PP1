package entity;

// Import untuk menangani tanggal dan waktu
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        this.noAntrian = noAntrian;
        this.pelanggan = pelanggan;
        this.layanan = layanan;
        this.status = "menunggu"; // status default
    }

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

    // Mengatur status antrian (menunggu, sedang dilayani, selesai, dll)
    public void setStatus(String status) {
        this.status = status;
    }

}
