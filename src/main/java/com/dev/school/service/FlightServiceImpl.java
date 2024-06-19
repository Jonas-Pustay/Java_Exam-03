package com.dev.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.school.model.Flight;
import com.dev.school.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    public void add(Flight flight) {
        flightRepository.save(flight);
    }

    public void update(Flight flightParameter) {
        if (findById(flightParameter.getFlightNumber()) != null){
            flightRepository.save(flightParameter);
        }
    }

    public void delete(String id) {
        if (findById(id) != null){
            flightRepository.deleteById(id);
        }
    }

    public Flight findById(String id) {
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        return optionalFlight.orElse(null);
    }

    @Override
    public Flight findByairplaneId(int airplane_id) {
        Flight optionalFlight = (flightRepository.findByairplaneId(airplane_id));
        return optionalFlight;
    }

}
