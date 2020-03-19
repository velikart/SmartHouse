package com.example.SmartHouse.service;

import com.example.SmartHouse.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements RoomServices {
    RoomRepository roomRepository;
}
