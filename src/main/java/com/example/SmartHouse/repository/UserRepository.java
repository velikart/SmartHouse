package com.example.SmartHouse.repository;

import com.example.SmartHouse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
