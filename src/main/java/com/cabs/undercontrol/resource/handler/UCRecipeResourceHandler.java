package com.cabs.undercontrol.resource.handler;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cabs.undercontrol.entity.CalorieEntity;
import com.cabs.undercontrol.entity.ItemEntity;
import com.cabs.undercontrol.entity.ItemStockEntity;
import com.cabs.undercontrol.entity.RecipeEntity;
import com.cabs.undercontrol.entity.RecipeTextEntity;
import com.cabs.undercontrol.map.BeanMapper;
import com.cabs.undercontrol.model.Item;
import com.cabs.undercontrol.model.Recipe;
import com.cabs.undercontrol.repository.CalorieRepository;
import com.cabs.undercontrol.repository.ItemRepository;
import com.cabs.undercontrol.repository.ItemStockRepository;
import com.cabs.undercontrol.repository.RecipeRepository;
import com.cabs.undercontrol.repository.RecipeTextRepository;

@Component
public class UCRecipeResourceHandler {

    private static final String TIME_FILTER_PREP = "PREP";

    private static final String TIME_FILTER_COOK = "COOK";

    Logger log = LoggerFactory.getLogger(UCRecipeResourceHandler.class);

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeTextRepository recipeTextRepository;

    @Autowired
    private CalorieRepository calorieRepository;

    @Autowired
    private ItemStockRepository itemStockRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BeanMapper beanMapper;

    public List<Item> getStockAvailability() {
	List<ItemStockEntity> itemStockEntityList = itemStockRepository.findAll();
	List<Item> itemList = new ArrayList<Item>();
	for (ItemStockEntity itemStockEntity : itemStockEntityList) {
	    List<Object> sourceList = new ArrayList<Object>();
	    sourceList.add(itemStockEntity);
	    sourceList.add(itemStockEntity.getItem());
	    try {
		itemList.add(beanMapper.transform(sourceList, Item.class));
	    } catch (InstantiationException e) {
		log.debug("Failed to map Item", e);
	    } catch (IllegalAccessException e) {
		log.debug("Failed to map Item", e);
	    }
	}
	return itemList;
    }

    public List<Recipe> retrieveAllRecipes() {
	List<RecipeEntity> recipeEntityList = recipeRepository.findAll();
	return mapRecipeEntityListToRecipeList(recipeEntityList);
    }

    public List<Item> retrieveAllItemList() {
	List<ItemEntity> itemEntityList = itemRepository.findAll();
	List<Item> itemList = new ArrayList<Item>();
	for (ItemEntity itemEntity : itemEntityList) {
	    List<Object> sourceList = new ArrayList<Object>();
	    sourceList.add(itemEntity);
	    if (itemEntity.getCalorieEntity() != null) {
		sourceList.add(itemEntity.getCalorieEntity());
	    }
	    if (itemEntity.getItemCostEntity() != null) {
		sourceList.add(itemEntity.getItemCostEntity());
	    }
	    if (itemEntity.getItemStockEntity() != null) {
		sourceList.add(itemEntity.getItemStockEntity());
	    }

	    try {
		itemList.add(beanMapper.transform(sourceList, Item.class));
	    } catch (InstantiationException e) {
		log.debug("Failed to map Recipe", e);
	    } catch (IllegalAccessException e) {
		log.debug("Failed to map Recipe", e);
	    }
	}
	return itemList;
    }

    public int createRecipe(Recipe recipe) {
	RecipeEntity recipeEntity = beanMapper.transform(recipe, RecipeEntity.class);
	recipeEntity = recipeRepository.save(recipeEntity);
	RecipeTextEntity recipeText = beanMapper.transform(recipe, RecipeTextEntity.class);
	CalorieEntity calorieEntity = beanMapper.transform(recipe, CalorieEntity.class);
	recipeText.setRecipe(recipeEntity);
	recipeText = recipeTextRepository.save(recipeText);
	calorieEntity.setRecipe(recipeEntity);
	calorieEntity = calorieRepository.save(calorieEntity);

	return recipeEntity.getRecipeId();
    }

    public Recipe retrieveRecipe(int recipeId) {
	RecipeEntity recipeEntity = recipeRepository.findByRecipeId(recipeId);
	Recipe recipe = beanMapper.transform(recipeEntity, Recipe.class);
	if (recipeEntity.getCalorie() != null) {
	    recipe = beanMapper.transform(recipeEntity.getCalorie(), recipe);
	}
	if (recipeEntity.getRecipeText() != null) {
	    recipe = beanMapper.transform(recipeEntity.getRecipeText(), recipe);
	}
	return recipe;
    }

    public List<Recipe> retrieveTimeBoundRecipes(String timeFilter, int lowerLimit, int upperLimit) {
	List<RecipeEntity> recipeEntityList = new ArrayList<RecipeEntity>();
	if (StringUtils.equalsIgnoreCase(TIME_FILTER_COOK, timeFilter)) {
	    recipeEntityList = recipeRepository.findByTimeToCookBetween(lowerLimit, upperLimit);
	} else if (StringUtils.equalsIgnoreCase(TIME_FILTER_PREP, timeFilter)) {
	    recipeEntityList = recipeRepository.findByTimeToPrepBetween(lowerLimit, upperLimit);
	} else {
	    recipeEntityList = recipeRepository.findByTotalCookTime(lowerLimit, upperLimit);
	}
	return mapRecipeEntityListToRecipeList(recipeEntityList);
    }

    private List<Recipe> mapRecipeEntityListToRecipeList(List<RecipeEntity> recipeEntityList) {
	List<Recipe> recipeList = new ArrayList<Recipe>();
	for (RecipeEntity recipeEntity : recipeEntityList) {
	    List<Object> sourceList = new ArrayList<Object>();
	    sourceList.add(recipeEntity);
	    if (recipeEntity.getCalorie() != null) {
		sourceList.add(recipeEntity.getCalorie());
	    }
	    if (recipeEntity.getRecipeText() != null) {
		sourceList.add(recipeEntity.getRecipeText());
	    }
	    try {
		recipeList.add(beanMapper.transform(sourceList, Recipe.class));
	    } catch (InstantiationException e) {
		log.debug("Failed to map Recipe", e);
	    } catch (IllegalAccessException e) {
		log.debug("Failed to map Recipe", e);
	    }
	}
	return recipeList;
    }

}
