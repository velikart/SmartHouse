package com.example.SmartHouse.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Device> devices;

    public Room() {
    }

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
