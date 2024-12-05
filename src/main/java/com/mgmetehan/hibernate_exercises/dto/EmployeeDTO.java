package com.mgmetehan.hibernate_exercises.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private double salary;
    private String type; // "EMPLOYEE", "DEVELOPER", "MANAGER"
}
