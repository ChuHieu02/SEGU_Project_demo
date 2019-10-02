package com.segu.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.segu.R;
import com.segu.adapter.AnimalSpeciesAdapter;
import com.segu.adapter.BannerImageAnimalAdapter;
import com.segu.data.DBQuerys;
import com.segu.model.AnimalBanner;
import com.segu.model.AnimalSpecies;
import com.segu.network.ApiService;
import com.segu.network.RetrofitClient;
import com.segu.utils.ConnectionReceiver;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcSlideImage;
    private RecyclerView rc_list_banner_image;
    private List<AnimalBanner> animalbannerLList = new ArrayList<AnimalBanner>();
    private List<AnimalSpecies> animalSpicesList = new ArrayList<>();
    private BannerImageAnimalAdapter bannerImageAdapter;
    private AnimalSpeciesAdapter animalSpeciesAdapter;
    private ImageView img_birdSpecies, img_fishSpecies, img_mammaliaSpecies, img_reptileSpecies, img_favoriteAnimalsSpecies;
    private CardView cvBirdSpecies, cvFishSpecies, cvMammaliaSpecies, cvReptiliaSpecies, cvFavoriteSpecies;


    DBQuerys dbQuerys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mappingImageSpecies();
        rcSlideImage = findViewById(R.id.rc_slide_image);
        rc_list_banner_image = findViewById(R.id.rc_list_banner_image);

        LinearLayoutManager ln_slide_image = new LinearLayoutManager(this);
        ln_slide_image.setOrientation(RecyclerView.HORIZONTAL);
        rcSlideImage.setLayoutManager(ln_slide_image);
        bannerImageAdapter = new BannerImageAnimalAdapter(this, animalbannerLList);
        rcSlideImage.setAdapter(bannerImageAdapter);

        addDataAnimalBanner();

        LinearLayoutManager ln_animal_species = new LinearLayoutManager(this);
        ln_animal_species.setOrientation(RecyclerView.VERTICAL);
        rc_list_banner_image.setLayoutManager(ln_animal_species);
        animalSpeciesAdapter = new AnimalSpeciesAdapter(MainActivity.this, animalSpicesList);
        rc_list_banner_image.setAdapter(animalSpeciesAdapter);

        addDataAnimalSpecies();

        onClickAnimalSpecies();

        checkNetWork();



    }

    private void checkNetWork() {
        boolean ret = ConnectionReceiver.isConnected();
        if (ret != true) {
            Toast.makeText(this, "Vui lòng kiểm tra kết nối mạng", Toast.LENGTH_SHORT).show();
        }

    }

    private void addDataAnimalBanner() {
        Retrofit retrofit = RetrofitClient.getRetrofitClient();
        ApiService apiService = retrofit.create(ApiService.class);

        Call<List<AnimalBanner>> call = apiService.getAnimalBanner();
        call.enqueue(new Callback<List<AnimalBanner>>() {
            @Override
            public void onResponse(Call<List<AnimalBanner>> call, Response<List<AnimalBanner>> response) {
                if (response.isSuccessful()){
                    if (response.body()!=null){
                        animalbannerLList.addAll(response.body());
                        bannerImageAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<AnimalBanner>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Lỗi xảy ra", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onClickAnimalSpecies() {
        animalSpeciesAdapter.setOnclickAnimalSpecies(new AnimalSpeciesAdapter.OnclickAnimalSpecies() {
            @Override
            public void onClick(int position) {
                AnimalSpecies animalSpecies = animalSpicesList.get(position);
                Toast.makeText(MainActivity.this, ""+animalSpecies.getSpeciesId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addDataAnimalSpecies() {
        Retrofit retrofit = RetrofitClient.getRetrofitClient();
        ApiService apiService = retrofit.create(ApiService.class);

        Call<List<AnimalSpecies>> call = apiService.getAnimalSpecies();
        call.enqueue(new Callback<List<AnimalSpecies>>() {
            @Override
            public void onResponse(Call<List<AnimalSpecies>> call, Response<List<AnimalSpecies>> response) {
                if (response.isSuccessful()){
                    animalSpicesList.addAll(response.body());
                    animalSpeciesAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<AnimalSpecies>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Lỗi xảy ra", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mappingImageSpecies() {


//        Glide.with(this).load("https://s3.pixers.pics/pixers/700/FO/10/43/88/97/6/700_FO104388976_80ccb49a7104c4f3c42bb66ed8736553.jpg").placeholder(R.drawable.loading_image).into(img_birdSpecies);
//        Glide.with(this).load("https://media.giphy.com/media/oNZ7uxuxr4ZohOUVpM/giphy.gif").into(img_fishSpecies);
//        Glide.with(this).load("https://www.sccpre.cat/mypng/detail/26-266008_tiger-png-transparent-background-tiger-png.png").placeholder(R.drawable.loading_image).into(img_mammaliaSpecies);
//        Glide.with(this).load("https://clipartion.com/wp-content/uploads/2015/11/green-iguana-common-iguana-clipart-graphics-free-clip-art.jpg").placeholder(R.drawable.loading_image).into(img_reptileSpecies);
//        Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0AFFswcHV8SK4T0CLhpijA4WOzVpINrU1G5yiJ2Wh1FoVgWLj").placeholder(R.drawable.loading_image).into(img_favoriteAnimalsSpecies);
    }
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = null;
        if (cm != null) {
            activeNetwork = cm.getActiveNetworkInfo();
        }

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }


    private void createSlideImage() {
        dbQuerys = new DBQuerys(this);
//        dbQuerys.insertAnimal(new Animal(3,0,"Chim vẹt", Constants.KEY_BIRD,"https://media.ex-cdn.com/EXP/media.phunutoday.vn/files/hanhle/2018/05/27/photo1499258955932-1499258956392-14-142-296-596-crop-1499258997816-1830.jpg","Large"));
//        dbQuerys.insertAnimal(new Animal(10, 1, "Con hà mã", Constants.KEY_MAMMALS, "https://cdn.pixabay.com/photo/2018/09/01/22/03/hippo-3647749_960_720.jpg", "Large"));

    }


}
