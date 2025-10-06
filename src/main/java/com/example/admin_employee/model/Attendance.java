package com.example.admin_employee.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Attendance {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne
@JoinColumn(name = "employee_id", nullable = false)
private Employee employee;


private LocalDateTime timestamp; // when attendance was marked


private double latitude;
private double longitude;


private boolean present; // true = present
private boolean onDuty; // true = travel on duty


private String note; // optional note


// constructors, getters, setters
public Attendance() {}


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public Employee getEmployee() { return employee; }
public void setEmployee(Employee employee) { this.employee = employee; }


public LocalDateTime getTimestamp() { return timestamp; }
public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }


public double getLatitude() { return latitude; }
public void setLatitude(double latitude) { this.latitude = latitude; }


public double getLongitude() { return longitude; }
public void setLongitude(double longitude) { this.longitude = longitude; }


public boolean isPresent() { return present; }
public void setPresent(boolean present) { this.present = present; }


public boolean isOnDuty() { return onDuty; }
public void setOnDuty(boolean onDuty) { this.onDuty = onDuty; }


public String getNote() { return note; }
public void setNote(String note) { this.note = note; }
}