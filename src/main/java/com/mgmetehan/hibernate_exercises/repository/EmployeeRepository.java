package com.mgmetehan.hibernate_exercises.repository;

import com.mgmetehan.hibernate_exercises.model.inheritance.single.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
