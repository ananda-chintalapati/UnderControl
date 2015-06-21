package com.cabs.undercontrol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calorie")
public class CalorieEntity {

    @Id
    @Column(name = "calorie_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int calorieId;

    @Column(name = "calorie_value")
    private int calorieValue;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "recipe_id")
    private Integer recipeId;

    public Integer getItemId() {
	return itemId;
    }

    public void setItemId(Integer itemId) {
	this.itemId = itemId;
    }

    public Integer getRecipeId() {
	return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
	this.recipeId = recipeId;
    }

    @OneToOne
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    private ItemEntity item;

    @OneToOne
    @JoinColumn(name = "recipe_id", insertable = false, updatable = false)
    private RecipeEntity recipe;

    public RecipeEntity getRecipe() {
	return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
	this.recipe = recipe;
    }

    public int getCalorieValue() {
	return calorieValue;
    }

    public void setCalorieValue(int calorieValue) {
	this.calorieValue = calorieValue;
    }

    public String getItemType() {
	return itemType;
    }

    public void setItemType(String itemType) {
	this.itemType = itemType;
    }

    public ItemEntity getItem() {
	return item;
    }

    public void setItem(ItemEntity item) {
	this.item = item;
    }

    public int getCalorieId() {
	return calorieId;
    }

    public void setCalorieId(int calorieId) {
	this.calorieId = calorieId;
    }

    @Override
    public String toString() {
	return "CalorieEntity [calorieId=" + calorieId + ", calorieValue=" + calorieValue + ", itemType=" + itemType
		+ ", item=" + item + ", recipe=" + recipe + "]";
    }

}
