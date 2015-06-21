package com.cabs.undercontrol.entity;

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
@Table(name = "item_cost")
public class ItemCostEntity {

    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "item"))
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "cost_per_qty")
    private double costPerQuantity;

    @OneToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    public ItemEntity getItem() {
	return item;
    }

    public void setItem(ItemEntity item) {
	this.item = item;
    }

    public int getItemId() {
	return itemId;
    }

    public void setItemId(int itemId) {
	this.itemId = itemId;
    }

    public double getCostPerQuantity() {
	return costPerQuantity;
    }

    public void setCostPerQuantity(double costPerQuantity) {
	this.costPerQuantity = costPerQuantity;
    }

}
