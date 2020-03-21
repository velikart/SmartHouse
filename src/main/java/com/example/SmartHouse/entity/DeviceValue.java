package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity @Data
@Table(name = "device_value")
public class DeviceValue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "characteristic_id")
    private Characteristic characteristic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "value_type_id")
    private ValueTypes valueTypes;

    @OneToMany(mappedBy = "deviceValue")
    List<ValueHistory> valueHistories = new ArrayList<ValueHistory>();

}
