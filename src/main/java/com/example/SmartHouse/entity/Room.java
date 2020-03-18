package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<Device> devices;

    public Room() {
    }

    public Room(String name) {
        this.name = name;
    }

    public void addDevice(Device device) {
        device.setRoom(this);
        devices.add(device);
    }

    public void removeDevices(Device device) {
        devices.remove(device);
    }

}
