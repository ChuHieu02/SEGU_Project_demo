
package com.segu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnimalSpeciesDetail {

    @SerializedName("animal_id")
    @Expose
    private Integer animalId;
    @SerializedName("species")
    @Expose
    private Integer species;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("img_url")
    @Expose
    private String imgUrl;

    public AnimalSpeciesDetail(String name, String size, String imgUrl) {
        this.name = name;
        this.size = size;
        this.imgUrl = imgUrl;
    }

    public AnimalSpeciesDetail() {

    }

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public Integer getSpecies() {
        return species;
    }

    public void setSpecies(Integer species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "AnimalSpeciesDetail{" +
                "animalId=" + animalId +
                ", species=" + species +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
