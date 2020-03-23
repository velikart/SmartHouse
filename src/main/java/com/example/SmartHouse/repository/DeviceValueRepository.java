package com.example.SmartHouse.repository;

import com.example.SmartHouse.entity.DeviceValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceValueRepository extends JpaRepository<DeviceValue, Integer> {
}
