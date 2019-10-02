package com.segu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.segu.R;
import com.segu.activity.DetailBannerAnimalActivity;
import com.segu.model.AnimalBanner;

import java.util.List;

public class BannerImageAnimalAdapter extends RecyclerView.Adapter<BannerImageAnimalAdapter.SlideImageHolder> {
    private Context context;
    private List<AnimalBanner> animalList;
    private AnimalSpecies animalSpecies;

    public interface AnimalSpecies {
        void onClick(int position);
    }

    public void setAnimalSpecies(AnimalSpecies animalSpecies) {
        this.animalSpecies = animalSpecies;
    }

    public BannerImageAnimalAdapter(Context context, List<AnimalBanner> animalList) {
        this.context = context;
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public SlideImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_slide_image, parent, false);
        return new SlideImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SlideImageHolder holder, int position) {

        final AnimalBanner animal = animalList.get(position);
        Glide.with(context)
                .load(animal.getBanner())
                .placeholder(R.drawable.loading_image)
                .error(R.drawable.img_err)
                .into(holder.mImgAnimal);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailBannerAnimalActivity.class);
                intent.putExtra("id", String.valueOf(animal.getAnimalId()));

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class SlideImageHolder extends RecyclerView.ViewHolder {
        private ImageView mImgAnimal;

        public SlideImageHolder(@NonNull View itemView) {
            super(itemView);
            mImgAnimal = itemView.findViewById(R.id.imgAnimal);


        }
    }
}
