package com.example.SmartHouse.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "device_type")
public class DeviceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "deviceType", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Device> devices;

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

    public void addDevice(Device device) {
        device.setDeviceType(this);
        devices.add(device);
    }

    public void removeDevices(Device device) {
        devices.remove(device);
    }
}
