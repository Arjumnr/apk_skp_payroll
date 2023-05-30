package com.example.apk_skp_payroll;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { // onCreate() is called when the activity is first created.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cek apakah sudah login atau belum
        String username = getSharedPreferences("login", MODE_PRIVATE)
                .getString("username", null);


        if (username == null) {
            startActivity(new Intent(MainActivity.this, ActivityLogin.class));
        } else {
            TextView tusername = findViewById(R.id.tx_name);
            tusername.setText("Halo " + username);
        }


    }
}