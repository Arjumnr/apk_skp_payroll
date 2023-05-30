package com.example.apk_skp_payroll;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLogin extends AppCompatActivity {
    Button btnLogin;
    EditText Eusername;
    EditText Epassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        Eusername = findViewById(R.id.et_username);
        Epassword = findViewById(R.id.et_password);

        btnLogin.setOnClickListener(v -> {
            //simpan data username dan password ke cache
            getSharedPreferences("login", MODE_PRIVATE)
                    .edit()
                    .putString("username", Eusername.getText().toString())
                    .apply();
           Log.d("username", Eusername.getText().toString());
            startActivity(new Intent(ActivityLogin.this, MainActivity.class));

        });

    }
}