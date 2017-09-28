package com.jmorla.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jmorla.microservice.domain.Departments;

public interface DepartmentRepository extends JpaRepository<Departments, Integer>{

}
