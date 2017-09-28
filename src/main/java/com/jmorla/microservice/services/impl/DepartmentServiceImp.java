
package com.jmorla.microservice.services.impl;

import com.jmorla.microservice.domain.Departments;
import com.jmorla.microservice.repositories.DepartmentRepository;
import com.jmorla.microservice.services.DepartmentService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmorla
 */
@Service
public class DepartmentServiceImp implements DepartmentService{

    private DepartmentRepository departmentRepository;
    
    public DepartmentServiceImp(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }
    
    @Override
    public List<Departments> findAll() {
        return this.departmentRepository.findAll();
    }
    
}
