package com.example.SmartHouse.repository;

import com.example.SmartHouse.entity.ValueHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueHistoryRepository extends JpaRepository<ValueHistory, Integer> {
}
