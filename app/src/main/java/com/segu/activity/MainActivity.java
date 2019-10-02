package com.segu.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.segu.R;
import com.segu.adapter.SlideImageAdapter;
import com.segu.data.DBQuerys;
import com.segu.model.Animal;
import com.segu.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcSlideImage;
    private List<Animal> animalList = new ArrayList<>();
    private SlideImageAdapter slideImageAdapter;
    private ImageView birdSpecies, fishSpecies, mammaliaSpecies, reptileSpecies, favoriteAnimalsSpecies;
    DBQuerys dbQuerys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mappingImageSpecies();
        rcSlideImage = findViewById(R.id.rc_slide_image);
        createSlideImage();

        LinearLayoutManager ln_slide_image = new LinearLayoutManager(this);
        ln_slide_image.setOrientation(RecyclerView.HORIZONTAL);
        rcSlideImage.setLayoutManager(ln_slide_image);
        animalList = dbQuerys.sellectAllAnimal();
        slideImageAdapter = new SlideImageAdapter(this, animalList);
        rcSlideImage.setAdapter(slideImageAdapter);


    }

    private void mappingImageSpecies() {
        birdSpecies = (ImageView) findViewById(R.id.birdSpecies);
        fishSpecies = (ImageView) findViewById(R.id.fishSpecies);
        mammaliaSpecies = (ImageView) findViewById(R.id.mammaliaSpecies);
        reptileSpecies = (ImageView) findViewById(R.id.reptileSpecies);
        favoriteAnimalsSpecies = (ImageView) findViewById(R.id.favoriteAnimalsSpecies);
        Glide.with(this).load("https://s3.pixers.pics/pixers/700/FO/10/43/88/97/6/700_FO104388976_80ccb49a7104c4f3c42bb66ed8736553.jpg").placeholder(R.drawable.loading_image).into(birdSpecies);
        Glide.with(this).load("https://media.giphy.com/media/oNZ7uxuxr4ZohOUVpM/giphy.gif").into(fishSpecies);
        Glide.with(this).load("https://www.sccpre.cat/mypng/detail/26-266008_tiger-png-transparent-background-tiger-png.png").placeholder(R.drawable.loading_image).into(mammaliaSpecies);
        Glide.with(this).load("https://clipartion.com/wp-content/uploads/2015/11/green-iguana-common-iguana-clipart-graphics-free-clip-art.jpg").placeholder(R.drawable.loading_image).into(reptileSpecies);
        Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0AFFswcHV8SK4T0CLhpijA4WOzVpINrU1G5yiJ2Wh1FoVgWLj").placeholder(R.drawable.loading_image).into(favoriteAnimalsSpecies);
    }


    private void createSlideImage() {
        dbQuerys = new DBQuerys(this);
//        dbQuerys.insertAnimal(new Animal(3,0,"Chim vẹt", Constants.KEY_BIRD,"https://media.ex-cdn.com/EXP/media.phunutoday.vn/files/hanhle/2018/05/27/photo1499258955932-1499258956392-14-142-296-596-crop-1499258997816-1830.jpg","Large"));
//        dbQuerys.insertAnimal(new Animal(10, 1, "Con hà mã", Constants.KEY_MAMMALS, "https://cdn.pixabay.com/photo/2018/09/01/22/03/hippo-3647749_960_720.jpg", "Large"));

    }


}
