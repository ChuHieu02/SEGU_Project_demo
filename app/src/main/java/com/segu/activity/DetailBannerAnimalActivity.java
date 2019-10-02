package com.segu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.segu.R;
import com.segu.data.DBQuerys;
import com.segu.model.DetailAnimalBanner;

import org.json.JSONException;
import org.json.JSONObject;

public class DetailBannerAnimalActivity extends AppCompatActivity {
    Toolbar toolbar;
    private ImageView ImgDetailBannerAnimal;
    private TextView tvNameDetailBannerAnimal;
    private TextView tvSpeciesDetailBannerAnimal;
    private TextView tvSizeDetailBannerAnimal;
    private CheckBox cbDetailImageSlide;
    DBQuerys dbQuerys;
    private String animalID;
    private DetailAnimalBanner detailAnimalBanner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ianimal);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle(getResources().getString(R.string.detail_image));
        mapping();
        checkAnimalID();
        addDataDetailBannerAnimal();
//        mNameAnimal.setText(intent.getStringExtra("name"));
//        mAgeAnimal.setText(intent.getStringExtra("age"));
//        mSizeAnimal.setText(intent.getStringExtra("size"));
//
//
//        Glide.with(this)
//                .load(intent.getStringExtra("image"))
//                .into(mImgDetail);


    }

    private void checkAnimalID() {
        Intent intent = getIntent();
        if (intent.getStringExtra("id").equals("1")) {
            animalID = "83";
        } else if (intent.getStringExtra("id").equals("2")) {
            animalID = "84";
        } else if (intent.getStringExtra("id").equals("3")) {
            animalID = "77";
        } else if (intent.getStringExtra("id").equals("4")) {
            animalID = "76";
        } else if (intent.getStringExtra("id").equals("5")) {
            animalID = "80";
        } else if (intent.getStringExtra("id").equals("6")) {
            animalID = "81";
        } else if (intent.getStringExtra("id").equals("7")) {
            animalID = "78";
        } else if (intent.getStringExtra("id").equals("8")) {
            animalID = "79";
        } else if (intent.getStringExtra("id").equals("9")) {
            animalID = "82";
        } else if (intent.getStringExtra("id").equals("10")) {
            animalID = "85";
        }
    }

    private void addDataDetailBannerAnimal() {
        String queryUrl = "http://git.segu.vn:89/snippets/" + animalID + "/raw";
        RequestQueue requestQueue = Volley.newRequestQueue((Activity) this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, queryUrl,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            tvNameDetailBannerAnimal.setText(jsonObject.getString("name"));
                            tvSizeDetailBannerAnimal.setText(jsonObject.getString("size"));
                            tvSpeciesDetailBannerAnimal.setText(jsonObject.getString("species"));
                            Glide.with(getApplicationContext())
                                    .load(jsonObject.getString("img_url"))
                                    .placeholder(R.drawable.loading_image)
                                    .error(R.drawable.img_err)
                                    .into(ImgDetailBannerAnimal);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Lỗi xảy ra", Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(stringRequest);

    }

    private void mapping() {
        dbQuerys = new DBQuerys(this);
        ImgDetailBannerAnimal = (ImageView) findViewById(R.id.img_detail_banner_animal);
        tvNameDetailBannerAnimal = (TextView) findViewById(R.id.tv_name_detail_banner_Animal);
        tvSpeciesDetailBannerAnimal = (TextView) findViewById(R.id.tv_species_detail_banner_Animal);
        tvSizeDetailBannerAnimal = (TextView) findViewById(R.id.tv_size_detail_banner_Animal);
        cbDetailImageSlide = findViewById(R.id.cb_detail_image_slide);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
