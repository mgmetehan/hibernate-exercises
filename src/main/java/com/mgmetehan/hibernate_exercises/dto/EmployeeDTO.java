package com.mgmetehan.hibernate_exercises.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EmployeeDTO {
    private Long id;
    private String name;
    private double salary;
    private String type; // "EMPLOYEE", "DEVELOPER", "MANAGER"
}
