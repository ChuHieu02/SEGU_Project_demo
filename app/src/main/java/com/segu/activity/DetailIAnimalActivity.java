package com.segu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.segu.R;

public class DetailIAnimalActivity extends AppCompatActivity {
    Toolbar toolbar;
    private ImageView mImgDetail;
    private TextView mNameAnimal;
    private TextView mAgeAnimal;
    private TextView mSizeAnimal;


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

        Intent intent = getIntent();
        mNameAnimal.setText(intent.getStringExtra("name"));
        mAgeAnimal.setText(intent.getStringExtra("age"));
        mSizeAnimal.setText(intent.getStringExtra("size"));
        Glide.with(this)
                .load(intent.getStringExtra("image"))
                .into(mImgDetail);

    }

    private void mapping() {
        mImgDetail = findViewById(R.id.img_detail);
        mNameAnimal = findViewById(R.id.nameAnimal);
        mAgeAnimal = findViewById(R.id.ageAnimal);
        mSizeAnimal = findViewById(R.id.sizeAnimal);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
