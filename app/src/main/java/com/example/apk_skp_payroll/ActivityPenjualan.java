package com.example.apk_skp_payroll;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apk_skp_payroll.penjualan.BarangResponse;
import com.example.apk_skp_payroll.penjualan.PenjualanRequest;
import com.example.apk_skp_payroll.penjualan.PenjualanResponse;
import com.example.apk_skp_payroll.penjualan.PenjualanService;

import retrofit2.Call;
import retrofit2.Callback;

public class ActivityPenjualan extends AppCompatActivity {
    EditText etNamaPelanggan;
//    EditText etNamaBarang;
    EditText etDeskripsi;
    Button btnSimpan;
    TextView tes;
    ImageView ic_back;
    Spinner spinnerBarang;
    String barang_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjualan);

        etNamaPelanggan = findViewById(R.id.nama_pelanggan);
//        etNamaBarang = findViewById(R.id.nama_barang);
        etDeskripsi = findViewById(R.id.deskripsi);
        btnSimpan = findViewById(R.id.btn_simpan);
        ic_back = findViewById(R.id.ic_back);
        spinnerBarang = findViewById(R.id.spinner_barang);


        String user_id = getSharedPreferences("user", MODE_PRIVATE)
                .getString("id", null);


        ic_back.setOnClickListener(view -> {
            finish();
        });

        getDataBarang();

        btnSimpan.setOnClickListener(view -> {
            if (etNamaPelanggan.getText().toString().isEmpty()  || etDeskripsi.getText().toString().isEmpty()) {
                Toast.makeText(ActivityPenjualan.this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else{
                doSimpan(user_id);
            }
//
        });

    }

    private void getDataBarang(){
        PenjualanService penjualanService = APIservice.getRetrofit().create(PenjualanService.class);
        Call<BarangResponse> call = penjualanService.getDataBarang();
        call.enqueue(new Callback<BarangResponse>() {
            @Override
            public void onResponse(Call<BarangResponse> call, retrofit2.Response<BarangResponse> response) {
                BarangResponse barangResponse = response.body();
                String[] namaBarang = new String[barangResponse.getData().size()];
                for (int i = 0; i < barangResponse.getData().size(); i++) {
                    namaBarang[i] = barangResponse.getData().get(i).getNama_barang();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityPenjualan.this, android.R.layout.simple_spinner_item, namaBarang);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerBarang.setAdapter(adapter);

                spinnerBarang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                            barang_id = barangResponse.getData().get(position).getId();
                            Log.e("barang_id", "onItemSelected: "+barang_id );
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        Log.e("error", "onNothingSelected: " );
                    }
                });

            }

            @Override
            public void onFailure(Call<BarangResponse> call, Throwable t) {
                Toast.makeText(ActivityPenjualan.this, "Data gagal disimpan", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void doSimpan(String user_id){
        String namaPelanggan = etNamaPelanggan.getText().toString();
            String idbarang = barang_id;
            String deskripsi = etDeskripsi.getText().toString();
        if(user_id != null) {
            Log.e("user_id", "ada user_id");
        }else{
            Log.e("user_id", "user_id null");
        }


        PenjualanRequest penjualanRequest = new PenjualanRequest( namaPelanggan, idbarang, deskripsi, user_id);

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