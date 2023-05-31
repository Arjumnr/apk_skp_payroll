package com.example.apk_skp_payroll.penjualan;

public class PenjualanRequest {


    String nama_pelanggan;
    String nama_barang;
    String deskripsi;
    String user_id;

    public PenjualanRequest(String nama_pelanggan, String nama_barang, String deskripsi, String user_id) {
        this.nama_pelanggan = nama_pelanggan;
        this.nama_barang = nama_barang;
        this.deskripsi = deskripsi;
        this.user_id = user_id;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }
    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }
    public String getNama_barang() {
        return nama_barang;
    }
    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


}
