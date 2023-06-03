package com.example.apk_skp_payroll.honor;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface HonorService {
    @POST("add-honor")
    Call<HonorResponse> postData(@Body HonorRequest honorRequest);
}
