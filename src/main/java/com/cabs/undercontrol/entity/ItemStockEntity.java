package com.cabs.undercontrol.entity;

import java.util.Date;

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
@Table(name = "item_stock")
public class ItemStockEntity {

    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "item"))
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "qty_available")
    private int quantityAvailable;

    @Column(name = "weight_available")
    private double weightAvailable;

    @Column(name = "expiry_date")
    private Date expiryDate;

    public Date getExpiryDate() {
	return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
	this.expiryDate = expiryDate;
    }

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
