package com.example.SmartHouse.service;

import com.example.SmartHouse.entity.Characteristic;
import com.example.SmartHouse.entity.Device;
import com.example.SmartHouse.entity.DeviceType;

import java.util.List;

public interface DeviceTypeService {

    DeviceType getDeviceTypeById(Integer id);

    void saveDeviceType(DeviceType deviceType);

    void updateDeviceType(Integer id, String name);

    void deleteDeviceType(Integer id);

    List<Characteristic> findAllCharacteristic(Integer id);

    List<DeviceType> findAll();

}
