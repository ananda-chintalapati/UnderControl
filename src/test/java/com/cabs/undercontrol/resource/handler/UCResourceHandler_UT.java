package com.cabs.undercontrol.resource.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cabs.undercontrol.model.Item;
import com.cabs.undercontrol.model.Recipe;
import com.cabs.undercontrol.model.RecipeTexture;
import com.cabs.undercontrol.repository.RecipeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class UCResourceHandler_UT {

    @Autowired
    private UCRecipeResourceHandler resourceHandler;

    private RecipeRepository mockRecipeRepository;

    @Before
    public void setup() {
	mockRecipeRepository = Mockito.mock(RecipeRepository.class);
    }

    @Test
    public void getAllRecipes() {
	List<Recipe> recipeList = resourceHandler.retrieveAllRecipes();
	assertNotNull(recipeList);
	assertEquals(recipeList.size(), 2);
    }

    @Test
    public void getAllItemList() {
	List<Item> itemList = resourceHandler.retrieveAllItemList();
	assertNotNull(itemList);
	assertEquals(itemList.size(), 6);
    }

    @Test
    public void createRecipe() {
	Recipe recipe = new Recipe();
	recipe.setCalorieValue(400);
	recipe.setItemType("RECIPE");
	recipe.setCategory("RICE");
	recipe.setCuisine("INDIAN");
	recipe.setDishType("VEGETARIAN");
	recipe.setImage(null);
	recipe.setName("FRIED RICE");
	recipe.setSpiceLevel("MEDIUM");
	recipe.setText("1. COOK RICE 2. COOK VEGETABLES 3. MIX THEM 4. ADD SALT");
	recipe.setTexture(RecipeTexture.RICE);
	recipe.setTimeToCook(15);
	recipe.setTimeToPrep(15);

	int id = resourceHandler.createRecipe(recipe);

	assertNotNull(id);
	assertEquals(id, 3);
	List<Recipe> recipeList = resourceHandler.retrieveAllRecipes();
	assertNotNull(recipeList);
	assertEquals(recipeList.size(), 3);
    }

    @Test
    public void retrieveRecipe() {
	Recipe recipe = resourceHandler.retrieveRecipe(1);
	assertNotNull(recipe);
	assertEquals(recipe.getRecipeId(), 1);
    }

    @Test
    public void retrievePrepTimeBoundRecipes() {
	List<Recipe> recipeList = resourceHandler.retrieveTimeBoundRecipes("PREP", 5, 15);
	assertNotNull(recipeList);
	assertEquals(recipeList.size(), 1);
	assertEquals(recipeList.get(0).getRecipeId(), 2);

    }

    @Test
    public void retrieveCookTimeBoundRecipes() {
	List<Recipe> recipeList = resourceHandler.retrieveTimeBoundRecipes("COOK", 30, 37);
	assertNotNull(recipeList);
	assertEquals(recipeList.size(), 1);
	assertEquals(recipeList.get(0).getRecipeId(), 2);

    }

    @Test
    public void retrieveTotalTimeBoundRecipes() {
	List<Recipe> recipeList = resourceHandler.retrieveTimeBoundRecipes("TOTAL", 30, 37);
	assertEquals(recipeList.size(), 0);

    }
}
