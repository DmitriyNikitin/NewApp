package com.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sergejromankov on 23.09.17.
 */

public class RecipeModel {
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("subtitle")
    @Expose
    public String subtitle;
    @SerializedName("count_like")
    @Expose
    public Integer countLike;
    @SerializedName("cooking_time")
    @Expose
    public Integer cookingTime;
}
