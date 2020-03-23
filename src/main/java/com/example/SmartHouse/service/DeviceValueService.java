package com.example.SmartHouse.service;

import com.example.SmartHouse.entity.*;

import java.util.List;

public interface DeviceValueService {
    DeviceValue getDeviceValueById(Integer id);

    void saveDeviceValue(DeviceValue device);

    void updateDeviceValue(Integer id, ValueTypes valueTypes, Characteristic characteristic, Device device, String value);

    void deleteDeviceValue(Integer id);

    List<ValueHistory> findAllValueHistory(Integer id);

    List<DeviceValue> findAll();
}
