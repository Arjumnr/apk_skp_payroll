package com.example.apk_skp_payroll;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apk_skp_payroll.pekerjaan.AntrianResponse;
import com.example.apk_skp_payroll.pekerjaan.JenisResponse;
import com.example.apk_skp_payroll.pekerjaan.PekerjaanRequest;
import com.example.apk_skp_payroll.pekerjaan.PekerjaanResponse;
import com.example.apk_skp_payroll.pekerjaan.PekerjaanService;

import java.sql.Time;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityPekerjaan extends AppCompatActivity {

    EditText nama_pelanggan;
    Spinner spinner, spinner2;
    ImageView ic_back;
    Button btn_simpan;
    String jenis_id;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pekerjaan);

        progressDialog = new ProgressDialog(ActivityPekerjaan.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        nama_pelanggan = findViewById(R.id.nama_pelanggan);
        nama_pelanggan.setEnabled(false);
        spinner = findViewById(R.id.spinner);

        String user_id = getSharedPreferences("user", MODE_PRIVATE)
                .getString("id", null);

        if (user_id == null){
            Toast.makeText(this, "Silahkan login terlebih dahulu", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Log.e("user_id", user_id);
        }


        ic_back = findViewById(R.id.ic_back);
        ic_back.setOnClickListener(view -> {
            finish();
        });

        getAntrianKerja();

        getJenisService();

        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(view -> {
            if (spinner.getSelectedItem().toString().isEmpty() || spinner2.getSelectedItem().toString().isEmpty() || nama_pelanggan.getText().toString().isEmpty()){
                Toast.makeText(ActivityPekerjaan.this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else{
                doSimpan(user_id);
            }
        });





    }

    private void getAntrianKerja( ){

        PekerjaanService pekerjaanService = APIservice.getRetrofit().create(PekerjaanService.class);
        Call<AntrianResponse> callAntrianKerja = pekerjaanService.getAntrianKerja();
        callAntrianKerja.enqueue( new Callback<AntrianResponse>() {
            @Override
            public void onResponse(Call<AntrianResponse> call, Response<AntrianResponse> response) {

                if (response.isSuccessful()){
                    AntrianResponse antrianResponse = response.body();
                    String[] data = new String[antrianResponse.getData().size()];
                    for (int i = 0; i < antrianResponse.getData().size(); i++){
                        data[i] = antrianResponse.getData().get(i).getNomor();
                    }


                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityPekerjaan.this, android.R.layout.simple_spinner_item, data);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                    progressDialog.dismiss();

                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            nama_pelanggan.setText(antrianResponse.getData().get(i).getNama());

                        }



                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });



                }else {
                    progressDialog.dismiss();

                    System.out.println("error bosku");
                }
            }

            @Override
            public void onFailure(Call<AntrianResponse> call, Throwable t) {
                Log.d("response", "onFailure: " + t.getMessage());
                progressDialog.dismiss();
            }
        });
    }

    private void getJenisService(){

        spinner2 = findViewById(R.id.spinner2);
        PekerjaanService pekerjaanService = APIservice.getRetrofit().create(PekerjaanService.class);
        Call<JenisResponse> callJenisService = pekerjaanService.getJenisService();
        callJenisService.enqueue(new Callback<JenisResponse>() {
            @Override
            public void onResponse(Call<JenisResponse> call, Response<JenisResponse> response) {
                if (response.isSuccessful()) {
                    JenisResponse jenisResponse = response.body();
                    String[] data = new String[jenisResponse.getData().size()];
                    for (int i = 0; i < jenisResponse.getData().size(); i++) {
                        data[i] = jenisResponse.getData().get(i).getNama_servis();

                    }


                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityPekerjaan.this, android.R.layout.simple_spinner_item, data);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);

                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                             jenis_id = jenisResponse.getData().get(i).getId();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                            Log.e("error", "onNothingSelected: " );
                        }

                    });

            }

            }

            @Override
            public void onFailure(Call<JenisResponse> call, Throwable t) {
                Log.d("response", "onFailure: " + t.getMessage());
            }
        });
    }


    private void doSimpan(String user_id){
        ProgressDialog progressDialog = new ProgressDialog(ActivityPekerjaan.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        String nomor_antrian = spinner.getSelectedItem().toString();
        String nama_pelanggan = this.nama_pelanggan.getText().toString();
        jenis_id = this.jenis_id;
        Time w_mulai = new Time(System.currentTimeMillis());

        PekerjaanRequest pekerjaanRequest = new PekerjaanRequest(nomor_antrian, nama_pelanggan, w_mulai.toString(), "0", jenis_id, user_id);

        PekerjaanService pekerjaanService = APIservice.getRetrofit().create(PekerjaanService.class);

        Call<PekerjaanResponse> callPekerjaan = pekerjaanService.postPekerjaan(pekerjaanRequest);

        callPekerjaan.enqueue(new Callback<PekerjaanResponse>() {
            @Override
            public void onResponse(Call<PekerjaanResponse> call, retrofit2.Response<PekerjaanResponse> response) {

                if (response.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(ActivityPekerjaan.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    progressDialog.dismiss();
                    Toast.makeText(ActivityPekerjaan.this, "Data gagal disimpan", Toast.LENGTH_SHORT).show();
                    Log.e("error", "onResponse: " + response.message());
                }

            }

            @Override
            public void onFailure(Call<PekerjaanResponse> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("error", "onFailure: " + t.getMessage());
            }
        });
    }
}


