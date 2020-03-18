package com.example.SmartHouse.repository;

import com.example.SmartHouse.entity.CharacteristicValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicValueRepository extends JpaRepository<CharacteristicValue, Integer> {
}
