package com.cabs.undercontrol.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingradient")
public class IngradientEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4195562165224578923L;

    @EmbeddedId
    private IngradientID ingradientId;

    @Column(name = "reqd_qty")
    private int requiredQuantityValue;

    @Column(name = "unit_id")
    private int unit;

    @OneToOne
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    private ItemEntity item;

    @ManyToOne
    @JoinColumn(name = "recipe_id", insertable = false, updatable = false)
    private RecipeEntity recipe;

    public int getRequiredQuantityValue() {
	return requiredQuantityValue;
    }

    public void setRequiredQuantityValue(int requiredQuantityValue) {
	this.requiredQuantityValue = requiredQuantityValue;
    }

    public IngradientID getIngradientId() {
	return ingradientId;
    }

    public void setIngradientId(IngradientID ingradientId) {
	this.ingradientId = ingradientId;
    }

    public int getUnit() {
	return unit;
    }

    public void setUnit(int unit) {
	this.unit = unit;
    }

}
