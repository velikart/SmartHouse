package com.example.SmartHouse.service;

import com.example.SmartHouse.entity.*;

import java.util.List;

public interface DeviceService {
    Device getDeviceById(Integer id);

    void saveDevice(Device device);

    void updateDevice(Integer id, DeviceType deviceType, Room room, User user, String name, String MAC, String coordinatorMAC, boolean enabled, byte techType);

    void deleteDevice(Integer id);

    List<DeviceValue> findAllDeviceValue(Integer id);

    List<Device> findAll();
}
