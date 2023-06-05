package com.example.apk_skp_payroll.honor;

public class Jenis {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNama_servis() {
        return nama_servis;
    }

    public void setNama_servis(String nama_servis) {
        this.nama_servis = nama_servis;
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

    private int id;
    private String jenis;
    private String nama_servis;
    private String created_at;
    private String updated_at;
}
