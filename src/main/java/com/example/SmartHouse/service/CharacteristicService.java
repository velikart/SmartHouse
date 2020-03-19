package com.example.SmartHouse.service;

import com.example.SmartHouse.repository.CharacteristicRepository;
import org.springframework.stereotype.Service;

@Service
public class CharacteristicService implements CharacteristicServices {
    CharacteristicRepository CharacteristicRepository;
}
