package com.jmorla.microservice;

import com.jmorla.microservice.domain.Employees;

public class TestConstant {

	public static final Employees EMPLOYEE_1;
	public static final Employees EMPLOYEE_2;
	public static final Employees EMPLOYEE_3;
	public static final Employees EMPLOYEE_4;
	
	static{
		EMPLOYEE_1 = new Employees(1,"Jorge","Morla");
		EMPLOYEE_2 = new Employees(2,"Jefrey","Matos");
		EMPLOYEE_3 = new Employees(3,"Bill","Gates");
		EMPLOYEE_4 = new Employees(4,"Mark","Zuckerberg");
	}
	
}
