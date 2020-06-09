package com.example.puteris;

import java.util.List;

public class Puteris {
    private String gambar;
    private String nama;
    private String deskripsi;

    public Puteris(String datagambar, String datanama, String datadeskripsi){
        gambar = datagambar;
        nama = datanama;
        deskripsi = datadeskripsi;
    }
    public String getGambar() {
        return gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
