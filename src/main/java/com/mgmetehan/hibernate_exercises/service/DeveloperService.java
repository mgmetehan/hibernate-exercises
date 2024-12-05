package com.mgmetehan.hibernate_exercises.service;

import com.mgmetehan.hibernate_exercises.dto.DeveloperDTO;
import com.mgmetehan.hibernate_exercises.model.inheritance.single.Developer;
import com.mgmetehan.hibernate_exercises.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeveloperService {

    private final EmployeeRepository employeeRepository;

    public Developer saveDeveloper(DeveloperDTO developerDTO) {
        Developer developer = Developer.builder()
                .name(developerDTO.getName())
                .salary(developerDTO.getSalary())
                .programmingLanguage(developerDTO.getProgrammingLanguage())
                .build();
        return employeeRepository.save(developer);
    }

    public List<DeveloperDTO> getAllDevelopers() {
        return employeeRepository.findAll().stream()
                .filter(emp -> emp instanceof Developer)
                .map(emp -> {
                    Developer dev = (Developer) emp;
                    DeveloperDTO dto = new DeveloperDTO();
                    dto.setId(dev.getId());
                    dto.setName(dev.getName());
                    dto.setSalary(dev.getSalary());
                    dto.setProgrammingLanguage(dev.getProgrammingLanguage());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
