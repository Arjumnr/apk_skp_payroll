package com.example.apk_skp_payroll.penjualan;

import com.google.gson.annotations.SerializedName;

public class PenjualanResponse {

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private PenjualanData data;

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

    public PenjualanData getData() {
        return data;
    }

    public void setData(PenjualanData data) {
        this.data = data;
    }

    public static class PenjualanData{
        @SerializedName("id")
        private int id;

        @SerializedName("nama_pelanggan")
        private String nama_pelanggan;

        @SerializedName("nama_barang")
        private String nama_barang;

        @SerializedName("deskripsi")
        private String deskripsi;

        @SerializedName("user_id")
        private String user_id;

    }



}
