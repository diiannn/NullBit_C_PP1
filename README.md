# Sistem Antrian Salon 

## Deskripsi Aplikasi
Sistem Antrian Salon adalah sebuah aplikasi sederhana berbasis konsol yang dirancang untuk membantu mengelola antrian pelanggan di sebuah salon. Aplikasi ini menyediakan fungsionalitas untuk mencatat pelanggan yang datang, memanggil pelanggan berikutnya untuk dilayani, melihat status antrian saat ini, serta memantau ketersediaan karyawan. Proyek ini diimplementasikan menggunakan bahasa pemrograman Java, memanfaatkan struktur data antrian (Queue) untuk mengatur alur pelanggan secara efisien.

## Fitur Utama
* **Manajemen Antrian Pelanggan**:
    * **Tambah Antrian**: Memungkinkan staf salon untuk menambahkan nama pelanggan baru dan layanan yang mereka pilih ke dalam antrian.
    * **Panggil Pelanggan Berikutnya**: Secara otomatis memanggil pelanggan yang berada di urutan paling depan antrian dan menugaskannya ke karyawan yang tersedia.
    * **Lihat Antrian Selanjutnya**: Menampilkan informasi pelanggan yang akan dilayani berikutnya tanpa menghapus mereka dari antrian.
    * **Tampilkan Semua Antrian**: Menampilkan daftar lengkap semua pelanggan yang saat ini berada dalam antrian beserta status layanan mereka.
* **Daftar Layanan Salon**: Menampilkan daftar layanan yang tersedia di salon, lengkap dengan perkiraan harga dan durasi.
* **Status Karyawan**: Memungkinkan pengguna untuk melihat status ketersediaan setiap karyawan, apakah mereka `tersedia` atau `sedang melayani` pelanggan tertentu.

## Instalasi dan Persyaratan Sistem

### Persyaratan Sistem:
* **Java Development Kit (JDK)**.
* Sistem Operasi yang mendukung Java (Windows, macOS, Linux).
* Ruang disk yang cukup untuk menyimpan file proyek (ukuran proyek sangat kecil).

### Langkah-langkah Instalasi:
Tidak ada proses instalasi yang kompleks karena ini adalah aplikasi konsol Java sederhana. Anda hanya perlu menyiapkan lingkungan pengembangan Java Anda dan mendapatkan file proyek:

1.  **Pastikan JDK Terinstal**: Verifikasi bahwa Anda memiliki JDK yang terinstal di sistem Anda. Anda bisa memeriksanya dengan membuka terminal/command prompt dan mengetik:
    ```bash
    java -version
    ```
    Jika belum terinstal, unduh dan instal dari situs resmi Oracle atau melalui manajer paket sistem operasi Anda.

2.  **Dapatkan Kode Sumber Proyek**:
    Dapatkan folder proyek `NullBit_C_PP1` (misalnya, melalui unduhan file zip) dan letakkan di lokasi yang Anda inginkan pada sistem Anda. Pastikan struktur folder proyek tetap utuh.

3.  **Navigasi ke Direktori Proyek**:
    Buka terminal atau command prompt dan navigasikan ke direktori utama proyek `NullBit_C_PP1` (folder yang berisi `src` dan `.idea`).

## Cara Menjalankan Aplikasi

### Langkah-langkah Menjalankan:

1.  **Kompilasi Seluruh File Java:**
    Dari direktori utama proyek (`NullBit_C_PP1`), gunakan perintah `javac` untuk mengkompilasi semua file `.java` yang ada di dalam folder `src`, termasuk yang berada di sub-folder `entity`, `service`, dan `util`. Anda perlu menjalankan perintah ini dari direktori induk `src`.
    ```bash
    # Pastikan Anda berada di direktori NullBit_C_PP1
    javac -d out src/AntrianSalonMain.java src/entity/*.java src/service/*.java src/util/*.java
    ```
    Perintah ini akan membuat folder `out` di direktori proyek utama dan menempatkan semua file `.class` (bytecode) yang telah terkompilasi di sana.

