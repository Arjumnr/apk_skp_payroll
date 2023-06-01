package com.example.apk_skp_payroll.pekerjaan;

public class PekerjaanRequest {

    String nomor_antrian;
    String nama_pelanggan;
    String w_mulai;
    String w_selesai;
    String jenis_id;
    String user_id;

    public PekerjaanRequest(String nomor_antrian, String nama_pelanggan, String w_mulai, String w_selesai, String jenis_id, String user_id) {
        this.nomor_antrian = nomor_antrian;
        this.nama_pelanggan = nama_pelanggan;
        this.w_mulai = w_mulai;
        this.w_selesai = w_selesai;
        this.jenis_id = jenis_id;
        this.user_id = user_id;
    }

    public String getNomor_antrian() {
        return nomor_antrian;
    }

    public void setNomor_antrian(String nomor_antrian) {
        this.nomor_antrian = nomor_antrian;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getW_mulai() {
        return w_mulai;
    }

    public void setW_mulai(String w_mulai) {
        this.w_mulai = w_mulai;
    }

    public String getW_selesai() {
        return w_selesai;
    }

    public void setW_selesai(String w_selesai) {
        this.w_selesai = w_selesai;
    }

    public String getJenis_id() {
        return jenis_id;
    }

    public void setJenis_id(String jenis_id) {
        this.jenis_id = jenis_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


}
