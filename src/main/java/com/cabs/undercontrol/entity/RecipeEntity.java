package com.cabs.undercontrol.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cabs.undercontrol.model.RecipeTexture;

@Entity
@Table(name = "recipe")
public class RecipeEntity {

    @Override
    public String toString() {
	return "RecipeEntity [recipeId=" + recipeId + ", name=" + name + ", category=" + category + ", cuisine="
		+ cuisine + ", dishType=" + dishType + ", texture=" + texture + ", spiceLevel=" + spiceLevel
		+ ", timeToCook=" + timeToCook + ", timeToPrep=" + timeToPrep + ", calorie=" + calorie
		+ ", ingradientList=" + ingradientList + ", recipeText=" + recipeText + "]";
    }

    @Id
    @Column(name = "recipe_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int recipeId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "cuisine")
    private String cuisine;

    @Column(name = "dish_type")
    private String dishType;

    @Column(name = "texture")
    @Enumerated(EnumType.STRING)
    private RecipeTexture texture;

    @Column(name = "spice_level")
    private String spiceLevel;

    @Column(name = "time_to_cook")
    private int timeToCook;

    @Column(name = "time_to_prep")
    private int timeToPrep;

    @OneToOne(mappedBy = "recipe")
    private CalorieEntity calorie;

    @OneToMany(mappedBy = "recipe")
    private Set<IngradientEntity> ingradientList;

    @OneToOne(mappedBy = "recipe")
    private RecipeTextEntity recipeText;

    public RecipeTextEntity getRecipeText() {
	return recipeText;
    }

    public void setRecipeText(RecipeTextEntity recipeText) {
	this.recipeText = recipeText;
    }

    public int getTimeToPrep() {
	return timeToPrep;
    }

    public void setTimeToPrep(int timeToPrep) {
	this.timeToPrep = timeToPrep;
    }

    public CalorieEntity getCalorie() {
	return calorie;
    }

    public void setCalorie(CalorieEntity calorie) {
	this.calorie = calorie;
    }

    public Set<IngradientEntity> getIngradientList() {
	return ingradientList;
    }

    public void setIngradientList(Set<IngradientEntity> ingradientList) {
	this.ingradientList = ingradientList;
    }

    public int getRecipeId() {
	return recipeId;
    }

    public void setRecipeId(int recipeId) {
	this.recipeId = recipeId;
    }

    public String getCategory() {
	return category;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getCuisine() {
	return cuisine;
    }

    public void setCuisine(String cuisine) {
	this.cuisine = cuisine;
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

    public int getTimeToCook() {
	return timeToCook;
    }

    public void setTimeToCook(int timeToCook) {
	this.timeToCook = timeToCook;
    }

    public String getDishType() {
	return dishType;
    }

    public void setDishType(String dishType) {
	this.dishType = dishType;
    }

}
