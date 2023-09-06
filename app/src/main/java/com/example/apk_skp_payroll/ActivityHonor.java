package com.example.apk_skp_payroll;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apk_skp_payroll.honor.AdapterHonor;
import com.example.apk_skp_payroll.honor.HonorRequest;
import com.example.apk_skp_payroll.honor.HonorResponse;
import com.example.apk_skp_payroll.honor.HonorService;
import com.example.apk_skp_payroll.honor.ModelDataHonor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    String[] months = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    Spinner spinner;

    HonorRequest honorRequest;
    HonorResponse honorResponse;
    HonorService honorService;

    ImageView icBack;
    ProgressDialog progressDialog;

    TextView total_servis, total_honor, total_penjualan, tanggal;
    String tanggal_sekarang;

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
        tanggal = findViewById(R.id.id_tanggal);
        spinner = findViewById(R.id.spinner_bulan);

        spinner = findViewById(R.id.spinner_bulan);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, months);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

       String tanggal_sekarang = getCurrentDate();
       tanggal.setText(tanggal_sekarang);


        icBack.setOnClickListener(v -> {
            finish();
        });

        progressDialog = new ProgressDialog(ActivityHonor.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        getHonor(getApplicationContext());
        spinner.setSelection(getCurrentMonthPosition());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedMonth = (String) parentView.getItemAtPosition(position);
                // Panggil metode untuk memfilter dan memperbarui data berdasarkan bulan yang dipilih
                updateHonorData(selectedMonth);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                updateHonorData(bulanSekarang());


            }
        });


    }

    public String getCurrentDate(){
        final Calendar c = Calendar.getInstance();
        int year, month, day;
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DATE);
        return day + "/" + (month+1) + "/" + year;
    }

    public String bulanSekarang(){
        //kembalian nilainya itu januari dll
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM"); // 'MMMM' menghasilkan nama bulan dalam bahasa Inggris
        String monthName = monthFormat.format(calendar.getTime());
        System.out.println("Bulan saat ini: " + monthName);
        return monthName;
    }

    private int getCurrentMonthPosition() {
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH);
        return currentMonth;
    }

    private void getHonor(Context context){
        adapterHonor = new AdapterHonor(modelDataList, context);
        recyclerView.setAdapter(adapterHonor);
        honorService = APIservice.getRetrofit().create(HonorService.class);

        honorRequest = new HonorRequest();
        honorRequest.setId(Long.parseLong(user_id));
        //spinner bulan
        //jika spinner kosong kirim null
        if (spinner.getSelectedItemPosition() == 0){
            honorRequest.setBulan(bulanSekarang());
        }
        honorRequest.setBulan(spinner.getSelectedItem().toString());

        Call<HonorResponse> call = honorService.getHonor(honorRequest.getId(), honorRequest.getBulan());
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
                       Log.e("inimi", "modelDataList: "+modelDataList.size());
                       System.out.println("modelDataList: "+modelDataList.size());
                       if (modelDataList.size() > 0){
                           for (int i = 0; i < modelDataList.size(); i++){
                               System.out.println("modelDataList: ");
                               modelDataHonor.setUser_id(modelDataList.get(i).getUser_id());
                               modelDataHonor.setPenjualan(modelDataList.get(i).getPenjualan());
                               modelDataHonor.setServis(modelDataList.get(i).getServis());
                               modelDataHonor.setBarang(modelDataList.get(i).getBarang());
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
                            //jngan tampilkan perulangan kosong
                           adapterHonor = new AdapterHonor(modelDataList, context);
                           recyclerView.setAdapter(adapterHonor);
                           recyclerView.setBackgroundResource(0);


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

    private void updateHonorData(String selectedMonth) {
        progressDialog.show(); // Menampilkan progress dialog saat memuat ulang data

        // Mengganti bulan yang dipilih dalam objek honorRequest

            honorRequest.setBulan(selectedMonth);

//        adapterHonor.setData(null);
        // Memanggil kembali metode getHonor dengan bulan yang baru
        getHonor(getApplicationContext());
    }
}