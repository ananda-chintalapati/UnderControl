package com.cabs.undercontrol.model;

public class Ingradient {

    private int itemId;

    private int recipeId;

    private String name;

    private String category;

    private int requiredQuantityValue;

    private int unit;

    public int getItemId() {
	return itemId;
    }

    public void setItemId(int itemId) {
	this.itemId = itemId;
    }

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

    public int getRequiredQuantityValue() {
	return requiredQuantityValue;
    }

    public void setRequiredQuantityValue(int requiredQuantityValue) {
	this.requiredQuantityValue = requiredQuantityValue;
    }

    public int getUnit() {
	return unit;
    }

    public void setUnit(int unit) {
	this.unit = unit;
    }

}
