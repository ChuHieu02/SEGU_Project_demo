
package com.segu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnimalSpecies {

    @SerializedName("species_id")
    @Expose
    private Integer speciesId;
    @SerializedName("name")
    @Expose
    private String name;


    public Integer getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Integer speciesId) {
        this.speciesId = speciesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
