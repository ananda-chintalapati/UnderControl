package com.cabs.undercontrol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unit")
public class UnitEntity {

	@Id
	@Column(name="unit_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int unitId;
	
	@Column(name="name")
	private String name;

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
