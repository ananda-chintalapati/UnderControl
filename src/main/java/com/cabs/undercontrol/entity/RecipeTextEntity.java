package com.cabs.undercontrol.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "recipe_text")
public class RecipeTextEntity {

    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "recipe"))
    @Column(name = "recipe_id")
    private int recipeId;

    @Override
    public String toString() {
	return "RecipeTextEntity [recipeId=" + recipeId + ", text=" + text + ", image=" + image + ", recipe=" + recipe
		+ "]";
    }

    @Column(name = "text")
    private String text;

    @Column(name = "image")
    private Blob image;

    @OneToOne
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipe;

    public RecipeEntity getRecipe() {
	return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
	this.recipe = recipe;
    }

    public int getRecipeId() {
	return recipeId;
    }

    public void setRecipeId(int recipeId) {
	this.recipeId = recipeId;
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

}
