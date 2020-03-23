package com.example.SmartHouse.service.impl;

import com.example.SmartHouse.entity.*;
import com.example.SmartHouse.repository.DeviceRepository;
import com.example.SmartHouse.repository.ValueTypesRepository;
import com.example.SmartHouse.service.ValueTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValueTypesServiceImpl implements ValueTypesService {
    private ValueTypesRepository repository;

    @Autowired
    public void setProductRepository(ValueTypesRepository repository) {
        this.repository = repository;
    }

    @Override
    public ValueTypes getValueTypesById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveValueTypes(ValueTypes valueTypes) {
        repository.save(valueTypes);
    }

    @Override
    public void updateValueTypes(Integer id, Characteristic characteristic, String name, String unit, String ratio) {

        ValueTypes updated = repository.findById(id).get();
        updated.setCharacteristic(characteristic);
        updated.setName(name);
        updated.setUnit(unit);
        updated.setRatio(ratio);
        repository.save(updated);
    }

    @Override
    public void deleteValueTypes(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<ValueTypes> findAll() {
        return repository.findAll();
    }
}
