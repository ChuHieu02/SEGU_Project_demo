package com.segu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
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
    private List<AnimalSpeciesDetail> animalSpeciesList ;
    private String speciesID = "73";
    private DetailAnimalSpeciesAdapter detailAnimalSpeciesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_animal_species);
        animalSpeciesList = new ArrayList<>();
        mapping();
        addDataAnimalSpecies();


    }

    private void addDataAnimalSpecies() {



//        String queryUrl = "http://git.segu.vn:89/snippets/73/raw";
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, queryUrl,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//
//                            JSONArray jsonArrayList = jsonObject.getJSONArray(response);
//                            for (int i = 0; i < jsonArrayList.length(); i++) {
//                                JSONObject jsonObjectList = jsonArrayList.getJSONObject(i);
//                                String name = jsonObjectList.getString("name");
//                                String size = jsonObjectList.getString("size");
//                                String img_url = jsonObjectList.getString("img_url");
//                                Toast.makeText(DetailAnimalSpeciesActivity.this, ""+jsonArrayList.toString(), Toast.LENGTH_SHORT).show();
//
//                                animalSpeciesList.add(new AnimalSpeciesDetail(name , size , img_url));
//
//
//                            }
//                            detailAnimalSpeciesAdapter.notifyDataSetChanged();
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getParent(), "Error No Data", Toast.LENGTH_SHORT).show();
//                    }
//                });
//        requestQueue.add(stringRequest);


    }

            private void mapping() {
                rcListDetailAnimalSpecies =findViewById(R.id.rc_list_detail_animalSpecies);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                rcListDetailAnimalSpecies.setLayoutManager(linearLayoutManager);

                detailAnimalSpeciesAdapter = new DetailAnimalSpeciesAdapter(this,animalSpeciesList);
                rcListDetailAnimalSpecies.setAdapter(detailAnimalSpeciesAdapter);


            }
        }
