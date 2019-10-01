package com.segu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.segu.R;
import com.segu.adapter.ActionImageAdapter;
import com.segu.adapter.SlideImageAdapter;
import com.segu.model.ActionAnimal;
import com.segu.model.Bird;
import com.segu.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rcSlideImage;
    private List<Bird> birdList = new ArrayList<>();
    private SlideImageAdapter slideImageAdapter;

    private List<ActionAnimal> actionAnimals = new ArrayList<>();
    private ActionImageAdapter actionImageAdapter;
    private RecyclerView rcListActionImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rcSlideImage = findViewById(R.id.rc_slide_image);
        rcListActionImage = findViewById(R.id.rc_list_action_image);

        LinearLayoutManager ln_slide_image = new LinearLayoutManager(this);
        ln_slide_image.setOrientation(RecyclerView.HORIZONTAL);
        rcSlideImage.setLayoutManager(ln_slide_image);
        slideImageAdapter = new SlideImageAdapter(this, birdList);
        createBirdList();
        rcSlideImage.setAdapter(slideImageAdapter);

        LinearLayoutManager ln_action_image = new LinearLayoutManager(this);
        rcListActionImage.setLayoutManager(ln_action_image);
        actionImageAdapter = new ActionImageAdapter(this, actionAnimals);
        rcListActionImage.setAdapter(actionImageAdapter);
        createAnimalList();
        rcListActionImage.setAdapter(actionImageAdapter);

        actionImageAdapter.setActionAnimal(new ActionImageAdapter.OnclickActionAnimal() {
            @Override
            public void onClick(int position) {
                Animal animal = actionAnimals.get(position);
                if (animal.getName().equals("Mammalia")){
                    startActivity(new Intent(MainActivity.this, MammaliaActivity.class));
                }
//                if(animal.getName().equals("Bird")){
//                    startActivity(new Intent(MainActivity.this, BirdActivity.class));
//                }
            }
        });

    }

    private void createAnimalList() {
        actionAnimals.add(new ActionAnimal("Bird", "https://s3.pixers.pics/pixers/700/FO/10/43/88/97/6/700_FO104388976_80ccb49a7104c4f3c42bb66ed8736553.jpg"));
        actionAnimals.add(new ActionAnimal("Fish", "https://media.giphy.com/media/oNZ7uxuxr4ZohOUVpM/giphy.gif"));
        actionAnimals.add(new ActionAnimal("Mammalia", "https://www.sccpre.cat/mypng/detail/26-266008_tiger-png-transparent-background-tiger-png.png"));
        actionAnimals.add(new ActionAnimal("Reptilia", "https://clipartion.com/wp-content/uploads/2015/11/green-iguana-common-iguana-clipart-graphics-free-clip-art.jpg"));
        actionAnimals.add(new ActionAnimal("Favorite Animals", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0AFFswcHV8SK4T0CLhpijA4WOzVpINrU1G5yiJ2Wh1FoVgWLj"));


    }

    private void createBirdList() {
        birdList.add(new Bird("Chim đại bàng", 1, "small", "http://2.bp.blogspot.com/-7eziL1a4iuk/WQ6NhA7VnoI/AAAAAAAAC08/aEA1J2sYmrAMzEB119kvq-yGtw7NfZJwgCK4B/s1600/ThienphuTV.jpg"));
        birdList.add(new Bird("Chim cánh cụt", 2, "small", "https://cdn.tuoitre.vn/thumb_w/640/2019/5/26/tto-20190526-penguins-1-1558868934165584824151.jpg"));
        birdList.add(new Bird("Con vẹt", 2, "small", "https://media.ex-cdn.com/EXP/media.phunutoday.vn/files/hanhle/2018/05/27/photo1499258955932-1499258956392-14-142-296-596-crop-1499258997816-1830.jpg"));
        birdList.add(new Bird("Con cú mèo", 2, "small", "https://www.tuvikhoahoc.com/data/2017/07/cu-meo-bay-vao-nha-la-diem-gi-1024x768.jpg"));
        birdList.add(new Bird("Con công", 2, "small", "https://img2.thuthuatphanmem.vn/uploads/2018/12/05/anh-dep-ve-con-cong_105538066.jpg"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}
