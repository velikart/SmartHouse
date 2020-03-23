package com.example.SmartHouse.service.impl;

import com.example.SmartHouse.entity.Characteristic;
import com.example.SmartHouse.entity.DeviceType;
import com.example.SmartHouse.repository.DeviceTypeRepository;
import com.example.SmartHouse.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    private DeviceTypeRepository repository;

    @Autowired
    public void setProductRepository(DeviceTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceType getDeviceTypeById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveDeviceType(DeviceType deviceType) {
        repository.save(deviceType);
    }

    @Override
    public void updateDeviceType(Integer id, String name) {

        DeviceType updated = repository.findById(id).get();
        updated.setName(name);
        repository.save(updated);
    }

    @Override
    public void deleteDeviceType(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Characteristic> findAllCharacteristic(Integer id) {
        return repository.findById(id).get().getCharacteristics();
    };

    @Override
    public List<DeviceType> findAll() {
        return repository.findAll();
    }
}
