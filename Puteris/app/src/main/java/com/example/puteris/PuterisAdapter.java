package com.example.puteris;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PuterisAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Puteris> puterises;

    public PuterisAdapter(Context mcontext, ArrayList<Puteris> puterises){
        context=mcontext;
        puterises = puterises;
    }

    @NonNull
    @Override
    public PuterisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_puteris,parent, false);
        return new PuterisViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PuterisViewHolder holder, int position) {
        Puteris puterisbaru = puterises.get(position);
        String gambar = puterisbaru.getGambar();
        String nama = puterisbaru.getNama();
        String deskripsi = puterisbaru.getDeskripsi();

        holder.tvnamadata.setText(nama);
        holder.tvdeskripsidata.setText(deskripsi);
        Glide
                .with(context)
                .load(gambar)
                .centerCrop()
                .into(holder.imgdata);

    }

    @Override
    public int getItemCount() {
        return puterises.size();
    }

    public class PuterisViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgdata;
        public TextView tvnamadata;
        public TextView tvdeskripsidata;

        public  PuterisViewHolder(@NonNull View itemView){
            super(itemView);
            imgdata = itemView.findViewById(R.id.img_puteris);
            tvnamadata = itemView.findViewById(R.id.tv_nama);
            tvdeskripsidata = itemView.findViewById(R.id.tv_des);
        }

    }
}
