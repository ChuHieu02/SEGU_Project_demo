package com.segu.network;

import com.segu.model.AnimalBanner;
import com.segu.model.AnimalSpecies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("71/raw")
    Call<List<AnimalSpecies>> getAnimalSpecies();

    @GET("70/raw")
    Call<List<AnimalBanner>> getAnimalBanner();




}
