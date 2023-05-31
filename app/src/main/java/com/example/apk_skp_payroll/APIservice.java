package com.example.apk_skp_payroll;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIservice {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://payroll.xapps.my.id/api/"; // Replace with your API base URL

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
