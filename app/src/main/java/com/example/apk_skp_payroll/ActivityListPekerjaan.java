package com.example.apk_skp_payroll;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apk_skp_payroll.list_pekerjaan.AdapterListPekerjaan;
import com.example.apk_skp_payroll.list_pekerjaan.Antrian;
import com.example.apk_skp_payroll.list_pekerjaan.GetJenis;
import com.example.apk_skp_payroll.list_pekerjaan.ListPekerjaanRequest;
import com.example.apk_skp_payroll.list_pekerjaan.ListPekerjaanResponse;
import com.example.apk_skp_payroll.list_pekerjaan.ListPekerjaanService;
import com.example.apk_skp_payroll.list_pekerjaan.ModelData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityListPekerjaan extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    AdapterListPekerjaan adapterListPekerjaan;
    String[] dataList;
    List<ModelData> list = new ArrayList<>();
    String user_id;
    Spinner spinner;

    ListPekerjaanRequest listPekerjaanRequest;
    ListPekerjaanResponse listPekerjaanResponse;
    Antrian antrian;
    GetJenis getJenis;
    ModelData modelData;
    ListPekerjaanService listPekerjaanService;

    ImageView icBack;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_pekerjaan);
        user_id = getSharedPreferences("user", MODE_PRIVATE)
                .getString("id", null);
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        icBack = findViewById(R.id.ic_back);
        spinner = findViewById(R.id.spinner);
        icBack.setOnClickListener(v -> {
             finish();
        });

        progressDialog = new ProgressDialog(ActivityListPekerjaan.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        getListPekerjaan(getApplicationContext());
        //jika tidak ada pekerjaan maka akan muncul text kosong
        if (list.isEmpty()) {
        //remove bg recycler view
            recyclerView.setBackgroundResource(0);
        }
    }

    private void getListPekerjaan(Context context) {
        adapterListPekerjaan = new AdapterListPekerjaan(list, context);
        recyclerView.setAdapter(adapterListPekerjaan);
        listPekerjaanService = APIservice.getRetrofit().create(ListPekerjaanService.class);
        listPekerjaanRequest = new ListPekerjaanRequest();
        //        parse user_id
        listPekerjaanRequest.setId(Long.parseLong(user_id));
        Call<ListPekerjaanResponse> call = listPekerjaanService.getListPekerjaan(listPekerjaanRequest.getId());
        Log.e("TAG", "getListPekerjaan: "+call.request().url() );
        call.enqueue(new Callback<ListPekerjaanResponse>() {
            @Override
            public void onResponse(Call<ListPekerjaanResponse> call, Response<ListPekerjaanResponse> response) {
                if (response.isSuccessful()){
                    listPekerjaanResponse = response.body();
                    if (listPekerjaanResponse.isStatus()){
                        progressDialog.dismiss();
                        list = listPekerjaanResponse.getData();

                        for (int i = 0; i < list.size(); i++) {
                            modelData = new ModelData();
                            Log.e("TAG", "onResponse: "+modelData.getNama_pelanggan() );

                            modelData.setNomor_antrian(modelData.getNomor_antrian());
                            modelData.setNama_pelanggan(modelData.getNama_pelanggan());
                            modelData.setGet_jenis(modelData.getGet_jenis());
                            modelData.setAntrian(modelData.getAntrian());
                            modelData.setAntrian(modelData.getAntrian());

                            adapterListPekerjaan = new AdapterListPekerjaan(list, context);
                            recyclerView.setAdapter(adapterListPekerjaan);
                        }

                    }else {
                        Log.e("TAG", "onResponse: "+listPekerjaanResponse.getMessage() );
                        progressDialog.dismiss();
                    }
                }else {
                    progressDialog.dismiss();
                    Log.e("TAG", "onResponse: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ListPekerjaanResponse> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("TAG", "onFailure: "+t.getMessage() );
            }
        });

    }
}