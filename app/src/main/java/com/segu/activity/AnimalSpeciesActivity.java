package com.segu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.segu.R;

public class AnimalSpeciesActivity extends AppCompatActivity {
    private RecyclerView rcListDetailAnimalSpecies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_animal_species);
        mapping();

    }

    private void mapping() {
        rcListDetailAnimalSpecies = (RecyclerView) findViewById(R.id.rc_list_detail_animalSpecies);

    }
}
