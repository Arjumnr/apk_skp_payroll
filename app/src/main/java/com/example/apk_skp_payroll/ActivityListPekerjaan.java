package com.example.apk_skp_payroll;

import android.content.Context;
import android.os.Bundle;

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

    ListPekerjaanRequest listPekerjaanRequest;
    ListPekerjaanResponse listPekerjaanResponse;
    Antrian antrian;
    GetJenis getJenis;
    ModelData modelData;
    ListPekerjaanService listPekerjaanService;
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


        getListPekerjaan(getApplicationContext());

    }

    private void getListPekerjaan(Context context) {
        adapterListPekerjaan = new AdapterListPekerjaan(list, context);
        recyclerView.setAdapter(adapterListPekerjaan);
        listPekerjaanService = APIservice.getRetrofit().create(ListPekerjaanService.class);
        listPekerjaanRequest = new ListPekerjaanRequest();
        //parse user_id
//        user_id = listPekerjaanRequest.setId(Long.parseLong(user_id));
        Call<ListPekerjaanResponse> call = listPekerjaanService.getListPekerjaan(Long.parseLong(user_id));
        call.enqueue(new Callback<ListPekerjaanResponse>() {
            @Override
            public void onResponse(Call<ListPekerjaanResponse> call, Response<ListPekerjaanResponse> response) {
                System.out.println("Data : "+response.body());
                if (response.isSuccessful()){
                    listPekerjaanResponse = response.body();
                    System.out.println("Data : "+listPekerjaanResponse.isStatus());
//                    if (listPekerjaanResponse.isStatus()){
//                        System.out.println("Data : "+listPekerjaanResponse.getData());
////                        for (int i = 0; i < listPekerjaanResponse.getData().size(); i++) {
////                            antrian = listPekerjaanResponse.getData().get(i).getAntrian();
////                            getJenis = listPekerjaanResponse.getData().get(i).getGetJenis();
////                            modelData = new ModelData();
////                            modelData.setNama_pelanggan(listPekerjaanResponse.getData().get(i).getNama_pelanggan());
////                            modelData.setNama_jenis_pekerjaan(getJenis.getNama_jenis_pekerjaan());
////                            modelData.setNomor_antrian(antrian.getNomor_antrian());
////                            modelData.setWaktu_mulai(listPekerjaanResponse.getData().get(i).getWaktu_mulai());
////                            modelData.setWaktu_selesai(listPekerjaanResponse.getData().get(i).getWaktu_selesai());
////                            modelData.setTotal_harga(listPekerjaanResponse.getData().get(i).getTotal_harga());
////                            modelData.setKeterangan(listPekerjaanResponse.getData().get(i).getKeterangan());
////                            list.add(modelData);
////                        }
//
//                    }
                }
            }

            @Override
            public void onFailure(Call<ListPekerjaanResponse> call, Throwable t) {
                System.out.println("Error : "+t.getMessage());
            }
        });
    }




}