package com.cabs.undercontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabs.undercontrol.entity.UnitEntity;

public interface UnitRepository extends JpaRepository<UnitEntity, Integer> {

}
