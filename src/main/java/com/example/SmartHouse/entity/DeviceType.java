package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity @Data
@Table(name = "device_type")
public class DeviceType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "deviceType")
    List<Characteristic> characteristics = new ArrayList<Characteristic>();


}
