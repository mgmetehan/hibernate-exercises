package com.mgmetehan.hibernate_exercises.dto;

import lombok.Data;

@Data
public class ManagerDTO extends EmployeeDTO {
    private int teamSize;
}