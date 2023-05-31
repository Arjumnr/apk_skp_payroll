package com.example.apk_skp_payroll;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apk_skp_payroll.penjualan.PenjualanRequest;
import com.example.apk_skp_payroll.penjualan.PenjualanResponse;
import com.example.apk_skp_payroll.penjualan.PenjualanService;

import retrofit2.Call;
import retrofit2.Callback;

public class ActivityPenjualan extends AppCompatActivity {
    EditText etNamaPelanggan;
    EditText etNamaBarang;
    EditText etDeskripsi;
    Button btnSimpan;
    TextView tes;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjualan);

        etNamaPelanggan = findViewById(R.id.nama_pelanggan);
        etNamaBarang = findViewById(R.id.nama_barang);
        etDeskripsi = findViewById(R.id.deskripsi);
        btnSimpan = findViewById(R.id.btn_simpan);


        String user_id = getSharedPreferences("user", MODE_PRIVATE)
                .getString("id", null);


        btnSimpan.setOnClickListener(view -> {
            if (etNamaPelanggan.getText().toString().isEmpty() || etNamaBarang.getText().toString().isEmpty() || etDeskripsi.getText().toString().isEmpty()) {
                Toast.makeText(ActivityPenjualan.this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else{
                doSimpan(user_id);
            }
//
        });

    }

    public void doSimpan(String user_id){
        String namaPelanggan = etNamaPelanggan.getText().toString();
            String namaBarang = etNamaBarang.getText().toString();
            String deskripsi = etDeskripsi.getText().toString();
        if(user_id != null) {
            Log.e("user_id", "ada user_id");
        }else{
            Log.e("user_id", "user_id null");
        }


        PenjualanRequest penjualanRequest = new PenjualanRequest( namaPelanggan, namaBarang, deskripsi, user_id);

        PenjualanService penjualanService = APIservice.getRetrofit().create(PenjualanService.class);

        Call<PenjualanResponse> call = penjualanService.postData(penjualanRequest);

        call.enqueue(new Callback<PenjualanResponse>() {
            @Override
            public void onResponse(Call<PenjualanResponse> call, retrofit2.Response<PenjualanResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ActivityPenjualan.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ActivityPenjualan.this, "Data gagal disimpan", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<PenjualanResponse> call, Throwable t) {
                Toast.makeText(ActivityPenjualan.this, "Data gagal disimpan", Toast.LENGTH_SHORT).show();
            }
        });



    }
}