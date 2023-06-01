package com.example.apk_skp_payroll;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apk_skp_payroll.login.LoginResponse;
import com.example.apk_skp_payroll.login.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityLogin extends AppCompatActivity {
    Button btnLogin;
    EditText Username;
    EditText Password;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        Username = findViewById(R.id.et_username);
        Password = findViewById(R.id.et_password);


        btnLogin.setOnClickListener(v -> {

            if (Username.getText().toString().isEmpty() || Password.getText().toString().isEmpty()) {
                Toast.makeText(ActivityLogin.this, "Username/Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else{
                progressDialog = new ProgressDialog(ActivityLogin.this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                login();

            }
        });

    }

    public void login(){

        String username = Username.getText().toString();
        String password = Password.getText().toString();

        UserService userService = APIservice.getRetrofit().create(UserService.class);
        Call<LoginResponse> call = userService.login(username, password);



        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {

                if (response.isSuccessful()) {
                    // Login successful
                    LoginResponse loginResponse = response.body();

                    new Handler().postDelayed(() -> {
                            if (loginResponse.isStatus() == true) {
                                System.out.println("loginResponse: " + loginResponse.getData().getName());

                                // simpan data id
                                getSharedPreferences("user", MODE_PRIVATE)
                                        .edit()
                                        .putString("id", String.valueOf(loginResponse.getData().getId()))
                                        .putString("name", loginResponse.getData().getName())
                                        .apply();
                                progressDialog.dismiss();
                                startActivity(new Intent(ActivityLogin.this, MainActivity.class));
                                finish();
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(ActivityLogin.this, "Username/Password salah", Toast.LENGTH_SHORT).show();
                            }
                    }, 1000);
                }else {
                    progressDialog.dismiss();
                    Toast.makeText(ActivityLogin.this, "Username/Password salah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ActivityLogin.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}