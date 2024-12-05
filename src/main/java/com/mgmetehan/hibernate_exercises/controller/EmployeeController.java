package com.mgmetehan.hibernate_exercises.controller;

import com.mgmetehan.hibernate_exercises.dto.DeveloperDTO;
import com.mgmetehan.hibernate_exercises.dto.EmployeeDTO;
import com.mgmetehan.hibernate_exercises.dto.ManagerDTO;
import com.mgmetehan.hibernate_exercises.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
        return employeeDTO;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/managers")
    public List<ManagerDTO> getAllManagers() {
        return employeeService.getAllManagers();
    }
}
