package com.example.SmartHouse.service;

import com.example.SmartHouse.entity.Characteristic;
import com.example.SmartHouse.entity.DeviceType;
import com.example.SmartHouse.entity.ValueTypes;

import java.util.List;

public interface CharacteristicService {
    Characteristic getCharacteristicById(Integer id);

    void saveCharacteristic(Characteristic characteristic);

    void updateCharacteristic(Integer id, DeviceType deviceType, String name);

    void deleteCharacteristic(Integer id);

    List<ValueTypes> findAllValueTypes(Integer id);

    List<Characteristic> findAll();
}
