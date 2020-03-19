package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "device_type")
public class DeviceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Getter @Setter
    @Column(name = "name")
    private String name;

    @Getter @Setter
    @OneToMany(mappedBy = "deviceType", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<Device> devices;

    @Getter @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "device_type-characteristic",
            joinColumns = { @JoinColumn(name = "device_type_id") },
            inverseJoinColumns = { @JoinColumn(name = "characteristic_id") })
    private Set<Characteristic> characteristics = new HashSet<Characteristic>();

    public DeviceType() {
    }

    public DeviceType(String name) {
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
