package com.cabs.undercontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabs.undercontrol.entity.IngradientEntity;

public interface IngradientRepository extends JpaRepository<IngradientEntity, Integer> {

}
