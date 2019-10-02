package com.segu.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.segu.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class DBQuerys {
    public static SQLiteDatabase db;
    public DBManager databasehelper;


    public static final String TABLE_NAME = "Animal";
    public static final String ID = "id";
    public static final String IMAGE = "image";
    public static final String AGE = "age";
    public static final String SIZE = "size";
    public static final String NAME = "name";
    public static final String SPECIES = "species";
    public static final String FAVOURITE = "favourite";

    public static final String sqlQuerys = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key AUTOINCREMENT, " +
            AGE + " INTEGER, " +
            FAVOURITE + " INTERGER, " +
            NAME + " TEXT, " +
            SPECIES + " TEXT, " +
            IMAGE + " TEXT, " +
            SIZE + " TEXT)";

    public DBQuerys(Context context) {
        databasehelper = new DBManager(context);
        db = databasehelper.getWritableDatabase();
    }

    public void insertAnimal(Animal animal) {
        ContentValues values = new ContentValues();
        values.put(DBQuerys.AGE, animal.getmAge());
        values.put(DBQuerys.FAVOURITE, animal.getFavourite());
        values.put(DBQuerys.NAME, animal.getmName());
        values.put(DBQuerys.SPECIES, animal.getmSpecies());
        values.put(DBQuerys.IMAGE, animal.getmImage());
        values.put(DBQuerys.SIZE, animal.getmSize());
        db.insert(DBQuerys.TABLE_NAME, null, values);

    }

    public List<Animal> sellectAllAnimal() {
        List<Animal> animals = new ArrayList<Animal>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + DBQuerys.TABLE_NAME;

        Cursor cursor = db.rawQuery(selectQuery, null);


        // Duyệt trên con trỏ, và thêm vào danh sách.
        if (db != null && cursor.moveToFirst()) {
            do {
                Animal animal = new Animal();
                animal.setId(cursor.getInt(0));
                animal.setmAge(cursor.getInt(1));
                animal.setFavourite(cursor.getInt(2));
                animal.setmName(cursor.getString(3));
                animal.setmSpecies(cursor.getString(4));
                animal.setmImage(cursor.getString(5));
                animal.setmSize(cursor.getString(6));

                // Thêm vào danh sách.
                animals.add(animal);
            } while (cursor.moveToNext());
        }
        return animals;
    }
    public void updateAnimal(Animal animal) {
        ContentValues values = new ContentValues();
        values.put(DBQuerys.ID, animal.getId());
        values.put(DBQuerys.FAVOURITE, animal.getFavourite());

        db.update(DBQuerys.TABLE_NAME, values, DBQuerys.ID + " = ?", new String[]{String.valueOf(animal.getId())});
        db.close();
    }

}
