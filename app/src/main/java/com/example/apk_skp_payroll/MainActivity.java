package com.example.apk_skp_payroll;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { // onCreate() is called when the activity is first created.
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btnLogout = findViewById(R.id.btn_logout);
        ImageView btnPenjualan = findViewById(R.id.btn_penjualan);
        ImageView btnPekejaan = findViewById(R.id.btn_pekerjaan);
        ImageView btnListPekerjaan = findViewById(R.id.btnListPekerjaan);
        ImageView btnHonor = findViewById(R.id.btn_honor);

        String name = getSharedPreferences("user", MODE_PRIVATE)
                .getString("name", null);


        if (name == null) {
            System.out.println("name null");
            startActivity(new Intent(MainActivity.this, ActivityLogin.class));
        } else {
            System.out.println("name xx null");
            TextView tName = findViewById(R.id.tx_name);
            tName.setText(name);
        }


        btnPenjualan.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ActivityPenjualan.class)));

        btnPekejaan.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ActivityPekerjaan.class)));

        btnListPekerjaan.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ActivityListPekerjaan.class)));

        btnHonor.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ActivityHonor.class)));

        btnLogout.setOnClickListener(v -> {
//            alert dialog
            new android.app.AlertDialog.Builder(MainActivity.this)
                    .setTitle("Logout")
                    .setMessage("Apakah anda yakin ingin logout?")
                    .setPositiveButton("Ya", (dialog, which) -> {
                        getSharedPreferences("user", MODE_PRIVATE)
                                .edit()
                                .clear()
                                .apply();
                        startActivity(new Intent(MainActivity.this, ActivityLogin.class));
                        finish();
                    })
                    .setNegativeButton("Tidak", null)
                    .show();
        });


    }
}