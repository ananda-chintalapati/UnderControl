package com.cabs.undercontrol.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabs.undercontrol.model.Item;
import com.cabs.undercontrol.model.Recipe;
import com.cabs.undercontrol.resource.handler.UCRecipeResourceHandler;

@Service
@Path("/recipe")
public class UCRecipeResource {

    @Autowired
    private UCRecipeResourceHandler resourceHandler;

    @GET
    @Path("/allrecipes")
    public List<Recipe> retreiveAllRecipes() {
	return resourceHandler.retrieveAllRecipes();
    }

    @GET
    @Path("/{recipeType}")
    public void getRecipe() {

    }

    @POST
    @Path("/{recipeType}")
    public void createRecipe() {

    }

    @PUT
    @Path("/recipe/{recipeId}")
    public void modifyRecipe() {

    }

    @GET
    @Path("/stock/{type}")
    public List<Item> getStock() {
	return resourceHandler.getStockAvailability();
    }

    @PUT
    @Path("/stock/{id}")
    public void modifyStock() {

    }

    @POST
    @Path("/stock/{type}")
    public void addStock() {

    }

    @GET
    @Path("/inventory/{type}")
    public void getInventoryForSelection() {

    }

    @PUT
    @Path("/inventory/{id}")
    public void modifyInventoryForSelection() {

    }

    @POST
    @Path("/inventory/{type}")
    public void addInventoryForSelection() {

    }
}
