package com.example.SmartHouse.entity;

import javax.persistence.*;

@Entity
@Table(name = "characteristic_value")
public class CharacteristicValue {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column (name = "value")
    private String value;

    public CharacteristicValue() {
    }

    public CharacteristicValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
