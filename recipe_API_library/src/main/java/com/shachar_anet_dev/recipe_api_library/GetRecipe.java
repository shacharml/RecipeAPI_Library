package com.shachar_anet_dev.recipe_api_library;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetRecipe {

    @GET("getRandomRecipe")
    Call<Recipe> getRandomRecipe();
}
