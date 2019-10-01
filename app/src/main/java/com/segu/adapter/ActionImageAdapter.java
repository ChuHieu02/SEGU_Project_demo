package com.segu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.segu.R;
import com.segu.model.ActionAnimal;
import com.segu.model.Animal;

import java.util.List;

public class ActionImageAdapter extends RecyclerView.Adapter<ActionImageAdapter.ActionImageHolder> {
    private Context context;
    private List<ActionAnimal> animalList;
    private OnclickActionAnimal onclickActionAnimal;

    public interface OnclickActionAnimal {
        void onClick(int position);
    }

    public void setActionAnimal(OnclickActionAnimal actionAnimal) {
        this.onclickActionAnimal = actionAnimal;
    }

    public ActionImageAdapter(Context context, List<ActionAnimal> animalList) {
        this.context = context;
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public ActionImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_action_image, parent, false);
        return new ActionImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActionImageHolder holder, final int position) {
        final Animal animal = animalList.get(position);
        holder.tv_action_name_image.setText(animal.getName());
        Glide.with(context)
                .load(animal.getImage())
                .placeholder(R.drawable.loading_image)
                .into(holder.img_ActionImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickActionAnimal.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class ActionImageHolder extends RecyclerView.ViewHolder {
        private ImageView img_ActionImage;
        private TextView tv_action_name_image;


        public ActionImageHolder(@NonNull View itemView) {
            super(itemView);

            img_ActionImage = itemView.findViewById(R.id.img_action_image);
            tv_action_name_image = itemView.findViewById(R.id.tv_action_name_image);
        }
    }
}
