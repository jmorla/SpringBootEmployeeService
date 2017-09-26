
package com.jmorla.microservice.controllers;

import com.jmorla.microservice.domain.Departments;
import com.jmorla.microservice.domain.Employees;
import com.jmorla.microservice.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jmorla
 */
@Controller
@RequestMapping("/add_employee.do")
public class AddEmployeeController {
    
    @Autowired private DepartmentService departmentService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String addEmployee(Model model){
        Employees employees  = new Employees();
        employees.setDepartments(new Departments());
        
        model.addAttribute("employee",employees);
        model.addAttribute("departments", departmentService.findAll());
        
        return "addEmployee";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String saveEmployee(Employees emp, Model model){
        model.addAttribute("employee",emp);
        
        return "addEmployee";
    }
}
