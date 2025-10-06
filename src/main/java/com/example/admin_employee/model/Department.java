package com.example.admin_employee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    public Long getId() { return id; }

    public String getUsername() { return name; }
    public void setUsername(String username) { this.name = name; }
}
    
    