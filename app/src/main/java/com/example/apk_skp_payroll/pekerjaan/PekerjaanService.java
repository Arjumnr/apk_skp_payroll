package com.example.apk_skp_payroll.pekerjaan;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PekerjaanService {

    @GET("get-antrian-kerja")
    Call<AntrianResponse> getAntrianKerja();

    @GET("get-jenis")
    Call<JenisResponse> getJenisService();

    @POST("add-pekerjaan")
    Call<PekerjaanResponse> postPekerjaan(@Body PekerjaanRequest pekerjaanRequest);
}
