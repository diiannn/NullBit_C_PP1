package entity;

    public class LayananSalon {
        private String kodeLayanan, namaLayanan, kategori;
        private double harga; // tipe data numerik (pecahan), untuk menyimpan nilai yang ada komanya, seperti harga dll
        private int estimasiWaktu;

        public LayananSalon(String kodeLayanan, String namaLayanan, String kategori, double harga, int estimasiWaktu) {
            this.kodeLayanan = kodeLayanan;
            this.namaLayanan = namaLayanan;
            this.kategori = kategori;
            this.harga = harga;
            this.estimasiWaktu = estimasiWaktu;
        }

        // getter
//        public String getKodeLayanan() {
//            return kodeLayanan;
//        }

        public String getNamaLayanan() {
            return namaLayanan;
        }

//        public String getKategori() {
//            return kategori;
//        }
//
//        public double getHarga() {
//            return harga;
//        }
//
//        public int getEstimasiWaktu() {
//            return estimasiWaktu;
//        }

        // setter

//        public void setKodeLayanan(String kodeLayanan) {
//            this.kodeLayanan = kodeLayanan;
//        }
//
//        public void setNamaLayanan(String namaLayanan) {
//            this.namaLayanan = namaLayanan;
//        }
//
//        public void setKategori(String kategori) {
//            this.kategori = kategori;
//        }
//
//        public void setHarga(double harga) {
//            this.harga = harga;
//        }
//
//        public void setEstimasiWaktu(int estimasiWaktu) {
//            this.estimasiWaktu = estimasiWaktu;
//        }
    }


