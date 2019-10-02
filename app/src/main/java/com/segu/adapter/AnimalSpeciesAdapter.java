package com.segu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.segu.R;
import com.segu.model.AnimalSpecies;

import java.util.List;

public class AnimalSpeciesAdapter extends RecyclerView.Adapter<AnimalSpeciesAdapter.AnimalSpeciesHolder> {
    private Context context;
    List<AnimalSpecies> animalSpeciesList;
    private OnclickAnimalSpecies onclickAnimalSpecies;

    public interface OnclickAnimalSpecies {
        void onClick(int position);
    }

    public void setOnclickAnimalSpecies(OnclickAnimalSpecies onclickAnimalSpecies) {
        this.onclickAnimalSpecies = onclickAnimalSpecies;
    }

    public AnimalSpeciesAdapter(Context context, List<AnimalSpecies> animalSpeciesList) {
        this.context = context;
        this.animalSpeciesList = animalSpeciesList;
    }

    @NonNull
    @Override
    public AnimalSpeciesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_animal_species, parent, false);
        return new AnimalSpeciesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalSpeciesHolder holder, final int position) {
        AnimalSpecies animalSpecies = animalSpeciesList.get(position);
        holder.tvAnimalSpecies.setText(animalSpecies.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickAnimalSpecies.onClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return animalSpeciesList.size();
    }

    public class AnimalSpeciesHolder extends RecyclerView.ViewHolder {
        private ImageView imgAnimalSpecies;
        private TextView tvAnimalSpecies;
        public AnimalSpeciesHolder(@NonNull View itemView) {
            super(itemView);
            imgAnimalSpecies = (ImageView) itemView.findViewById(R.id.img_animalSpecies);
            tvAnimalSpecies = (TextView) itemView.findViewById(R.id.tv_animalSpecies);
        }
    }
}
