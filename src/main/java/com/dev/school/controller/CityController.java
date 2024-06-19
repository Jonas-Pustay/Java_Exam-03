package com.dev.school.controller;

import com.dev.school.model.City;
import com.dev.school.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("citys", cityService.getAll());
        return "city/list";
    }

    @GetMapping("/add")
    public String displayAddForm(City city) {
        return "city/add";
    }

    @PostMapping("/add")
    public String processAdd(City city) {
        cityService.add(city);
        return "redirect:/city/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") String id, Model model) {
        
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        return "city/update";
    }

    @PostMapping("/update")
    public String processUpdate(City city) {
        cityService.update(city);
        return "redirect:/city/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        cityService.delete(id);
        return "redirect:/city/list";
    }

}
