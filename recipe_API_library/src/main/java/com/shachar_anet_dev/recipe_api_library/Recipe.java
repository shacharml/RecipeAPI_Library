package com.shachar_anet_dev.recipe_api_library;

import com.google.gson.annotations.SerializedName;

public class Recipe {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("desciption")
    private String desciption;
    @SerializedName("ingridiance")
    private String ingridiance;

    @SerializedName("urlImage")
    private String urlImage;

    public Recipe(Integer id, String name, String desciption, String ingridiance, String urlImage) {
        this.id = id;
        this.name = name;
        this.desciption = desciption;
        this.ingridiance = ingridiance;
        this.urlImage = urlImage;
    }

    public Integer getId() {
        return id;
    }

    public Recipe setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Recipe setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesciption() {
        return desciption;
    }

    public Recipe setDesciption(String desciption) {
        this.desciption = desciption;
        return this;
    }

    public String getIngridiance() {
        return ingridiance;
    }

    public Recipe setIngridiance(String ingridiance) {
        this.ingridiance = ingridiance;
        return this;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public Recipe setUrlImage(String urlImage) {
        this.urlImage = urlImage;
        return this;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desciption='" + desciption + '\'' +
                ", ingridiance='" + ingridiance + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
