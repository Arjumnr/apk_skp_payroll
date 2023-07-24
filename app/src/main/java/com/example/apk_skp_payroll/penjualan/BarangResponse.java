package com.example.apk_skp_payroll.penjualan;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BarangResponse {

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBarang> getData() {
        return data;
    }

    public void setData(List<DataBarang> data) {
        this.data = data;
    }

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<DataBarang> data;

    public static class DataBarang{
        @SerializedName("id")
        private String id;

        @SerializedName("nama_barang")
        private String nama_barang;

        @SerializedName("harga")
        private String harga;

        @SerializedName("stok")
        private String stok;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNama_barang() {
            return nama_barang;
        }

        public void setNama_barang(String nama_barang) {
            this.nama_barang = nama_barang;
        }

        public String getHarga() {
            return harga;
        }

        public void setHarga(String harga) {
            this.harga = harga;
        }

        public String getStok() {
            return stok;
        }

        public void setStok(String stok) {
            this.stok = stok;
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

        @SerializedName("created_at")
        private String created_at;

        @SerializedName("updated_at")
        private String updated_at;


    }
}
