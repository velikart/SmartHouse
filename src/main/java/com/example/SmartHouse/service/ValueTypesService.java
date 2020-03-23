package com.example.SmartHouse.service;

import com.example.SmartHouse.entity.Characteristic;
import com.example.SmartHouse.entity.ValueTypes;

import java.util.List;

public interface ValueTypesService {
    ValueTypes getValueTypesById(Integer id);

    void saveValueTypes(ValueTypes valueTypes);

    void updateValueTypes(Integer id, Characteristic characteristic, String name, String unit, String ratio);

    void deleteValueTypes(Integer id);

    List<ValueTypes> findAll();
}
