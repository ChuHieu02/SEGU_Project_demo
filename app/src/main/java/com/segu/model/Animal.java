package com.segu.model;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public abstract class Animal {
    protected String species = "Động vật";
    protected String name;
    protected int age;
    protected String size;
    protected String image;

    public Animal(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Animal(String name, int age, String size, String image) {
        this.name = name;
        this.age = age;
        this.size = size;
        this.image = image;
    }

    public abstract void eat();

    public abstract void move();

    public abstract void sound();

    public void sleep() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
