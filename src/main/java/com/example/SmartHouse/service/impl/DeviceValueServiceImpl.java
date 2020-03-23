package com.example.SmartHouse.service.impl;

import com.example.SmartHouse.entity.*;
import com.example.SmartHouse.repository.DeviceValueRepository;
import com.example.SmartHouse.service.DeviceValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceValueServiceImpl implements DeviceValueService {
    private DeviceValueRepository repository;

    @Autowired
    public void setProductRepository(DeviceValueRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceValue getDeviceValueById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveDeviceValue(DeviceValue deviceValue) {
        repository.save(deviceValue);
    }

    @Override
    public void updateDeviceValue(Integer id, ValueTypes valueTypes, Characteristic characteristic, Device device, String value) {

        DeviceValue updated = repository.findById(id).get();
        updated.setValueTypes(valueTypes);
        updated.setCharacteristic(characteristic);
        updated.setDevice(device);
        updated.setValue(value);
        repository.save(updated);
    }

    @Override
    public void deleteDeviceValue(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<ValueHistory> findAllValueHistory(Integer id){
        return repository.findById(id).get().getValueHistories();
    }

    @Override
    public List<DeviceValue> findAll() {
        return repository.findAll();
    }
}
