package com.example.apk_skp_payroll.list_pekerjaan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ListPekerjaanService {
    @GET("get-pekerjaan?}")
    Call<ListPekerjaanResponse> getListPekerjaan(@Query("id") long id);
}
