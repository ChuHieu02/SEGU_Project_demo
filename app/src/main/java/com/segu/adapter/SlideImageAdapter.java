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
import com.segu.activity.DetailIAnimalActivity;
import com.segu.R;
import com.segu.model.Bird;

import java.util.List;

public class SlideImageAdapter extends RecyclerView.Adapter<SlideImageAdapter.SlideImageHolder> {
    private Context context;
    private List<Bird> birdList;

    public SlideImageAdapter(Context context, List<Bird> birdList) {
        this.context = context;
        this.birdList = birdList;
    }

    @NonNull
    @Override
    public SlideImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_slide_image, parent, false);
        return new SlideImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SlideImageHolder holder, int position) {

        final Bird bird = birdList.get(position);
        Glide.with(context)
                .load(bird.getImage())
                .placeholder(R.drawable.loading_image)
                .into(holder.mImgAnimal);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailIAnimalActivity.class);
                intent.putExtra("name", bird.getName());
                intent.putExtra("image", bird.getImage());
                intent.putExtra("age", String.valueOf(bird.getAge()));
                intent.putExtra("size", bird.getSize());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return birdList.size();
    }

    public class SlideImageHolder extends RecyclerView.ViewHolder {
        private ImageView mImgAnimal;

        public SlideImageHolder(@NonNull View itemView) {
            super(itemView);
            mImgAnimal = itemView.findViewById(R.id.imgAnimal);


        }
    }
}
