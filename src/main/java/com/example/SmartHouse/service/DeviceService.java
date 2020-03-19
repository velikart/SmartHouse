package com.example.SmartHouse.service;

import com.example.SmartHouse.repository.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceService implements DeviceServices{
    DeviceRepository deviceRepository;
}
