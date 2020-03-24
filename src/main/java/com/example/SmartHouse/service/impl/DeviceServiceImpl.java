package com.example.SmartHouse.service.impl;

import com.example.SmartHouse.entity.*;
import com.example.SmartHouse.repository.DeviceRepository;
import com.example.SmartHouse.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository repository;

    @Autowired
    public void setProductRepository(DeviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Device getDeviceById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveDevice(Device device) {
        repository.save(device);
    }

    @Override
    public Device updateDevice(Integer id, DeviceType deviceType,
                               Room room, User user,
                               String name, String MAC, String coordinatorMAC,
                               boolean enabled, byte techType) {

        Device updated = repository.findById(id).get();
        updated.setDeviceType(deviceType);
        updated.setRoom(room);
        updated.setUser(user);
        updated.setName(name);
        updated.setMAC(MAC);
        updated.setCoordinatorMAC(coordinatorMAC);
        updated.setEnabled(enabled);
        updated.setTechType(techType);
        repository.save(updated);
        return updated;
    }

    @Override
    public void deleteDevice(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<DeviceValue> findAllDeviceValue(Integer id) {
        return repository.findById(id).get().getDeviceValues();
    }

    @Override
    public List<Device> findAll() {
        return repository.findAll();
    }
}

