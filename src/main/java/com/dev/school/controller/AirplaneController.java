package com.dev.school.controller;

import com.dev.school.model.Airplane;
import com.dev.school.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/airplane")
public class AirplaneController {
    @Autowired
    private AirplaneService airplaneService;

    @GetMapping("/list") 
    public String list(Model model) {
        model.addAttribute("airplanes", airplaneService.getAll());
        return "airplane/list";
    }

    @GetMapping("/add")
    public String displayAddForm(Airplane airplane) {
        return "airplane/add";
    }

    @PostMapping("/add")
    public String processAdd(Airplane airplane) {
        airplaneService.add(airplane);
        return "redirect:/airplane/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") String id, Model model) {
        
        Airplane airplane = airplaneService.findById(id);
        model.addAttribute("airplane", airplane);
        return "airplane/update";
    }

    @PostMapping("/update")
    public String processUpdate(Airplane airplane) {
        airplaneService.update(airplane);
        return "redirect:/airplane/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        airplaneService.delete(id);
        return "redirect:/airplane/list";
    }

}
