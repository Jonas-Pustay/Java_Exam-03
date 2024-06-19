package com.dev.school.repository;


import com.dev.school.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.school.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, String> {

    Flight findByairplaneId(int airplane_id);
}
