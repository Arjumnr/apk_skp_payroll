package com.example.apk_skp_payroll.penjualan;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PenjualanService {
    @POST("pembelian")
    Call<PenjualanResponse> postData(@Body PenjualanRequest penjualanRequest);

    @GET("get-barang")
    Call<BarangResponse> getDataBarang();

}