2.  **Jalankan Aplikasi:**
    Setelah berhasil dikompilasi, Anda dapat menjalankan aplikasi dari direktori proyek utama (`NullBit_C_PP1`) menggunakan perintah `java`:
    Aplikasi akan mulai berjalan dan menampilkan menu utama di konsol Anda.

## Penggunaan Aplikasi

Setelah aplikasi berhasil dijalankan, Anda akan melihat **Menu Utama Salon** di konsol. Anda dapat memilih opsi dengan memasukkan angka yang sesuai dan menekan `Enter`.

```
═══════════════════════════════════
    SISTEM ANTRIAN SALON CANTIK
                                   
═══════════════════════════════════
╔═════════════════════════════════╗
║        MENU UTAMA SALON         ║
╠═════════════════════════════════╣
║ 1. Tambah Daftar Antrian        ║
║ 2. Panggil Pelanggan Berikutnya ║
║ 3. Lihat Antrian Selanjutnya    ║
║ 4. Tampilkan Semua Antrian      ║
║ 5. Lihat Daftar Layanan         ║
║ 6. Lihat Status Karyawan        ║
║ 7. Keluar                       ║
╚═════════════════════════════════╝
Pilih menu :
```

Berikut adalah detail penggunaan untuk setiap opsi:

* **1. Tambah Daftar Antrian**:
    * Masukkan `1` dan tekan Enter.
    * Aplikasi akan meminta Anda "Masukkan nama pelanggan". Ketik nama pelanggan dan tekan Enter.
    * Setelah itu, Anda akan melihat "DAFTAR LAYANAN SALON". Pilih nomor layanan yang diinginkan (misalnya `1` untuk "Potong Rambut") dan tekan Enter.
    * Anda bisa terus menambahkan pelanggan lain atau ketik `done` saat diminta nama pelanggan untuk kembali ke menu utama.

* **2. Panggil Pelanggan Berikutnya**:
    * Masukkan `2` dan tekan Enter.
    * Aplikasi akan memanggil pelanggan di urutan pertama antrian dan menugaskannya ke karyawan yang tersedia. Jika tidak ada karyawan yang tersedia, pelanggan akan tetap dalam antrian.
    * Jika antrian kosong, akan muncul pesan "Tidak ada antrian.".

* **3. Lihat Antrian Selanjutnya**:
    * Masukkan `3` dan tekan Enter.
    * Aplikasi akan menampilkan nama pelanggan dan layanan dari antrian terdepan tanpa mengubah status antrian.
    * Jika tidak ada antrian, akan muncul pesan "Tidak ada antrian selanjutnya.".

* **4. Tampilkan Semua Antrian**:
    * Masukkan `4` dan tekan Enter.
    * Aplikasi akan menampilkan daftar lengkap semua pelanggan dalam antrian, beserta nomor antrian, nama, layanan, dan statusnya (misalnya "menunggu" atau "sedang dilayani").

* **5. Lihat Daftar Layanan**:
    * Masukkan `5` dan tekan Enter.
    * Aplikasi akan menampilkan kembali daftar layanan salon yang tersedia.

* **6. Lihat Status Karyawan**:
    * Masukkan `6` dan tekan Enter.
    * Aplikasi akan menampilkan daftar karyawan yang terdaftar beserta status ketersediaan mereka (tersedia atau sedang melayani pelanggan tertentu).
    * Aplikasi akan menampilkan daftar karyawan yang terdaftar beserta status ketersediaan mereka (tersedia atau sedang melayani pelanggan tertentu).
Jika ada karyawan yang sedang sibuk, aplikasi akan bertanya apakah ada karyawan yang sudah selesai melayani. Jika y (ya), Anda akan diminta memilih nomor karyawan yang sudah selesai, dan sistem akan mengubah status karyawan tersebut menjadi tersedia kembali.

* **7. Keluar**:
    * Masukkan `7` dan tekan Enter.
    * Aplikasi akan menampilkan pesan terima kasih dan kemudian keluar.

Setelah setiap operasi (kecuali "Keluar"), Anda akan diminta untuk `Tekan ENTER untuk melanjutkan...`. Tekan Enter untuk kembali ke menu utama.
