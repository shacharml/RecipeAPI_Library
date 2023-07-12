package com.shachar_anet_dev.recipeapi_library;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.shachar_anet_dev.recipe_api_library.Recipe;
import com.shachar_anet_dev.recipe_api_library.recipeController;

public class MainActivity extends AppCompatActivity implements recipeController.onGetRecipeListener {

    private MaterialTextView name;
    private MaterialTextView ingridiance;
    private MaterialTextView description;
    private MaterialButton random;
    private AppCompatImageView image;
    private ProgressBar progressBar;


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
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void onRecipeReturn(Recipe recipe) {
        this.name.setText("" + recipe.getName());
        this.ingridiance.setText("" + recipe.getIngridiance());
        this.description.setText("" + recipe.getDesciption());

        progressBar.setVisibility(View.VISIBLE);

        Glide.with(this)
                .load(recipe.getUrlImage())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;                    }
                })
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