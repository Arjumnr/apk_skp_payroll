package com.example.apk_skp_payroll.honor;

public class HonorRequest {
    String user_id;
    String penjualan_id;
    String service_id;

    public HonorRequest(String user_id, String penjualan_id, String service_id) {
        this.user_id = user_id;
        this.penjualan_id = penjualan_id;
        this.service_id = service_id;
    }
}
