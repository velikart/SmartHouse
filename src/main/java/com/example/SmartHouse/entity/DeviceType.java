package com.example.SmartHouse.entity;

import javax.persistence.*;

@Entity
@Table(name = "device_type")
public class DeviceType {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    public DeviceType() {
    }

    public DeviceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
