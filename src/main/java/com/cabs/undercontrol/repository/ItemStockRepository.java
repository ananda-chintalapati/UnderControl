package com.cabs.undercontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabs.undercontrol.entity.ItemStockEntity;

public interface ItemStockRepository extends JpaRepository<ItemStockEntity, Integer> {

}
