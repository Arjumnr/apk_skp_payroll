package com.example.apk_skp_payroll.honor;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HonorResponse {
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

    public List<ModelDataHonor> getData() {
        return data;
    }

    public void setData(List<ModelDataHonor> data) {
        this.data = data;
    }

    @SerializedName("data")
    public List<ModelDataHonor> data;

}
