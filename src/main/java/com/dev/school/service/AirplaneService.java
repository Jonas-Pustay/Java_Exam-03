package com.dev.school.service;

import java.util.List;

import com.dev.school.model.Airplane;

public interface AirplaneService {
 public List<Airplane> getAll();
 public void add(Airplane airplane);
 public void update(Airplane airplaneParameter);
 
 public void delete(String id);
 public Airplane findById(String id);
}
