package com.jmorla.microservice.services;

import java.util.List;

import com.jmorla.microservice.common.exceptions.InvalidEmployeeException;
import com.jmorla.microservice.domain.Employees;

public interface EmployeeService {

	public Employees addEmployee(Employees emp) throws InvalidEmployeeException;
	
	public Employees updateEmployee(Employees emp) throws InvalidEmployeeException;
	
	public List<Employees> findAllEmployees();
	
	public Employees findEmployeeById(Integer id);
	
	public Employees findEmployeeByName(String name);
	
	public List<Employees> addEmployeeList(List<Employees> empl) throws InvalidEmployeeException;
}
