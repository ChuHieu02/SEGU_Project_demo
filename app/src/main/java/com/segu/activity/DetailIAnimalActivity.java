package com.segu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.segu.R;
import com.segu.data.DBQuerys;

public class DetailIAnimalActivity extends AppCompatActivity {
    Toolbar toolbar;
    private ImageView mImgDetail;
    private TextView mNameAnimal, mAgeAnimal, mSizeAnimal;
    private CheckBox cbDetailImageSlide;
    DBQuerys dbQuerys;


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

        if (intent.getStringExtra("favourite").equals("1")) {
            cbDetailImageSlide.setChecked(true);
        }

        cbDetailImageSlide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(DetailIAnimalActivity.this, ""+b, Toast.LENGTH_SHORT).show();
            }
        });
        Glide.with(this)
                .load(intent.getStringExtra("image"))
                .into(mImgDetail);


    }

    private void mapping() {
        dbQuerys = new DBQuerys(this);
        mImgDetail = findViewById(R.id.img_detail);
        mNameAnimal = findViewById(R.id.nameAnimal);
        mAgeAnimal = findViewById(R.id.ageAnimal);
        mSizeAnimal = findViewById(R.id.sizeAnimal);
        cbDetailImageSlide = findViewById(R.id.cb_detail_image_slide);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
