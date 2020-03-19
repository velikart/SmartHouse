package com.example.SmartHouse.service;

import com.example.SmartHouse.repository.CharacteristicValueRepository;
import org.springframework.stereotype.Service;

@Service
public class CharacteristicValueServices implements CharcteristicValueServices {
    CharacteristicValueRepository characteristicValueRepository;
}
