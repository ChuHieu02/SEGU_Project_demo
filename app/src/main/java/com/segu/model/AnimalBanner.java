
package com.segu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnimalBanner {

    @SerializedName("animal_id")
    @Expose
    private Integer animalId;
    @SerializedName("banner")
    @Expose
    private String banner;

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

}
