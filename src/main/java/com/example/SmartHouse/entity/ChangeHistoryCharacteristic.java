package com.example.SmartHouse.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

// Ещё не привязана с Characteristic или CharacteristicValue

@Entity
@Table(name = "change_history_characteristic")
public class ChangeHistoryCharacteristic {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Getter @Setter
    @Column(name = "text_change")
    private String textChange;

    @Getter @Setter
    @Column(name = "value_after")
    private String valueAfter;

    @Getter @Setter
    @Column(name = "value_before")
    private String valueBefore;

    @Getter @Setter
    @Column(name = "date")
    private Date date;

    public ChangeHistoryCharacteristic() {
    }

    public ChangeHistoryCharacteristic(String textChange, String valueAfter, String valueBefore) {
        this.textChange = textChange;
        this.valueAfter = valueAfter;
        this.valueBefore = valueBefore;
    }
}
