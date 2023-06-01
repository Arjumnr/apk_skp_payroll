package com.example.apk_skp_payroll.pekerjaan;

import com.google.gson.annotations.SerializedName;

public class PekerjaanResponse {
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

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    public PekerjaanData getData() {
        return data;
    }

    public void setData(PekerjaanData data) {
        this.data = data;
    }

    @SerializedName("data")
    private PekerjaanData data;



    public static class PekerjaanData{
        @SerializedName("id")
        private String id;

        @SerializedName("nomor_antrian")
        private String nomor_antrian;

        @SerializedName("nama_pelanggan")
        private String nama_pelanggan;

        @SerializedName("w_mulai")
        private String w_mulai;

        @SerializedName("w_selesai")
        private String w_selesai;

        @SerializedName("jenis_id")
        private String jenis_id;

        @SerializedName("user_id")
        private String user_id;




    }


}
