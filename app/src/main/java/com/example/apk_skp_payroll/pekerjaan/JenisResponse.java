package com.example.apk_skp_payroll.pekerjaan;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JenisResponse {

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

    public List<JenisData> getData() {
        return data;
    }

    public void setData(List<JenisData> data) {
        this.data = data;
    }

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<JenisData> data;

    public static class JenisData {

        @SerializedName("id")
        private String id;

        @SerializedName("nama_servis")
        private String nama_servis;

        @SerializedName("jenis")
        private String jenis;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNama_servis() {
            return nama_servis;
        }

        public void setNama_servis(String nama_servis) {
            this.nama_servis = nama_servis;
        }

        public String getJenis() {
            return jenis;
        }

        public void setJenis(String jenis) {
            this.jenis = jenis;
        }


    }






}
