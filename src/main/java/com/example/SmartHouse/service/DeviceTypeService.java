package com.example.SmartHouse.service;

import com.example.SmartHouse.repository.DeviceTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceTypeService implements DeviceServices{
    DeviceTypeRepository deviceTypeRepository;
}
