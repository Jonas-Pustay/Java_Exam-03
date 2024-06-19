package com.dev.school.service;

import java.util.List;

import com.dev.school.model.Flight;

public interface FlightService {
 public List<Flight> getAll();
 public void add(Flight flight);
 public void update(Flight flightParameter);
 public void delete(String id);
 public Flight findById(String id);
 public Flight findByairplaneId(int airplane_id);
}
