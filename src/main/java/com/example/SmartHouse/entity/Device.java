package com.example.SmartHouse.entity;

import com.example.SmartHouse.otherDataClasses.TechTypeDevice;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Getter @Setter
    @Column(name = "name")
    private String name;

    @Getter @Setter
    @Column(name = "tech_type")
    private byte techType;

    @Getter @Setter
    @Column(name = "enabled")
    private boolean enabled;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_type_id")
    private DeviceType deviceType;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @Getter @Setter
    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<CharacteristicValue> characteristicValues;

    @Getter @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "device_user",
            joinColumns = { @JoinColumn(name = "device_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private Set<User> users = new HashSet<User>();

    public Device() {
    }

    public Device(String name) {
        this.name = name;
    }

    public Device(String name, TechTypeDevice techTypeDevice) {
        this.name = name;
        this.techType = techTypeDevice.getId();
    }

    public Device(String name, TechTypeDevice techTypeDevice, boolean enabled) {
        this.name = name;
        this.techType = techTypeDevice.getId();
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
