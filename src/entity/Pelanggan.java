package entity;

public class Pelanggan {
//    private String id;
    private String nama;
    private LayananSalon layanan;

    public Pelanggan( String nama, LayananSalon layanan) {
//        this.id = id;
        this.nama = nama;
        this.layanan = layanan;
    }

//    public String getId() {
//        return id;
//    }

    public String getNama() {
        return nama;
    }

    public LayananSalon getLayanan() {
        return layanan;
    }

}

