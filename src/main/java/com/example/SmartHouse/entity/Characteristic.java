package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "characteristic")
public class Characteristic {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "unit")
    private String unit;

    @Getter
    @Setter
    @OneToMany(mappedBy = "characteristic", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<CharacteristicValue> characteristicValues;

    @Getter
    @Setter
    @ManyToMany (mappedBy = "characteristics")
    Set<DeviceType> deviceTypes = new HashSet<DeviceType>();

    public Characteristic() {
    }

    public Characteristic(String name) {
        this.name = name;
    }

    public Characteristic(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public void addCharacteristicValue(CharacteristicValue characteristicValue) {
        characteristicValue.setCharacteristic(this);
        characteristicValues.add(characteristicValue);
    }

    public void removeCharacteristicValue(CharacteristicValue characteristicValue) {
        characteristicValues.remove(characteristicValue);
    }

}
