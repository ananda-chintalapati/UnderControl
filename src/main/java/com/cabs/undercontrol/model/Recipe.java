package com.cabs.undercontrol.model;

import java.sql.Blob;
import java.util.List;

public class Recipe {

    private int recipeId;

    private String name;

    private String category;

    private String cuisine;

    private String dishType;

    private RecipeTexture texture;

    private String spiceLevel;

    private int calorieValue;

    private String itemType;

    public String getItemType() {
	return itemType;
    }

    public void setItemType(String itemType) {
	this.itemType = itemType;
    }

    private int timeToCook;

    private int timeToPrep;

    private String text;

    private Blob image;

    private List<RecipeCategory> recipeCategory;

    public int getRecipeId() {
	return recipeId;
    }

    public void setRecipeId(int recipeId) {
	this.recipeId = recipeId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getCategory() {
	return category;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    public String getCuisine() {
	return cuisine;
    }

    public void setCuisine(String cuisine) {
	this.cuisine = cuisine;
    }

    public String getDishType() {
	return dishType;
    }

    public void setDishType(String dishType) {
	this.dishType = dishType;
    }

    public RecipeTexture getTexture() {
	return texture;
    }

    public void setTexture(RecipeTexture texture) {
	this.texture = texture;
    }

    public String getSpiceLevel() {
	return spiceLevel;
    }

    public void setSpiceLevel(String spiceLevel) {
	this.spiceLevel = spiceLevel;
    }

    public int getCalorieValue() {
	return calorieValue;
    }

    public void setCalorieValue(int calorieValue) {
	this.calorieValue = calorieValue;
    }

    public int getTimeToCook() {
	return timeToCook;
    }

    public void setTimeToCook(int timeToCook) {
	this.timeToCook = timeToCook;
    }

    public int getTimeToPrep() {
	return timeToPrep;
    }

    public void setTimeToPrep(int timeToPrep) {
	this.timeToPrep = timeToPrep;
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public Blob getImage() {
	return image;
    }

    public void setImage(Blob image) {
	this.image = image;
    }

    public List<RecipeCategory> getRecipeCategory() {
	return recipeCategory;
    }

    public void setRecipeCategory(List<RecipeCategory> recipeCategory) {
	this.recipeCategory = recipeCategory;
    }

    @Override
    public String toString() {
	return "Recipe [recipeId=" + recipeId + ", name=" + name + ", category=" + category + ", cuisine=" + cuisine
		+ ", dishType=" + dishType + ", texture=" + texture + ", spiceLevel=" + spiceLevel + ", calorieValue="
		+ calorieValue + ", timeToCook=" + timeToCook + ", timeToPrep=" + timeToPrep + ", text=" + text
		+ ", image=" + image + ", recipeCategory=" + recipeCategory + "]";
    }
}
