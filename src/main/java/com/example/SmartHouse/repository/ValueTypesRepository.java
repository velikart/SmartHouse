package com.example.SmartHouse.repository;

import com.example.SmartHouse.entity.ValueTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueTypesRepository extends JpaRepository<ValueTypes, Integer> {
}
