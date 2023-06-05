package com.example.apk_skp_payroll.list_pekerjaan;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apk_skp_payroll.APIservice;
import com.example.apk_skp_payroll.R;

import java.util.List;

import retrofit2.Call;

public class AdapterListPekerjaan extends RecyclerView.Adapter<AdapterListPekerjaan.ViewHolder>{
        List<ModelData> list;
    Context context;

    public AdapterListPekerjaan(List<ModelData> list, Context context) {
        System.out.println("AdapterListPekerjaan");
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterListPekerjaan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.card_list_pekerjaan, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListPekerjaan.ViewHolder holder, int position) {
        ModelData modelData = list.get( position );
        Log.e("TAG", "onBindViewHolder: " + modelData.getNomor_antrian() );
        holder.nomor_antrian.setText( "No Antrian : " + modelData.getNomor_antrian() );
        holder.nama_pelanggan.setText( "Nama Pelanggan : " + modelData.getNama_pelanggan() );

        if(modelData.getGet_jenis() != null) {
            GetJenis getJenis = modelData.getGet_jenis();
            holder.nama_servis.setText("Jenis Servis : " + getJenis.getNama_servis());


        } else {
            holder.nama_servis.setText("Jenis Servis : -");
        }

        if (modelData.getAntrian() != null){
            if (modelData.getAntrian().getStatus().equals("proses")){

                holder.btnSelesai.setVisibility(View.VISIBLE);


                holder.btnSelesai.setOnClickListener(view -> {
                 ListPekerjaanService listPekerjaanService;
                 listPekerjaanService = APIservice.getRetrofit().create(ListPekerjaanService.class);
                 ToSelesaiRequest toSelesaiRequest = new ToSelesaiRequest();
                 Call<ToSelesaiResponse> call = listPekerjaanService.putToSelesai(modelData.getAntrian().getId());
                    call.enqueue(new retrofit2.Callback<ToSelesaiResponse>() {
                        @Override
                        public void onResponse(Call<ToSelesaiResponse> call, retrofit2.Response<ToSelesaiResponse> response) {
                            if (response.isSuccessful()){
                                Toast.makeText(context, "Berhasil", Toast.LENGTH_SHORT).show();
                                holder.btnSelesai.setVisibility(View.GONE);
                            }
                        }

                        @Override
                        public void onFailure(Call<ToSelesaiResponse> call, Throwable t) {
                            Toast.makeText(context, "Gagal", Toast.LENGTH_SHORT).show();
                        }
                    });

                });

            }else{
                holder.btnSelesai.setVisibility(View.GONE);
            }
        }else{

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomor_antrian;
        TextView nama_pelanggan;
        TextView nama_servis;
        Button btnSelesai;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomor_antrian = itemView.findViewById(R.id.tv_nomor_antrian);
            nama_pelanggan = itemView.findViewById(R.id.tv_nama_pelanggan);
            nama_servis = itemView.findViewById(R.id.tv_servis);
            btnSelesai = itemView.findViewById(R.id.id_selesai);

        }
    }
}
