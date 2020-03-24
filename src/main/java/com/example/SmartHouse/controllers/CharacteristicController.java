package com.example.SmartHouse.controllers;

import com.example.SmartHouse.entity.Characteristic;
import com.example.SmartHouse.entity.Device;
import com.example.SmartHouse.entity.DeviceValue;
import com.example.SmartHouse.entity.ValueTypes;
import com.example.SmartHouse.service.CharacteristicService;
import com.example.SmartHouse.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacteristicController {

    private CharacteristicService service;

    @Autowired
    public void setCharacteristicService(CharacteristicService service) {
        this.service = service;
    }

    @RequestMapping(value = "/characteristic",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public String getCharacteristics(Model model) {
        List<Characteristic> characteristics = service.findAll();
        model.addAttribute("characteristics", characteristics);
        return "success";
    }


    @RequestMapping(value = "/characteristic/{id}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public String getCharacteristic(@PathVariable Integer id, Model model) {
        model.addAttribute("characteristic", service.getCharacteristicById(id));
        return "success";
    }

    @RequestMapping(value = "/characteristic/valueTypes/{id}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public String getCharacteristicValueTypes(@PathVariable Integer id, Model model) {
        List<ValueTypes> valueTypes = service.findAllValueTypes(id);
        model.addAttribute("valueTypes", valueTypes);
        return "success";
    }


    @RequestMapping(value = "/characteristic/add",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public void addCharacteristic(@RequestBody Characteristic characteristic) {
        service.saveCharacteristic(characteristic);
    }


    @RequestMapping(value = "/characteristic/update",
            method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public void updateCharacteristic(@RequestBody Characteristic characteristic) {
        service.updateCharacteristic(characteristic.getId(), characteristic.getDeviceType(), characteristic.getName());
    }

    @RequestMapping(value = "/characteristic/delete/{id}",
            method = RequestMethod.DELETE,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void deleteCharacteristic(@PathVariable Integer id) {
        service.deleteCharacteristic(id);
    }

}
