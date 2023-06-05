package com.example.apk_skp_payroll.list_pekerjaan;

public class ToSelesaiResponse {

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

    public Antrian getData() {
        return data;
    }

    public void setData(Antrian data) {
        this.data = data;
    }

    private boolean status;
    private String message;
    private Antrian data;
}
