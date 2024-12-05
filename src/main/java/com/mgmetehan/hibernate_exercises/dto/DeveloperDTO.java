package com.mgmetehan.hibernate_exercises.dto;

import lombok.Data;

@Data
public class DeveloperDTO extends EmployeeDTO {
    private String programmingLanguage;
}
