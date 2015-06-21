package com.cabs.undercontrol.model;

import java.util.Date;

public class Item {

    private int itemId;

    private String name;

    private String category;

    private String unit;

    private Date expiryDate;

    private int quantityAvailable;

    private double weightAvailable;

    private double costPerQuantity;

    public double getCostPerQuantity() {
	return costPerQuantity;
    }

    public void setCostPerQuantity(double costPerQuantity) {
	this.costPerQuantity = costPerQuantity;
    }

    public String getUnit() {
	return unit;
    }

    public void setUnit(String unit) {
	this.unit = unit;
    }

    public Date getExpiryDate() {
	return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
	this.expiryDate = expiryDate;
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

    public int getItemId() {
	return itemId;
    }

    public void setItemId(int itemId) {
	this.itemId = itemId;
    }

    public int getQuantityAvailable() {
	return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
	this.quantityAvailable = quantityAvailable;
    }

    public double getWeightAvailable() {
	return weightAvailable;
    }

    public void setWeightAvailable(double weightAvailable) {
	this.weightAvailable = weightAvailable;
    }

}
