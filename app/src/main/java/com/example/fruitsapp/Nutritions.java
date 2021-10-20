
package com.example.fruitsapp;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutritions {

    @SerializedName("carbohydrates")
    @Expose
    private Double carbohydrates;
    @SerializedName("protein")
    @Expose
    private Double protein;
    @SerializedName("fat")
    @Expose
    private Double fat;
    @SerializedName("calories")
    @Expose
    private Double calories;
    @SerializedName("sugar")
    @Expose
    private Double sugar;

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getSugar() {
        return sugar;
    }

    public void setSugar(Double sugar) {
        this.sugar = sugar;
    }

}
