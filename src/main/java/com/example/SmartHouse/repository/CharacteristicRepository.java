package com.example.SmartHouse.repository;

import com.example.SmartHouse.entity.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Integer> {
}
