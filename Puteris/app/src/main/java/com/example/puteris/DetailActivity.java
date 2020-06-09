package com.example.puteris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String nama = "nama";
    public static final String deskripsi = "deskripsi";
    public static final String gambar = "null";
    public ImageView imgdata;
    public TextView tvnama;
    public TextView tvdes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvnama= findViewById(R.id.tv_nama);
        tvnama=findViewById(R.id.tv_des);
        imgdata =findViewById(R.id.img_puteri);

        String simpannama = getIntent().getStringExtra(nama);
        String simpandeskripsi = getIntent().getStringExtra(deskripsi);
        String simpangambar = getIntent().getStringExtra(gambar);

        tvnama.setText(simpannama);
        tvdes.setText(simpandeskripsi);
        Glide
                .with(this)
                .load(simpangambar)
                .centerCrop()
                .into(imgdata)
    }
}
