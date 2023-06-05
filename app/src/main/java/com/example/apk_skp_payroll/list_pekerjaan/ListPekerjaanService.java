package com.example.apk_skp_payroll.list_pekerjaan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ListPekerjaanService {
    @GET("get-pekerjaan/{id}")
    Call<ListPekerjaanResponse> getListPekerjaan(@Path("id") long id);


    @GET("put-to-selesai/{id}")
    Call<ToSelesaiResponse> putToSelesai(@Path("id") long id);
}
