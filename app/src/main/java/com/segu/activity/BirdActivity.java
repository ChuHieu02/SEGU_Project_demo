package com.segu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.segu.R;
import com.segu.adapter.BirdAdapter;
import com.segu.model.Bird;

import java.util.ArrayList;

public class BirdActivity extends AppCompatActivity {
    ListView lvBird;
    ArrayList<Bird> arrBird;
    BirdAdapter birdAdapter;
    String listLove="animal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird);

        addControls();

        addEvents();

//       for(Mammalia mammalia: arrMammalia){
//           Boolean b = mammalia.getStatus();
//           if(b){
//               Log.d("check","true");
//           }
//       }
    }

    private void addEvents() {
    }

    private void addControls() {
      //  lvBird = findViewById(R.id.lvBird);
        arrBird= new ArrayList<>();
        arrBird.add(new Bird("Chim sẻ",5,"dài 0.15m, cao 0,2m",null));
        arrBird.add(new Bird("Đại bàng",3,"dài 0.4m, cao 0,3m",null));
        arrBird.add(new Bird("Chích chòe",1,"dài 0,1m, cao 0,11m ",null));
        arrBird.add(new Bird("Công",3,"dài 1,2m, cao 0,5m",null));
        arrBird.add(new Bird("Vẹt",7,"dài 0,1m, cao 0,2m",null));

        birdAdapter = new BirdAdapter(BirdActivity.this,R.layout.item_animal,arrBird);

        lvBird.setAdapter(birdAdapter);
    }
}
