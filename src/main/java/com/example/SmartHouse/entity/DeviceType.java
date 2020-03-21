package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity @Data
@Table(name = "device_type")
public class DeviceType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_device_type")
    @SequenceGenerator(name="seq_device_type", sequenceName="SEQ_DEVICE_TYPE", allocationSize=1)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "deviceType")
    List<Characteristic> characteristics = new ArrayList<Characteristic>();


}
