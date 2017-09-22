package com.jmorla.microservice.services.impl;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import static com.jmorla.microservice.TestConstant.*;
import com.jmorla.microservice.common.exceptions.MicroServiceException;
import com.jmorla.microservice.domain.Employees;
import com.jmorla.microservice.repositories.EmployeeRepository;
import com.jmorla.microservice.services.EmployeeService;

public class EmployeeServiceImplTest {

	private EmployeeService employeeService;
	private EmployeeRepository employeeRepository;
	
	@Before
	public void setUp(){
		employeeRepository = mock(EmployeeRepository.class);
		employeeService = new EmployeeServiceImpl(employeeRepository);
	}
	
	@Test
	public void shouldReturnEmployeeList(){
		List<Employees> result = new ArrayList();
		result.add(EMPLOYEE_1);
		result.add(EMPLOYEE_2);
		result.add(EMPLOYEE_3);
		result.add(EMPLOYEE_4);
		
		when(employeeService.findAllEmployees()).thenReturn(result);
		
		assertEquals(employeeService.findAllEmployees(),result);
	}
	
	@Test(expected=MicroServiceException.class)
	public void shouldThrowMicroServiceExcetion() throws Exception{
		Employees emp = new Employees(1,"","");
		employeeService.addEmployee(emp);
	}
	
	@Test
	public void shouldReturnUpdatedEmployee() throws Exception{
		when(employeeService.updateEmployee(EMPLOYEE_1)).thenReturn(EMPLOYEE_1);	
		assertEquals(employeeService.updateEmployee(EMPLOYEE_1), EMPLOYEE_1);
	}
	
	@Test
	public void shouldReturnEmployeeById(){
		when(employeeService.findEmployeeById(EMPLOYEE_2.getEmployeeId())).thenReturn(EMPLOYEE_2);
		assertEquals(employeeService.findEmployeeById(EMPLOYEE_2.getEmployeeId()), EMPLOYEE_2);
	}
	
	public void shouldReturnEmployeeByName(){
		when(employeeService.findEmployeeByName(EMPLOYEE_3.getFirstName())).thenReturn(EMPLOYEE_3);
		assertEquals(employeeService.findEmployeeByName(EMPLOYEE_3.getFirstName()), EMPLOYEE_3);
	}
}
