package com.jmorla.microservice.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jmorla.microservice.common.exceptions.InvalidEmployeeException;
import com.jmorla.microservice.common.exceptions.MicroServiceException;
import com.jmorla.microservice.domain.Employees;
import com.jmorla.microservice.repositories.EmployeeRepository;
import com.jmorla.microservice.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	@Transactional(rollbackOn={InvalidEmployeeException.class})
	public Employees addEmployee(Employees emp) throws InvalidEmployeeException{
		
		Employees result = employeeRepository.findOne(emp.getEmployeeId());
		
		if(result != null){
			throw new InvalidEmployeeException("Employee con id existente");
		}
		if(emp.getFirstName().length()<5 || emp.getLastName().length()<5){
			throw new InvalidEmployeeException("Nombre y apellido no valido");
		}
		
		return employeeRepository.save(emp);
		
	}

	@Override
	@Transactional(rollbackOn={InvalidEmployeeException.class})
	public Employees updateEmployee(Employees emp) throws InvalidEmployeeException {
		if(emp.getFirstName().length()<5 || emp.getLastName().length()<5){
			throw new InvalidEmployeeException("Nombre y apellido no valido");
		}
		
		return employeeRepository.save(emp);
	}

	@Override
	@Transactional
	public List<Employees> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employees findEmployeeById(Integer id) {
		return employeeRepository.findOne(id);
	}

	@Override
	@Transactional
	public Employees findEmployeeByName(String name) {
		return employeeRepository.findByFirstName(name);
	}

	
}
