package com.mgmetehan.hibernate_exercises.service;

import com.mgmetehan.hibernate_exercises.dto.DeveloperDTO;
import com.mgmetehan.hibernate_exercises.dto.EmployeeDTO;
import com.mgmetehan.hibernate_exercises.dto.ManagerDTO;
import com.mgmetehan.hibernate_exercises.model.inheritance.single.Developer;
import com.mgmetehan.hibernate_exercises.model.inheritance.single.Employee;
import com.mgmetehan.hibernate_exercises.model.inheritance.single.Manager;
import com.mgmetehan.hibernate_exercises.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = null;
        switch (employeeDTO.getType().toUpperCase()) {
            case "DEVELOPER":
                DeveloperDTO developerDTO = (DeveloperDTO) employeeDTO;
                employee = Developer.builder()
                        .name(developerDTO.getName())
                        .salary(developerDTO.getSalary())
                        .programmingLanguage(developerDTO.getProgrammingLanguage())
                        .build();
                break;

            case "MANAGER":
                ManagerDTO managerDTO = (ManagerDTO) employeeDTO;
                employee = Manager.builder()
                        .name(managerDTO.getName())
                        .salary(managerDTO.getSalary())
                        .teamSize(managerDTO.getTeamSize())
                        .build();
                break;
        }

        return employeeRepository.save(employee);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(emp -> {
                    EmployeeDTO dto = new EmployeeDTO();
                    dto.setName(emp.getName());
                    dto.setSalary(emp.getSalary());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<ManagerDTO> getAllManagers() {
        return employeeRepository.findAll().stream()
                .filter(emp -> emp instanceof Manager)
                .map(emp -> {
                    Manager dev = (Manager) emp;
                    ManagerDTO dto = new ManagerDTO();
                    dto.setName(dev.getName());
                    dto.setSalary(dev.getSalary());
                    dto.setTeamSize(dev.getTeamSize());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
