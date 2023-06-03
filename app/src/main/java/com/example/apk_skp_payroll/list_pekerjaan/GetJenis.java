package com.example.apk_skp_payroll.list_pekerjaan;

public class GetJenis {
    private long id;
    private String jenis;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNamaServis() {
        return namaServis;
    }

    public void setNamaServis(String namaServis) {
        this.namaServis = namaServis;
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

    private String namaServis;
    private String createdAt;
    private String updatedAt;

    public GetJenis(long id, String jenis, String namaServis, String createdAt, String updatedAt) {
        this.id = id;
        this.jenis = jenis;
        this.namaServis = namaServis;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
