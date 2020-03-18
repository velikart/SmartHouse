package com.example.SmartHouse.repository;

import com.example.SmartHouse.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
