package com.cabs.undercontrol.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IngradientID implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "recipe_id")
    private int recipeId;

    @Column(name = "item_id")
    private int itemId;

    public IngradientID() {

    }

    public IngradientID(int itemId, int recipeId) {
	this.itemId = itemId;
	this.recipeId = recipeId;
    }
}
