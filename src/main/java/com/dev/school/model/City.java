package com.dev.school.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

//in case vscode display error on lombok remove this java support language extension => georgewfraser.vscode-javac 
@Data
@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
}
