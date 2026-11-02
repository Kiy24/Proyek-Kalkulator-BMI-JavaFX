package com.mycompany.kalkullatorbmi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class PrimaryController {

    @FXML private TextField txtNama;
    @FXML private RadioButton rbLakiLaki;
    @FXML private RadioButton rbPerempuan;
    @FXML private ToggleGroup grupGender;
    @FXML private TextField txtUmur;
    @FXML private TextField txtBerat;
    @FXML private TextField txtTinggi;
    @FXML private Label lblHasilBMI;
    @FXML private Label lblDetail;

    @FXML
    private void handleHitung(ActionEvent event) {
      
        String nama = txtNama.getText().trim();
        String strUmur = txtUmur.getText().trim();
        String strBerat = txtBerat.getText().trim().replace(",", "."); 
        String strTinggi = txtTinggi.getText().trim().replace(",", ".");
      
        if (nama.isEmpty() || strUmur.isEmpty() || strBerat.isEmpty() || strTinggi.isEmpty()) {
            tampilkanAlert("Kolom Kosong", "Harap lengkapi seluruh kolom (Nama, Umur, Berat, dan Tinggi) sebelum menghitung!");
            return; 
        }

        if (nama.matches(".*\\d.*")) {
            tampilkanAlert("Input Nama Tidak Valid", "Kolom Nama tidak boleh mengandung angka!");
            return;
        }

        int umur;
        double berat;
        double tinggi;

        try {
            umur = Integer.parseInt(strUmur);
            berat = Double.parseDouble(strBerat);
            tinggi = Double.parseDouble(strTinggi);
        } catch (NumberFormatException e) {
            tampilkanAlert("Format Angka Salah", "Kolom Umur harus berupa bilangan bulat, sedangkan Berat dan Tinggi harus berupa angka yang valid (bukan huruf)!");
            return;
        }

        if (umur <= 0 || umur > 120) {
            tampilkanAlert("Umur Tidak Wajar", "Masukkan umur yang wajar (antara 1 hingga 120 tahun)!");
            return;
        }
        if (berat <= 2.0 || berat > 500.0) {
            tampilkanAlert("Berat Badan Tidak Wajar", "Masukkan berat badan yang valid (antara 2 kg hingga 500 kg)!");
            return;
        }
        if (tinggi < 50.0 || tinggi > 270.0) {
            tampilkanAlert("Tinggi Badan Tidak Wajar", "Masukkan tinggi badan dalam satuan sentimeter (cm) yang wajar (antara 50 cm hingga 270 cm)!");
            return;
        }

        String jenisKelamin = rbLakiLaki.isSelected() ? "Laki-laki" : "Perempuan";

        PasienBMI pasien = new PasienBMI(nama, jenisKelamin, umur, berat, tinggi);

        double nilaiBMI = pasien.hitungBMI();
        String kategori = pasien.getKategoriBMI();
        double beratIdeal = pasien.hitungBeratIdeal();

        lblHasilBMI.setText(String.format("Skor BMI: %.2f — %s", nilaiBMI, kategori));

        String detailTeks = String.format(
            "Halo %s (%s, %d thn).\nEstimasi berat badan ideal Anda: %.1f kg.\n%s",
            pasien.getNama(), pasien.getJenisKelamin(), pasien.getUmur(),
            beratIdeal, pasien.getCatatanUmur()
        );
        lblDetail.setText(detailTeks);
    }

    @FXML
    private void handleReset(ActionEvent event) {
        txtNama.clear();
        txtUmur.clear();
        txtBerat.clear();
        txtTinggi.clear();
        rbLakiLaki.setSelected(true);
        lblHasilBMI.setText("Silakan masukkan data dan klik Hitung BMI");
        lblDetail.setText("");
        txtNama.requestFocus(); 
    }

    private void tampilkanAlert(String judul, String pesan) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Peringatan Input");
        alert.setHeaderText(judul);
        alert.setContentText(pesan);
        alert.showAndWait();
    }
}
