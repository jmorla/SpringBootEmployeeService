package com.jmorla.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.jmorla.microservice.domain.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer>{

	Employees findByFirstName(@Param("fistName") String name);
}
