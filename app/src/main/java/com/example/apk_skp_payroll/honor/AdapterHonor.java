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

    public void setData(List<ModelDataHonor> dataList) {
//        modelDataList = dataList;
//        notifyDataSetChanged();

        if (dataList == null || dataList.isEmpty()) {
            modelDataList = null;
        } else {
            modelDataList = dataList;
        }
        notifyDataSetChanged();
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

        if (modelDataHonor.getPenjualan() == null) {
            holder.tvJenis.setText("Jenis : Servis");
            holder.tvNamaPelanggan.setText("Pelanggan : " + modelDataHonor.getServis().getNama_pelanggan());
            holder.tvNamaBarang.setText("");
            holder.tvHargaBarang.setText("");
            holder.tvCreated_at.setText(modelDataHonor.getServis().getCreated_at());
            holder.tvHonor.setText("Honor : " + modelDataHonor.getHonor());
        } else {
            holder.tvJenis.setText("Jenis : Penjualan");
            holder.tvNamaPelanggan.setText("Pelanggan : " + modelDataHonor.getPenjualan().getNama_pelanggan());
            holder.tvCreated_at.setText(modelDataHonor.getPenjualan().getCreated_at());
            holder.tvHonor.setText("Honor : " + modelDataHonor.getHonor());

            // Jika ada barang dalam penjualan, Anda dapat mengatur data barang yang sesuai
            StringBuilder namaBarang = new StringBuilder();
            StringBuilder hargaBarang = new StringBuilder();
            StringBuilder cretaed_at = new StringBuilder();
            StringBuilder honor = new StringBuilder();
            for (int i = 0; i < modelDataHonor.getBarang().size(); i++) {
                namaBarang.append("Nama Barang : ").append(modelDataHonor.getBarang().get(i).getNama_barang()).append("\n");
                hargaBarang.append("Harga Barang : ").append(modelDataHonor.getBarang().get(i).getHarga()).append("\n");
                cretaed_at.append(modelDataHonor.getCreated_at()).append("\n");
                honor.append(modelDataHonor.getHonor()).append("\n");
            }

            holder.tvNamaBarang.setText(namaBarang.toString());
            holder.tvHargaBarang.setText(hargaBarang.toString());
            holder.tvCreated_at.setText(cretaed_at.toString());
            holder.tvHonor.setText("Honor : " + modelDataHonor.getHonor());
        }
//        if (modelDataHonor.getPenjualan() == null){
//            holder.tvJenis.setText( "Jenis : Servis"  );
//            holder.tvNamaPelanggan.setText( "Nama Pelanggan : " + modelDataHonor.getServis().getNama_pelanggan() );
//            holder.tvNamaBarang.setText("" );
//            holder.tvHargaBarang.setText( "");
//        } else {
//            //add nama barang
//
//            holder.tvJenis.setText( "Jenis : Penjualan"  );
//            holder.tvNamaPelanggan.setText( "Nama Pelanggan : " + modelDataHonor.getPenjualan().getNama_pelanggan() );
//            for (int i = 0; i < modelDataHonor.getBarang().size(); i++) {
//                holder.tvNamaBarang.setText( "Nama Barang : " + modelDataHonor.getBarang().get(i).getNama_barang() );
//                holder.tvHargaBarang.setText( "Harga Barang : " + modelDataHonor.getBarang().get(i).getHarga() );
//            }
//        }




    }

    @Override
    public int getItemCount() {
        return modelDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJenis, tvNamaPelanggan, tvNamaBarang, tvHargaBarang, tvHonor, tvCreated_at;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJenis = itemView.findViewById( R.id.id_jenis );
            tvNamaPelanggan = itemView.findViewById( R.id.id_nama_pelanggan );
            tvNamaBarang = itemView.findViewById( R.id.id_nama_barang );
            tvHargaBarang = itemView.findViewById( R.id.id_harga_barang );
            tvCreated_at = itemView.findViewById( R.id.id_created_at );
            tvHonor = itemView.findViewById( R.id.id_honor );

        }
    }
}
