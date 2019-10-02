package com.segu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.segu.R;
import com.segu.adapter.DetailAnimalSpeciesAdapter;
import com.segu.model.AnimalSpecies;
import com.segu.model.AnimalSpeciesDetail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetailAnimalSpeciesActivity extends AppCompatActivity {
    private RecyclerView rcListDetailAnimalSpecies;
    private List<AnimalSpeciesDetail> animalSpeciesList;
    private String speciesID = "73";
    private DetailAnimalSpeciesAdapter detailAnimalSpeciesAdapter;
    private SwipeRefreshLayout swipeDetailAnimalSpecies;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_animal_species);

        animalSpeciesList = new ArrayList<>();
        Intent intent = getIntent();
        mapping();
        if (intent.getStringExtra("id").equals("1")) {
            speciesID = "72";
        }else if (intent.getStringExtra("id").equals("2")){
            speciesID = "73";
        }
        else if (intent.getStringExtra("id").equals("3")){
            speciesID = "75";
        }
        else if (intent.getStringExtra("id").equals("4")){
            speciesID = "74";
        }
        addDataAnimalSpecies();

        swipeDetailAnimalSpecies.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                detailAnimalSpeciesAdapter.delete();
                rcListDetailAnimalSpecies.removeAllViewsInLayout();
                addDataAnimalSpecies();

            }
        });



    }

    private void addDataAnimalSpecies() {

        String queryUrl = "http://git.segu.vn:89/snippets/" + speciesID + "/raw";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, queryUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray jsonArrayList = new JSONArray(response);
                            for (int i = 0; i < jsonArrayList.length(); i++) {
                                JSONObject jsonObjectList = jsonArrayList.getJSONObject(i);
                                String name = jsonObjectList.getString("name");
                                String size = jsonObjectList.getString("size");
                                String img_url = jsonObjectList.getString("img_url");
                                // Toast.makeText(DetailAnimalSpeciesActivity.this, ""+jsonArrayList.toString(), Toast.LENGTH_SHORT).show();

                                animalSpeciesList.add(new AnimalSpeciesDetail(name, size, img_url));


                            }
                            detailAnimalSpeciesAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        swipeDetailAnimalSpecies.setRefreshing(false);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        swipeDetailAnimalSpecies.setRefreshing(false);
                        Toast.makeText(getParent(), "Error No Data", Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(stringRequest);


    }

    private void mapping() {
        swipeDetailAnimalSpecies = (SwipeRefreshLayout) findViewById(R.id.swipe_detail_animal_species);
        rcListDetailAnimalSpecies = findViewById(R.id.rc_list_detail_animalSpecies);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcListDetailAnimalSpecies.setLayoutManager(linearLayoutManager);

        detailAnimalSpeciesAdapter = new DetailAnimalSpeciesAdapter(this, animalSpeciesList);
        rcListDetailAnimalSpecies.setAdapter(detailAnimalSpeciesAdapter);


    }
}
