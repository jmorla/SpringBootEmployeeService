package com.jmorla.microservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jmorla.microservice.domain.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer>{

	Employees findByFirstName(@Param("fistName") String name);
	
	@Query("select e from Employees e join e.department")
	List<Employees> findAllWithDepartment();
}
