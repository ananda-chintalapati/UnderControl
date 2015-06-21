package com.cabs.undercontrol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @OneToOne(mappedBy = "item")
    private CalorieEntity calorieEntity;

    @OneToOne(mappedBy = "item")
    private IngradientEntity ingradientEntity;

    @OneToOne(mappedBy = "item")
    private ItemCostEntity itemCostEntity;

    @OneToOne(mappedBy = "item")
    private ItemStockEntity itemStockEntity;

    public CalorieEntity getCalorieEntity() {
	return calorieEntity;
    }

    public void setCalorieEntity(CalorieEntity calorieEntity) {
	this.calorieEntity = calorieEntity;
    }

    public IngradientEntity getIngradientEntity() {
	return ingradientEntity;
    }

    public void setIngradientEntity(IngradientEntity ingradientEntity) {
	this.ingradientEntity = ingradientEntity;
    }

    public ItemCostEntity getItemCostEntity() {
	return itemCostEntity;
    }

    public void setItemCostEntity(ItemCostEntity itemCostEntity) {
	this.itemCostEntity = itemCostEntity;
    }

    public ItemStockEntity getItemStockEntity() {
	return itemStockEntity;
    }

    public void setItemStockEntity(ItemStockEntity itemStockEntity) {
	this.itemStockEntity = itemStockEntity;
    }

    public int getItemId() {
	return itemId;
    }

    public void setItemId(int itemId) {
	this.itemId = itemId;
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

}
