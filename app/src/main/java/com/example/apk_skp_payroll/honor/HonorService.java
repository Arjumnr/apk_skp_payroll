package com.example.apk_skp_payroll.honor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HonorService {
    @GET("get-honor/{id}")
    Call<HonorResponse> getHonor(@Path("id") long id);
}
