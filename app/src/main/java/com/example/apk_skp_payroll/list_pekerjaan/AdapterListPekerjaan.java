package com.example.apk_skp_payroll.list_pekerjaan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apk_skp_payroll.R;

import java.util.List;

public class AdapterListPekerjaan extends RecyclerView.Adapter<AdapterListPekerjaan.ViewHolder>{
    List<ModelData> list;
    Context context;

    public AdapterListPekerjaan(List<ModelData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterListPekerjaan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.activity_list_pekerjaan, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListPekerjaan.ViewHolder holder, int position) {
        ModelData modelData = list.get( position );
        holder.nomor_antrian.setText( modelData.getNomorAntrian() );
        holder.nama_pelanggan.setText( modelData.getNamaPelanggan() );

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomor_antrian;
        TextView nama_pelanggan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomor_antrian = itemView.findViewById(R.id.tv_nomor_antrian);
            nama_pelanggan = itemView.findViewById(R.id.tv_nama_pelanggan);

        }
    }
}
