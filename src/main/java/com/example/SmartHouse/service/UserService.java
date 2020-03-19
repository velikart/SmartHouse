package com.example.SmartHouse.service;

import com.example.SmartHouse.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServices {
    UserRepository userRepository;
}
