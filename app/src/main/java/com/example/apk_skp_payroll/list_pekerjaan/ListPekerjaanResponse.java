package com.example.apk_skp_payroll.list_pekerjaan;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListPekerjaanResponse {
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

    public List<ModelData> getData() {
        return data;
    }

    public void setData(List<ModelData> data) {
        this.data = data;
    }

    @SerializedName("data")
    private List<ModelData> data;

}
