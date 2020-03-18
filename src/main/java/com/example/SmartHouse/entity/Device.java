package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "device")
public class Device {

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
    @Column(name = "tech_type")
    private byte techType;

    @Getter
    @Setter
    @Column(name = "enabled")
    private boolean enabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_type_id")
    private DeviceType deviceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<CharacteristicValue> characteristicValues;

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

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void addCharacteristicValue(CharacteristicValue characteristicValue) {
        characteristicValue.setDevice(this);
        characteristicValues.add(characteristicValue);
    }

    public void removeCharacteristicValue(CharacteristicValue characteristicValue) {
        characteristicValues.remove(characteristicValue);
    }
}
