package service;

import entity.AntrianSalon;

/**
 * Kelas SalonQueue mengimplementasikan struktur data Queue (antrian) berbasis array sirkular.
 * Digunakan untuk menyimpan data antrian pelanggan salon.
 */
public class SalonQueue {
    // Array yang menampung objek-objek antrian pelanggan
    private AntrianSalon[] array;

    // Variabel untuk mengatur kapasitas, indeks depan, indeks belakang, dan ukuran antrian saat ini
    private int capacity, front, rear, size;

    /**
     * Konstruktor SalonQueue: inisialisasi array antrian dengan kapasitas tertentu
     * @param capacity jumlah maksimum data dalam antrian
     */
    public SalonQueue(int capacity){
        this.capacity = capacity;
        array = new AntrianSalon[capacity]; // alokasikan array
        front = 0;   // posisi depan (untuk dequeue)
        rear = -1;   // posisi belakang (untuk enqueue)
        size = 0;    // jumlah elemen awal 0
    }

    /**
     * Mengecek apakah antrian kosong
     * @return true jika kosong, false jika tidak
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Mengecek apakah antrian penuh
     * @return true jika penuh, false jika tidak
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Menambahkan elemen ke antrian (enqueue)
     * @param antrian objek AntrianSalon yang akan dimasukkan ke antrian
     */
    public void enqueue(AntrianSalon antrian) {
        if (isFull()) {
            // Jika antrian penuh, tampilkan pesan
            System.out.println("Antrian penuh! Mohon tunggu hingga slot kosong");
            return;
        }
        // Perhitungan rear dengan array sirkular (modulo)
        rear = (rear + 1) % capacity;
        array[rear] = antrian; // masukkan data ke posisi rear
        size++; // tambahkan ukuran antrian
        System.out.println("Pelanggan " + antrian.getPelanggan().getNama() +
                " ditambahkan ke antrian dengan nomor " + antrian.getNoAntrian());
    }

    /**
     * Menghapus dan mengembalikan elemen terdepan dari antrian (dequeue)
     * @return objek AntrianSalon yang dihapus dari depan antrian
     */
    public AntrianSalon dequeue() {
        if (isEmpty()) {
            // Jika antrian kosong, tampilkan pesan
            System.out.println("Antrian kosong! Tidak ada pelanggan yang menunggu.");
            return null;
        }
        AntrianSalon antrian = array[front];  // ambil data di posisi depan
        array[front] = null; // hapus referensi untuk membantu garbage collector (opsional)
        front = (front + 1) % capacity; // geser indeks front ke depan
        size--; // kurangi ukuran antrian
        return antrian; // kembalikan data yang di-dequeue
    }

    /**
     * Melihat elemen terdepan tanpa menghapus dari antrian (peek)
     * @return objek AntrianSalon di depan antrian
     */
    public AntrianSalon peek() {
        if (isEmpty()) {
            System.out.println("Antrian kosong! Tidak ada pelanggan yang menunggu.");
            return null;
        }
        return array[front];
    }

    /**
     * Mendapatkan jumlah elemen dalam antrian saat ini
     * @return jumlah data dalam antrian
     */
    public int size() {
        return size;
    }

    /**
     * Menghapus seluruh data dari antrian dan mengatur ulang semua posisi
     */
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            array[i] = null;
        }
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan!");
    }

    /**
     * Menampilkan seluruh elemen dalam antrian secara berurutan
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Antrian kosong! Tidak ada pelanggan yang menunggu.");
            return;
        }

        System.out.println("\n---- Daftar Antrian Salon ----");
        System.out.println("Jumlah Antrian: " + size());

        // Menampilkan data dari indeks front hingga rear, menangani array sirkular
        int count = 0;
        int i = front;
        while (count < size) {
            AntrianSalon antrian = array[i];
            System.out.println((count + 1) + ". " + antrian.getNoAntrian()
                    + " - " + antrian.getPelanggan().getNama()
                    + " (" + antrian.getLayanan().getNamaLayanan() + ")"
                    + " - Status: " + antrian.getStatus());
            i = (i + 1) % capacity;
            count++;
        }
        System.out.println("-------------------------------");
    }
}
