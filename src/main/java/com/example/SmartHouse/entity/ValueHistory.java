package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;



@Entity @Data
@Table(name = "value_history")
public class ValueHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "time_stamp")
    private Date timeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_value_id")
    private DeviceValue deviceValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;
}
