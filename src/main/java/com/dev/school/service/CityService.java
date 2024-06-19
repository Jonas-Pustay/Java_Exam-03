package com.dev.school.service;

import java.util.List;

import com.dev.school.model.City;

public interface CityService {
 public List<City> getAll();
 public void add(City city);
 public void update(City cityParameter);
 
 public void delete(String id);
 public City findById(String id);
}
