package com.segu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.segu.R;
import com.segu.activity.DetailIAnimalActivity;
import com.segu.model.Animal;

import java.util.List;

public class SlideImageAdapter extends RecyclerView.Adapter<SlideImageAdapter.SlideImageHolder> {
    private Context context;
    private List<Animal> animalList;
    private AnimalSpecies animalSpecies;

    public interface AnimalSpecies {
        void onClick(int position);
    }

    public void setAnimalSpecies(AnimalSpecies animalSpecies) {
        this.animalSpecies = animalSpecies;
    }

    public SlideImageAdapter(Context context, List<Animal> animalList) {
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

        final Animal animal = animalList.get(position);
        Glide.with(context)
                .load(animal.getmImage())
                .placeholder(R.drawable.loading_image)
                .into(holder.mImgAnimal);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailIAnimalActivity.class);
                intent.putExtra("name", animal.getmName());
                intent.putExtra("image", animal.getmImage());
                intent.putExtra("age", String.valueOf(animal.getmAge()));
                intent.putExtra("size", animal.getmSize());
                intent.putExtra("favourite", String.valueOf(animal.getFavourite()));
                intent.putExtra("id", String.valueOf(animal.getId()));
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
