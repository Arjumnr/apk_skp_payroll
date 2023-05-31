package com.example.apk_skp_payroll.login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {
    @FormUrlEncoded
    @POST("login") // Replace with the actual login endpoint
    Call<LoginResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );


}
