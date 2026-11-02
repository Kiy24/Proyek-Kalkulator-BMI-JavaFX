/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalkullatorbmi;

/**
 *
 * @author Rizky Pratama
 */
public class PasienBMI {
    // 1. Atribut 
    private String nama;
    private String jenisKelamin;
    private int umur;
    private double beratKg;
    private double tinggiCm;

    // 2. Constructor 
    public PasienBMI(String nama, String jenisKelamin, int umur, double beratKg, double tinggiCm) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.umur = umur;
        this.beratKg = beratKg;
        this.tinggiCm = tinggiCm;
    }

    // 3. Method untuk menghitung nilai BMI
    public double hitungBMI() {
        double tinggiMeter = this.tinggiCm / 100.0; // Konversi cm ke meter
        return this.beratKg / (tinggiMeter * tinggiMeter);
    }

    // 4. Method untuk menentukan kategori BMI berdasarkan standar WHO
    public String getKategoriBMI() {
        double bmi = hitungBMI();
        if (bmi < 18.5) {
            return "Underweight (Kekurangan Berat Badan)";
        } else if (bmi < 25.0) {
            return "Normal (Ideal)";
        } else if (bmi < 30.0) {
            return "Overweight (Kelebihan Berat Badan)";
        } else {
            return "Obese (Obesitas)";
        }
    }

    // 5. Method menghitung Berat Badan Ideal (Rumus Broca) berdasarkan Jenis Kelamin
    public double hitungBeratIdeal() {
        double dasar = this.tinggiCm - 100.0;
        if (this.jenisKelamin.equalsIgnoreCase("Laki-laki")) {
            return dasar - (0.10 * dasar); // Potongan 10% untuk Laki-laki
        } else {
            return dasar - (0.15 * dasar); // Potongan 15% untuk Perempuan
        }
    }

    // 6. Method catatan tambahan berdasarkan Umur
    public String getCatatanUmur() {
        if (this.umur < 18) {
            return "Catatan: Untuk usia di bawah 18 tahun (remaja/anak), kategori BMI di atas hanya bersifat estimasi kasar.";
        } else if (this.umur >= 60) {
            return "Catatan: Untuk usia lansia (60+ tahun), rentang BMI sedikit di atas normal sering kali tetap sehat untuk menjaga kepadatan tulang.";
        } else {
            return "Kategori dihitung berdasarkan standar BMI dewasa (18 - 59 tahun).";
        }
    }

    // Getter dasar
    public String getNama() { return nama; }
    public String getJenisKelamin() { return jenisKelamin; }
    public int getUmur() { return umur; }
}

