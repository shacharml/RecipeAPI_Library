package com.shachar_anet_dev.recipeapi_library;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.shachar_anet_dev.recipe_api_library.Recipe;
import com.shachar_anet_dev.recipe_api_library.recipeController;

public class MainActivity extends AppCompatActivity implements recipeController.onGetRecipeListener {

    private TextView name;
    private TextView ingridiance;
    private TextView description;
    private Button random;
    private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initListener();
    }

    private void initListener() {
        random.setOnClickListener(view -> recipeController.getRecipe(MainActivity.this));
    }

    private void findViews() {
        random = findViewById(R.id.random);
        name = findViewById(R.id.name);
        ingridiance = findViewById(R.id.ingridiance);
        description = findViewById(R.id.description);
        image = findViewById(R.id.imageRecipe);
    }

    @Override
    public void onRecipeReturn(Recipe recipe) {
        this.name.setText("" + recipe.getName());
        this.ingridiance.setText("Ingridiance:\n" + recipe.getIngridiance());
        this.description.setText("Description:\n" + recipe.getDesciption());

        Glide.with(this)
                .load(recipe.getUrlImage())
                .circleCrop()
                .centerCrop()
                .into(image);
//                .override(300,300)
//                        .placeholder(R.drawable.ic_launcher_background)
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onRecipeFailed(String errorMessage) {
        Log.d("TAG", "mess: " + errorMessage);
        ingridiance.setText("45 " + errorMessage);
    }

}