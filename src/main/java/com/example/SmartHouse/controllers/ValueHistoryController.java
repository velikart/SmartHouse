package com.example.SmartHouse.controllers;

import com.example.SmartHouse.entity.Device;
import com.example.SmartHouse.entity.DeviceValue;
import com.example.SmartHouse.entity.ValueHistory;
import com.example.SmartHouse.service.DeviceService;
import com.example.SmartHouse.service.ValueHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ValueHistoryController {

    private ValueHistoryService service;

    @Autowired
    public void setValueHistoryService(ValueHistoryService service) {
        this.service = service;
    }

    @RequestMapping(value = "/valueHistory",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public String getValueHistories(Model model) {
        List<ValueHistory> valueHistories = service.findAll();
        model.addAttribute("valueHistories", valueHistories);
        return "success";
    }


    @RequestMapping(value = "/valueHistory/{id}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public String getValueHistory(@PathVariable Integer id, Model model) {
        model.addAttribute("valueHistory", service.getValueHistoryById(id));
        return "success";
    }

    @RequestMapping(value = "/valueHistory/add",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public void addValueHistory(@RequestBody ValueHistory valueHistory) {
        service.saveValueHistory(valueHistory);
    }


    @RequestMapping(value = "/valueHistory/update",
            method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    public void updateValueHistory(@RequestBody ValueHistory valueHistory) {
        service.updateValueHistory(valueHistory.getId(), valueHistory.getDeviceValue(), valueHistory.getDevice(), valueHistory.getTimeStamp());
    }

    @RequestMapping(value = "/valueHistory/delete/{id}",
            method = RequestMethod.DELETE,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void deleteValueHistory(@PathVariable Integer id) {
        service.deleteValueHistory(id);
    }

}
