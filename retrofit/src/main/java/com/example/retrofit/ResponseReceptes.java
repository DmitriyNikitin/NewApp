package com.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sergejromankov on 23.09.17.
 */

public class ResponseReceptes {




    public class Data {

        @SerializedName("recipes")
        @Expose
        private List<RecipeModel> recipes = null;

        /**
         * No args constructor for use in serialization
         */
        public Data() {
        }

        /**
         * @param recipes
         */
        public Data(List<RecipeModel> recipes) {
            super();
            this.recipes = recipes;
        }

        public List<RecipeModel> getRecipes() {

            return recipes;
        }

        public void setRecipes(List<RecipeModel> recipes) {
            this.recipes = recipes;
        }

    }

    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * No args constructor for use in serialization
     */
    public ResponseReceptes() {
    }

    /**
     * @param data
     */
    public ResponseReceptes(Data data) {
        super();
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
