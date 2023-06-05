package com.example.apk_skp_payroll.honor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apk_skp_payroll.R;

import java.util.List;

public class AdapterHonor extends RecyclerView.Adapter<AdapterHonor.ViewHolder> {
    private List<ModelDataHonor> modelDataList;
    private Context context;


    public AdapterHonor(List<ModelDataHonor> modelDataList, Context context) {
        this.modelDataList = modelDataList;
        this.context = context;
    }


    @NonNull
    @Override
    public AdapterHonor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.card_honor, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHonor.ViewHolder holder, int position) {
        ModelDataHonor modelDataHonor = modelDataList.get( position );


        if (modelDataHonor.getPenjualan() == null){
            holder.tvJenis.setText( "Jenis : Servis"  );
            holder.tvNamaPelanggan.setText( "Nama Pelanggan : " + modelDataHonor.getServis().getNama_pelanggan() );
        } else {
            holder.tvJenis.setText( "Jenis : Penjualan"  );
            holder.tvNamaPelanggan.setText( "Nama Pelanggan : " + modelDataHonor.getPenjualan().getNama_pelanggan() );
        }




    }

    @Override
    public int getItemCount() {
        return modelDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJenis, tvNamaPelanggan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJenis = itemView.findViewById( R.id.id_jenis );
            tvNamaPelanggan = itemView.findViewById( R.id.id_nama_pelanggan );

        }
    }
}
