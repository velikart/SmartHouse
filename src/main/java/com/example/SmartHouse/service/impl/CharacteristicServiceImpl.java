package com.example.SmartHouse.service.impl;

import com.example.SmartHouse.entity.*;
import com.example.SmartHouse.repository.CharacteristicRepository;
import com.example.SmartHouse.service.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicServiceImpl implements CharacteristicService {
    private CharacteristicRepository repository;

    @Autowired
    public void setProductRepository(CharacteristicRepository repository) {
        this.repository = repository;
    }

    @Override
    public Characteristic getCharacteristicById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveCharacteristic(Characteristic characteristic) {
        repository.save(characteristic);
    }

    @Override
    public void updateCharacteristic(Integer id, DeviceType deviceType, String name) {

        Characteristic updated = repository.findById(id).get();
        updated.setDeviceType(deviceType);
        updated.setName(name);
        repository.save(updated);
    }

    @Override
    public void deleteCharacteristic(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<ValueTypes> findAllValueTypes(Integer id) {
        return repository.findById(id).get().getValueTypes();
    }

    @Override
    public List<Characteristic> findAll() {
        return repository.findAll();
    }
}
