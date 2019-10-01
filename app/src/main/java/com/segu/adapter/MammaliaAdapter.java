package com.segu.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.segu.R;
import com.segu.model.Mammalia;

import java.util.List;

public class MammaliaAdapter extends ArrayAdapter<Mammalia> {
    Activity context;
    int resource;
    List<Mammalia> objects;

    public MammaliaAdapter(Activity context, int resource, List<Mammalia> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource =resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View row = layoutInflater.inflate(this.resource,null);

        TextView name = row.findViewById(R.id.txtName);
        TextView age = row.findViewById(R.id.txtAge);
        TextView size = row.findViewById(R.id.txtSize);
        ImageView imgMammalia = row.findViewById(R.id.imageAnimal);
        CheckBox chkLove = row.findViewById(R.id.chkLove);


        Mammalia mammalia = this.objects.get(position);
        name.setText("Tên: " + mammalia.getName());
        age.setText("Tuổi: " + String.valueOf(mammalia.getAge()));
        size.setText("Kích thước: " + mammalia.getSize());
//        if(chkLove.isChecked()){
//            mammalia.setStatus(true);
//        }
       // imgMammalia.setImageURI(mammalia.getImage().);

        return row;
    }
}
