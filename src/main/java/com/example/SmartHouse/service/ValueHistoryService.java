package com.example.SmartHouse.service;

import com.example.SmartHouse.entity.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface ValueHistoryService {

    ValueHistory getValueHistoryById(Integer id);

    void saveValueHistory(ValueHistory valueHistory);

    void updateValueHistory(Integer id, DeviceValue deviceValue, Device device, Date timeStamp);

    void deleteValueHistory(Integer id);

    List<ValueHistory> findAll();
}
