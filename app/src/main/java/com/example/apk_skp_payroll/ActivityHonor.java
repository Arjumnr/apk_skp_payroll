package com.example.apk_skp_payroll;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apk_skp_payroll.honor.AdapterHonor;
import com.example.apk_skp_payroll.honor.HonorRequest;
import com.example.apk_skp_payroll.honor.HonorResponse;
import com.example.apk_skp_payroll.honor.HonorService;
import com.example.apk_skp_payroll.honor.ModelDataHonor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityHonor extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    AdapterHonor adapterHonor;
    List<ModelDataHonor> modelDataList = new ArrayList<>();
    String user_id;
    ModelDataHonor modelDataHonor = new ModelDataHonor();

    HonorRequest honorRequest;
    HonorResponse honorResponse;
    HonorService honorService;

    ImageView icBack;
    ProgressDialog progressDialog;

    TextView total_servis, total_honor, total_penjualan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honor);

        user_id = getSharedPreferences("user", MODE_PRIVATE)
                .getString("id", null);

        recyclerView = findViewById(R.id.id_recycle_honor);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        icBack = findViewById(R.id.ic_back);
        total_servis = findViewById(R.id.id_total_servis);
        total_honor = findViewById(R.id.id_total_gaji);
        total_penjualan = findViewById(R.id.id_total_penjualan);

        icBack.setOnClickListener(v -> {
            finish();
        });

        progressDialog = new ProgressDialog(ActivityHonor.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        getHonor(getApplicationContext());





    }

    private void getHonor(Context context){
        adapterHonor = new AdapterHonor(modelDataList, context);
        recyclerView.setAdapter(adapterHonor);
        honorService = APIservice.getRetrofit().create(HonorService.class);

        honorRequest = new HonorRequest();
        honorRequest.setId(Long.parseLong(user_id));

        Call<HonorResponse> call = honorService.getHonor(honorRequest.getId());
        //cek url
        Log.e("TAG", "getHonor: "+call.request().url() );
        call.enqueue(new Callback<HonorResponse>() {
            @Override
            public void onResponse(Call<HonorResponse> call, Response<HonorResponse> response) {
                if (response.isSuccessful()){
                   honorResponse = response.body();
                   if (honorResponse.isStatus()){
                       modelDataList = honorResponse.getData();
                       adapterHonor = new AdapterHonor(modelDataList, context);
                       Log.e("TAG", "modelDataList: "+modelDataList.size());
                       if (modelDataList.size() > 0){
                           for (int i = 0; i < modelDataList.size(); i++){
                               Log.e("TAG", "modelDataList: "+modelDataList.get(i).getPenjualan());
                               Log.e("TAG", "modelDataList: "+modelDataList.get(i).getUser_id());
                               modelDataHonor.setUser_id(modelDataList.get(i).getUser_id());
                               modelDataHonor.setPenjualan(modelDataList.get(i).getPenjualan());
                               modelDataHonor.setServis(modelDataList.get(i).getServis());
                               modelDataHonor.setTotal_servis(modelDataList.get(i).getTotal_servis());
                               modelDataHonor.setTotal_penjualan(modelDataList.get(i).getTotal_penjualan());
                               modelDataHonor.setTotal_honor(modelDataList.get(i).getTotal_honor());
                               adapterHonor = new AdapterHonor(modelDataList, context);
                               recyclerView.setAdapter(adapterHonor);
                           }
                       }else {
                           modelDataHonor.setTotal_honor(0);
                            modelDataHonor.setTotal_penjualan(0);
                            modelDataHonor.setTotal_servis(0);
                       }
                   }



                       if (modelDataHonor.getTotal_servis() == null){
                           modelDataHonor.setTotal_servis(0);
                       }

                       if (modelDataHonor.getTotal_penjualan() == null){
                           modelDataHonor.setTotal_penjualan(0);
                       }

                       if (modelDataHonor.getTotal_honor() == null){
                            modelDataHonor.setTotal_honor(0);
                       }

                       total_servis.setText("Total Servis : " + String.valueOf(modelDataHonor.getTotal_servis()));
                       total_penjualan.setText("Total Penjualan : " + String.valueOf(modelDataHonor.getTotal_penjualan()));
                       total_honor.setText("Total Honor : " + String.valueOf(modelDataHonor.getTotal_honor()));


                    progressDialog.dismiss();
                }else{
                    Log.e("TAG", "responseMessage: "+response.message());
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<HonorResponse> call, Throwable t) {
                Log.e("TAG", "onFailure: "+t.getMessage());
                progressDialog.dismiss();
            }
        }
        );


    }
}