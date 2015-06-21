package com.cabs.undercontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabs.undercontrol.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {

}
