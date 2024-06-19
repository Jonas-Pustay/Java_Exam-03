package com.dev.school.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Data
@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @Column(name = "flight_number")
    private String flightNumber;
    
    @Column(name = "airplane_id")
    private int airplaneId;
    
    @Column(name = "departure_city_id")
    private int departureCityId;
    
    @Column(name = "arrival_city_id")
    private int arrivalCityId;
    
    @Column(name = "departure_time")
    private Date departureTime;
    
    @Column(name = "arrival_time")
    private Date arrivalTime;
}
