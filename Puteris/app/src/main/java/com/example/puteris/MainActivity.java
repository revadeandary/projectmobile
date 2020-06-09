package com.example.puteris;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PuterisAdapter puterisAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Puteris> puterises;
    private RequestQueue requestQueue;
    int jmldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_puteris);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        puterises = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "https://puteriindonesia.000webhostapp.com/connect.php";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        jmldata = response.length();
                        try {
                            for (int i = 0; i < jmldata; i++) {
                                JSONObject data = response.getJSONObject(i);
                                String gambarputeris = data.getString("gambar");
                                String namaputeris = data.getString("nama");
                                String deskripsiputeris = data.getString("deskripsi");
                                puterises.add(new Puteris(gambarputeris, namaputeris, deskripsiputeris));

                            }
                            puterisAdapter = new PuterisAdapter(MainActivity.this, puterises);
                            recyclerView.setAdapter(puterisAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
    });
        requestQueue.add(request);
    }
}
