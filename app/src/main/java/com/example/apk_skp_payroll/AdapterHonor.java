package com.example.apk_skp_payroll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterHonor extends RecyclerView.Adapter<AdapterHonor.ViewHolder>{
    private List<String> honors;

    public AdapterHonor(List<String> honors) {
        this.honors = honors;
    }
    @NonNull
    @Override
    public AdapterHonor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_honor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHonor.ViewHolder holder, int position) {
        String honor = honors.get(position);
        holder.nama.setText(honor);


    }

    @Override
    public int getItemCount() {
        return honors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
        }
    }
}
