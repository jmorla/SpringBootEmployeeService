package com.jmorla.microservice.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jmorla.microservice.common.exceptions.MicroServiceException;
import com.jmorla.microservice.domain.Employees;
import com.jmorla.microservice.services.EmployeeService;

@RestController
@RequestMapping("/rest/employees/")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employees> list(){
		return employeeService.findAllEmployees();
	}
	
	@RequestMapping(value="/id/{id}", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Employees findById(@PathVariable("id")Integer id){
		return employeeService.findEmployeeById(id);
	}
	
	@RequestMapping(value="/name/{name}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Employees findByFirstName(@PathVariable("name") String name){
		return employeeService.findEmployeeByName(name);
	}
	
	@RequestMapping(value="/add/",
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Employees addEmployee(@RequestBody Employees employees) throws MicroServiceException{
		try{
			return employeeService.addEmployee(employees);
		}catch (Exception e) {
			throw new MicroServiceException(e.getMessage());
		}
	}
	
	@RequestMapping(value="/update/",
			method=RequestMethod.PUT,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Employees updateEmployee(@RequestBody Employees employees) throws MicroServiceException{
		try{
			return employeeService.updateEmployee(employees);
		}catch (Exception e) {
			throw new MicroServiceException(e.getMessage());
		}
	}

}
