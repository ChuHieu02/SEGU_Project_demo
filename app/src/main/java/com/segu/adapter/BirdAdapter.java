package com.segu.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.segu.R;
import com.segu.model.Bird;
import com.segu.model.Mammalia;

import java.util.List;

public class BirdAdapter extends ArrayAdapter<Bird> {
    Activity context;
    int resource;
    List<Bird> objects;

    public BirdAdapter(Activity context, int resource, List<Bird> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource =resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View row = layoutInflater.inflate(this.resource,null);

        TextView name = row.findViewById(R.id.txtName);
        TextView age = row.findViewById(R.id.txtAge);
        TextView size = row.findViewById(R.id.txtSize);
        ImageView imgBird = row.findViewById(R.id.imageAnimal);
       // CheckBox chkLove = row.findViewById(R.id.chkLove);


        Bird bird = this.objects.get(position);
        name.setText("Tên: " + bird.getName());
        age.setText("Tuổi: " + String.valueOf(bird.getAge()));
        size.setText("Kích thước: " + bird.getSize());
//        if(chkLove.isChecked()){
//            mammalia.setStatus(true);
//        }
        // imgMammalia.setImageURI(mammalia.getImage().);

        return row;
    }
}
