package com.example.SmartHouse.entity;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "tech_type")
    private byte techType;
    @Column(name = "enabled")
    private boolean enabled;

    public Device() {
    }

    public Device(String name) {
        this.name = name;
    }

    public Device(String name, byte techType) {
        this.name = name;
        this.techType = techType;
    }

    public Device(String name, byte techType, boolean enabled) {
        this.name = name;
        this.techType = techType;
        this.enabled = enabled;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getTechType() {
        return techType;
    }

    public void setTechType(byte techType) {
        this.techType = techType;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
