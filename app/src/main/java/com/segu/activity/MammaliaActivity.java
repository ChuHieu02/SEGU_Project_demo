package com.segu.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.segu.R;
import com.segu.adapter.MammaliaAdapter;
import com.segu.model.Mammalia;

import java.util.ArrayList;

public class MammaliaActivity extends AppCompatActivity {

    ListView lvMammalia;
    ArrayList<Mammalia> arrMammalia;
    MammaliaAdapter mammaliaAdapter;
    String listLove="animal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mammalia);

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
        lvMammalia = findViewById(R.id.lvMammalia);
        arrMammalia= new ArrayList<>();
        arrMammalia.add(new Mammalia("Hổ",5,"dài 1,2m, cao 0,8m",null));
        arrMammalia.add(new Mammalia("Báo",3,"dài 1,2m, cao 0.7m",null));
        arrMammalia.add(new Mammalia("Bò tót",6,"dài 1,6m, cao 1,5m ",null));
        arrMammalia.add(new Mammalia("Ngựa",3,"dài 1,6m, cao 1,4m",null));
        arrMammalia.add(new Mammalia("Hươu",7,"dài 2,1m, cao 3,1m",null));

         mammaliaAdapter = new MammaliaAdapter(MammaliaActivity.this,R.layout.item_animal,arrMammalia);

        lvMammalia.setAdapter(mammaliaAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();

//        SharedPreferences sharedPreferences = getSharedPreferences(listLove,MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        for(Mammalia mammalia : arrMammalia){
//            editor.putBoolean("LOVE",mammalia.getStatus());
//        }
//        editor.commit();
        }


    @Override
    protected void onResume() {
        super.onResume();
//        SharedPreferences sharedPreferences = getSharedPreferences(listLove,MODE_PRIVATE);
//
//        Boolean save = sharedPreferences.getBoolean("LOVE",false);
//        if(save){
//            for(Mammalia mammalia: arrMammalia){
//
//            }
//        }


    }

}
