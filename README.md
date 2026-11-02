# Aplikasi Kalkulator BMI (JavaFX & Scene Builder)

Proyek ini adalah aplikasi desktop sederhana untuk menghitung Body Mass Index (BMI) atau Indeks Massa Tubuh yang dibangun menggunakan bahasa pemrograman Java, kerangka kerja JavaFX berbasis Maven, serta Gluon Scene Builder untuk perancangan antarmuka pengguna (UI).

## Identitas Pengembang

* Nama: Rizky Pratama
* Kelas: MKB 3A
* NIM: 2508475
* Program Studi: Mekatronika dan Kecerdasan Buatan

## Tampilan Antarmuka

<img width="959" height="568" alt="Screenshot 2026-11-02 082532" src="https://github.com/user-attachments/assets/25881da8-2183-4532-b22d-0a06811ff501" />


## Fitur Utama

* Perhitungan nilai BMI otomatis berdasarkan input berat badan (kg) dan tinggi badan (cm).
* Penentuan kategori BMI sesuai standar WHO (Underweight, Normal, Overweight, dan Obese).
* Estimasi berat badan ideal menggunakan rumus Broca berdasarkan pilihan jenis kelamin.
* Catatan informasi tambahan yang disesuaikan dengan kelompok umur pengguna.
* Validasi input berlapis menggunakan dialog peringatan (Alert) untuk mencegah kolom kosong, input berupa huruf pada kolom angka, serta nilai negatif atau di luar batas wajar.
* Fitur Reset untuk mengosongkan seluruh formulir secara instan.

## Struktur Proyek

Proyek ini disusun dengan pendekatan Model-View-Controller (MVC) sederhana:

* `App.java`: Kelas utama untuk memuat file FXML dan menjalankan jendela aplikasi JavaFX.
* `PasienBMI.java`: Kelas model yang menyimpan atribut pengguna dan menangani seluruh logika perhitungan BMI serta berat badan ideal.
* `PrimaryController.java`: Kelas pengendali yang menghubungkan komponen antarmuka dengan logika program serta menangani validasi input pengguna.
* `primary.fxml`: File antarmuka pengguna yang dirancang menggunakan Scene Builder.

## Panduan Navigasi dan Penggunaan

1. Masukkan nama lengkap pada kolom Nama Lengkap.
2. Pilih salah satu opsi pada bagian Jenis Kelamin (Laki-laki atau Perempuan).
3. Masukkan usia dalam satuan tahun pada kolom Umur.
4. Masukkan berat badan dalam satuan kilogram pada kolom Berat Badan dan tinggi badan dalam satuan sentimeter pada kolom Tinggi Badan.
5. Klik tombol Hitung BMI untuk menampilkan skor BMI, kategori, estimasi berat ideal, serta catatan usia pada panel hasil di bagian bawah.
6. Klik tombol Reset jika ingin menghapus seluruh isian formulir dan memulai perhitungan baru.

## Cara Menjalankan Program di Apache NetBeans

1. Unduh atau lakukan clone pada repository ini ke komputer lokal.
2. Buka aplikasi Apache NetBeans IDE.
3. Pilih menu File, lalu klik Open Project.
4. Arahkan ke folder proyek ini dan klik Open Project.
5. Pastikan koneksi internet aktif saat pertama kali membuka proyek agar Maven dapat mengunduh dependensi JavaFX secara otomatis jika belum tersedia.
6. Klik tombol Run Project (atau tekan tombol F6 pada papan ketik) untuk menjalankan aplikasi.
