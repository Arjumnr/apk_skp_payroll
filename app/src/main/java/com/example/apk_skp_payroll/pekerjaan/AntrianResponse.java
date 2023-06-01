package com.example.apk_skp_payroll.pekerjaan;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AntrianResponse {

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

    public List<AntrianKerja> getData() {
        return data;
    }

    public void setData(List<AntrianKerja> data) {
        this.data = data;
    }

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<AntrianKerja> data;




    public static class AntrianKerja{
        @SerializedName("nomor")
        private String nomor;

        @SerializedName("nama")
        private String nama;

        public String getNomor() {
            return nomor;
        }

        public void setNomor(String nomor) {
            this.nomor = nomor;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

    }
}
