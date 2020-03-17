package com.example.SmartHouse.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "characteristic")
public class Characteristic {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit")
    private String unit;

    @OneToMany(mappedBy = "characteristic", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<CharacteristicValue> characteristicValues;

    public Characteristic() {
    }

    public Characteristic(String name) {
        this.name = name;
    }

    public Characteristic(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
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
