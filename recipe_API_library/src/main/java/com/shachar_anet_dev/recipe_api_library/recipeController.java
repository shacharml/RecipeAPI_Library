package com.shachar_anet_dev.recipe_api_library;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class recipeController {

    private static onGetRecipeListener getRecipeListener;

    public static void getRecipe(onGetRecipeListener recipeListener) {
        getRecipeListener = recipeListener;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:8081/recipe/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetRecipe getRecipe = retrofit.create(GetRecipe.class);

        getRecipe.getRandomRecipe().enqueue(new Callback<Recipe>() {

            @Override
            public void onResponse(@NonNull Call<Recipe> call, @NonNull Response<Recipe> response) {

                if (!response.isSuccessful()) {
                    //response failed
                    Log.d("TAG", "on Response failed: " + response.code());
                    getRecipeListener.onRecipeFailed(response.message());
                } else {
                    //we get the recipe from the server
                    getRecipeListener.onRecipeReturn(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Recipe> call, @NonNull Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
    }

    public interface onGetRecipeListener {
        void onRecipeReturn(Recipe recipe);

        void onRecipeFailed(String errorMessage);
    }
}
