package com.dev.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.school.model.Airplane;
import com.dev.school.repository.AirplaneRepository;

@Service
public class AirplaneServiceImpl implements AirplaneService{

    @Autowired
    AirplaneRepository airplaneRepository;

    public List<Airplane> getAll() {
        return airplaneRepository.findAll();
    }

    public void add(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    public void update(Airplane airplaneParameter) {
        if (findById(String.valueOf(airplaneParameter.getId())) != null){
            airplaneRepository.save(airplaneParameter);
        }
    }

    public void delete(String id) {
        if (findById(id) != null){
            airplaneRepository.deleteById(id);
        }
    }

    public Airplane findById(String id) {
        Optional<Airplane> optionalAirplane = airplaneRepository.findById(id);
        return optionalAirplane.orElse(null);
    }

}
