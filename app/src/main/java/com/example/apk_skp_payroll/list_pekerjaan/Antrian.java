package com.example.apk_skp_payroll.list_pekerjaan;

public class Antrian {
    private long id;
    private String nama;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    private String nomor;
    private String status;
    private String createdAt;
    private String updatedAt;

    public Antrian(long id, String nama, String nomor, String status, String createdAt, String updatedAt) {
        this.id = id;
        this.nama = nama;
        this.nomor = nomor;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


}
