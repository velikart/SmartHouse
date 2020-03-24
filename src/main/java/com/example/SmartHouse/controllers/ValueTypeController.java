package com.example.SmartHouse.controllers;

import com.example.SmartHouse.entity.Device;
import com.example.SmartHouse.entity.DeviceValue;
import com.example.SmartHouse.entity.ValueTypes;
import com.example.SmartHouse.service.DeviceService;
import com.example.SmartHouse.service.ValueTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ValueTypeController {

    private ValueTypesService service;

    @Autowired
    public void setValueTypesService(ValueTypesService service) {
        this.service = service;
    }

    @RequestMapping(value = "/valueTypes",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public String getValueTypes(Model model) {
        List<ValueTypes> valueTypes = service.findAll();
        model.addAttribute("valueTypes", valueTypes);
        return "success";
    }


    @RequestMapping(value = "/valueTypes/{id}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public String getValueType(@PathVariable Integer id, Model model) {
        model.addAttribute("valueType", service.getValueTypesById(id));
        return "success";
    }

    @RequestMapping(value = "/valueTypes/add",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public void addValueType(@RequestBody ValueTypes valueTypes) {
        service.saveValueTypes(valueTypes);
    }


    @RequestMapping(value = "/valueTypes/update",
            method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public void updateValueType(@RequestBody ValueTypes valueTypes) {
        service.updateValueTypes(valueTypes.getId(), valueTypes.getCharacteristic(), valueTypes.getName(), valueTypes.getUnit(), valueTypes.getRatio());
    }

    @RequestMapping(value = "/valueTypes/delete/{id}",
            method = RequestMethod.DELETE,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void deleteValueType(@PathVariable Integer id) {
        service.deleteValueTypes(id);
    }
}
