package com.example.SmartHouse.repository;

import com.example.SmartHouse.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
