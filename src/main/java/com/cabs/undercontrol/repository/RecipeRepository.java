package com.cabs.undercontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cabs.undercontrol.entity.RecipeEntity;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer> {

    public RecipeEntity findByRecipeId(int recipeId);

    public List<RecipeEntity> findByTimeToCookBetween(int lowerLimt, int upperLimit);

    public List<RecipeEntity> findByTimeToPrepBetween(int lowerLimt, int upperLimit);

    @Query("select r from RecipeEntity r where  r.timeToPrep+r.timeToCook between ?1 and ?2")
    public List<RecipeEntity> findByTotalCookTime(int lowerLimit, int upperLimit);

    public List<RecipeEntity> findByNameLike(String name);
}
