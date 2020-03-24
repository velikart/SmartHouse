package com.example.SmartHouse.controllers;

import com.example.SmartHouse.entity.Device;
import com.example.SmartHouse.entity.DeviceValue;
import com.example.SmartHouse.entity.ValueHistory;
import com.example.SmartHouse.service.DeviceService;
import com.example.SmartHouse.service.DeviceValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceValueController {

    private DeviceValueService service;

    @Autowired
    public void setDeviceValueService(DeviceValueService service) {
        this.service = service;
    }

    @RequestMapping(value = "/deviceValue",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public String getDeviceValues(Model model) {
        List<DeviceValue> deviceValues = service.findAll();
        model.addAttribute("deviceValues",deviceValues);
        return "success";
    }


    @RequestMapping(value = "/deviceValue/{id}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public String getDeviceValue(@PathVariable Integer id, Model model) {
        model.addAttribute("deviceValue", service.getDeviceValueById(id));
        return "success";
    }

    @RequestMapping(value = "/deviceValue/valueHistory/{id}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public String getDeviceValueValueHistory(@PathVariable Integer id, Model model) {
        List<ValueHistory> valueHistories = service.findAllValueHistory(id);
        model.addAttribute("valueHistories",valueHistories);
        return "success";
    }


    @RequestMapping(value = "/deviceValue/add",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public void addDeviceValue(@RequestBody DeviceValue deviceValue) {
        service.saveDeviceValue(deviceValue);
    }


    @RequestMapping(value = "/deviceValue/update",
            method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public void updateDeviceValue(@RequestBody DeviceValue deviceValue) {
        service.updateDeviceValue(deviceValue.getId(), deviceValue.getValueTypes(), deviceValue.getCharacteristic(), deviceValue.getDevice(), deviceValue.getValue());
    }

    @RequestMapping(value = "/deviceValue/delete/{id}",
            method = RequestMethod.DELETE,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void deleteDeviceValue(@PathVariable Integer id) {
        service.deleteDeviceValue(id);
    }





}
