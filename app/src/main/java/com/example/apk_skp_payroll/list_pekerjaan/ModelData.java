package com.example.apk_skp_payroll.list_pekerjaan;

import com.google.gson.annotations.SerializedName;

public class ModelData {
    private long id;
    private String nomorAntrian;
    private String namaPelanggan;
    private String wMulai;
    private String wSelesai;
    private String jenisID;
    private String userID;
    private String createdAt;
    private String updatedAt;
    private Antrian antrian;
    private GetJenis getJenis;

    @SerializedName("id")
    public long getID() { return id; }
    @SerializedName("id")
    public void setID(long value) { this.id = value; }

    @SerializedName("nomor_antrian")
    public String getNomorAntrian() { return nomorAntrian; }
    @SerializedName("nomor_antrian")
    public void setNomorAntrian(String value) { this.nomorAntrian = value; }

    @SerializedName("nama_pelanggan")
    public String getNamaPelanggan() { return namaPelanggan; }
    @SerializedName("nama_pelanggan")
    public void setNamaPelanggan(String value) { this.namaPelanggan = value; }

    @SerializedName("w_mulai")
    public String getWMulai() { return wMulai; }
    @SerializedName("w_mulai")
    public void setWMulai(String value) { this.wMulai = value; }

    @SerializedName("w_selesai")
    public String getWSelesai() { return wSelesai; }
    @SerializedName("w_selesai")
    public void setWSelesai(String value) { this.wSelesai = value; }

    @SerializedName("jenis_id")
    public String getJenisID() { return jenisID; }
    @SerializedName("jenis_id")
    public void setJenisID(String value) { this.jenisID = value; }

    @SerializedName("user_id")
    public String getUserID() { return userID; }
    @SerializedName("user_id")
    public void setUserID(String value) { this.userID = value; }

    @SerializedName("created_at")
    public String getCreatedAt() { return createdAt; }
    @SerializedName("created_at")
    public void setCreatedAt(String value) { this.createdAt = value; }

    @SerializedName("updated_at")
    public String getUpdatedAt() { return updatedAt; }
    @SerializedName("updated_at")
    public void setUpdatedAt(String value) { this.updatedAt = value; }

    @SerializedName("antrian")
    public Antrian getAntrian() { return antrian; }
    @SerializedName("antrian")
    public void setAntrian(Antrian value) { this.antrian = value; }

    @SerializedName("get_jenis")
    public GetJenis getGetJenis() { return getJenis; }
    @SerializedName("get_jenis")
    public void setGetJenis(GetJenis value) { this.getJenis = value; }
}
