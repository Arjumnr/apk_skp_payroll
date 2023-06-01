package com.example.apk_skp_payroll;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //cek apakah ada session atau tidak
                if (getSharedPreferences("user", MODE_PRIVATE).getString("id", null) != null) {
                    //jika ada
                    startActivity(new android.content.Intent(SplashScreen.this, MainActivity.class));
                } else {
                    //jika tidak
                    startActivity(new android.content.Intent(SplashScreen.this, ActivityLogin.class));
                }
            }
        }, 2000);


    }
}