package com.dev.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.school.model.City;
import com.dev.school.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    CityRepository cityRepository;

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public void add(City city) {
        cityRepository.save(city);
    }

    public void update(City cityParameter) {
        if (findById(String.valueOf(cityParameter.getId())) != null){
            cityRepository.save(cityParameter);
        }
    }

    public void delete(String id) {
        if (findById(id) != null){
            cityRepository.deleteById(id);
        }
    }

    public City findById(String id) {
        Optional<City> optionalCity = cityRepository.findById(id);
        return optionalCity.orElse(null);
    }

}
