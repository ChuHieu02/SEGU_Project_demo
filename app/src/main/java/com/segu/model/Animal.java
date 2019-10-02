package com.segu.model;

public class Animal {

    private int  mAge, id, favourite;
    private String mName, mSpecies, mImage,mSize;

    public Animal(int mAge, int favourite, String mName, String mSpecies, String mImage, String mSize) {
        this.mAge = mAge;
        this.favourite = favourite;
        this.mName = mName;
        this.mSpecies = mSpecies;
        this.mImage = mImage;
        this.mSize = mSize;
    }

    public Animal() {

    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSpecies() {
        return mSpecies;
    }

    public void setmSpecies(String mSpecies) {
        this.mSpecies = mSpecies;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getmSize() {
        return mSize;
    }

    public void setmSize(String mSize) {
        this.mSize = mSize;
    }
}
