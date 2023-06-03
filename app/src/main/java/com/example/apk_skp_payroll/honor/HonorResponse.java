package com.example.apk_skp_payroll.honor;

import com.google.gson.annotations.SerializedName;

public class HonorResponse {
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataHonor getData() {
        return data;
    }

    public void setData(DataHonor data) {
        this.data = data;
    }

    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataHonor data;

    public static class DataHonor{

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getPenjualan_id() {
            return penjualan_id;
        }

        public void setPenjualan_id(String penjualan_id) {
            this.penjualan_id = penjualan_id;
        }

        public String getServis_id() {
            return servis_id;
        }

        public void setServis_id(String servis_id) {
            this.servis_id = servis_id;
        }

        @SerializedName("user_id")
        private String user_id;

        @SerializedName("penjualan_id")
        private String penjualan_id;

        @SerializedName("servis_id")
        private String servis_id;

    }



}
