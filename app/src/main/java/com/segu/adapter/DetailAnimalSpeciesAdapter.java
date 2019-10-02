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
import com.segu.model.AnimalSpeciesDetail;

import java.util.List;

public class DetailAnimalSpeciesAdapter extends RecyclerView.Adapter<DetailAnimalSpeciesAdapter.Viewholder> {
    private Context context;
    private List<AnimalSpeciesDetail> animalDetailSpeciesList;

    public DetailAnimalSpeciesAdapter(Context context, List<AnimalSpeciesDetail> animalDetailSpeciesList) {
        this.context = context;
        this.animalDetailSpeciesList = animalDetailSpeciesList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_animal, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        AnimalSpeciesDetail animalSpeciesDetail = animalDetailSpeciesList.get(position);
        holder.txtName.setText(animalSpeciesDetail.getName());
        holder.txtSize.setText(animalSpeciesDetail.getSize());
        Glide.with(context).load(animalSpeciesDetail.getImgUrl()).error(R.drawable.img_err).placeholder(R.drawable.loading_image).into(holder.imageAnimal);

    }

    @Override
    public int getItemCount() {
        return animalDetailSpeciesList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView imageAnimal;
        private TextView txtName;
        private TextView txtSize;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageAnimal = (ImageView) itemView.findViewById(R.id.imageAnimal);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtSize = (TextView) itemView.findViewById(R.id.txtSize);
        }
    }
    public void delete() {
        this.animalDetailSpeciesList.clear();
        notifyDataSetChanged();
    }
}
