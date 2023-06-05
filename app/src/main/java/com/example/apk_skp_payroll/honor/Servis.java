package com.example.apk_skp_payroll.honor;

public class Servis {

    private long id;
    private String nomor_antrian;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    private String nama_pelanggan;
    private String w_mulai;
    private String w_selesai;
    private String jenis_id;
    private String user_id;
    private String created_at;
    private String updated_at;

}
