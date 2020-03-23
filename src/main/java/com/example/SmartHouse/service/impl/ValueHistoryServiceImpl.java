package com.example.SmartHouse.service.impl;

import com.example.SmartHouse.entity.*;
import com.example.SmartHouse.repository.ValueHistoryRepository;
import com.example.SmartHouse.service.ValueHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ValueHistoryServiceImpl implements ValueHistoryService {

    private ValueHistoryRepository repository;

    @Autowired
    public void setProductRepository(ValueHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ValueHistory getValueHistoryById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveValueHistory(ValueHistory valueHistory) {
        repository.save(valueHistory);
    }

    @Override
    public void updateValueHistory(Integer id, DeviceValue deviceValue,
                                   Device device, Date timeStamp) {

        ValueHistory updated = repository.findById(id).get();
        updated.setDeviceValue(deviceValue);
        updated.setDevice(device);
        updated.setTimeStamp(timeStamp);
        repository.save(updated);
    }

    @Override
    public void deleteValueHistory(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<ValueHistory> findAll() {
        return repository.findAll();
    }
}
