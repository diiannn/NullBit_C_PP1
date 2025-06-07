package entity;

public class Pelanggan {
    private String nama;
    private LayananSalon layanan;

    public Pelanggan( String nama, LayananSalon layanan) {
        this.nama = nama;
        this.layanan = layanan;
    }

    public String getNama() {
        return nama;
    }

    public LayananSalon getLayanan() {
        return layanan;
    }

}

