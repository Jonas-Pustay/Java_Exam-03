package com.dev.school.controller;

import com.dev.school.model.Airplane;
import com.dev.school.model.Flight;
import com.dev.school.service.AirplaneService;
import com.dev.school.service.CityService;
import com.dev.school.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;
    
    @Autowired
    private AirplaneService airplaneService;
    
    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("flights", flightService.getAll());
        return "flight/list";
    }

    @GetMapping("/add")
    public String displayAddForm(Flight flight, Model model) {
        model.addAttribute("airplanes", airplaneService.getAll()).addAttribute("citys", cityService.getAll());
        return "flight/add";
    }

    @PostMapping("/add")
    public String processAdd(Flight flight) {
        flightService.add(flight);
        return "redirect:/flight/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") String id, Model model) {
        Flight flight = flightService.findById(id);
        model.addAttribute("flight", flight).addAttribute("airplanes", airplaneService.getAll()).addAttribute("citys", cityService.getAll());
        return "flight/update";
    }

    @PostMapping("/update")
    public String processUpdate(Flight flight) {
        flightService.update(flight);
        return "redirect:/flight/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        flightService.delete(id);
        return "redirect:/flight/list";
    }

}
