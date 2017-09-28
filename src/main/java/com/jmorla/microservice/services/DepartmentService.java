
package com.jmorla.microservice.services;

import com.jmorla.microservice.domain.Departments;
import java.util.List;

/**
 *
 * @author jmorla
 */
public interface DepartmentService {

    List<Departments> findAll();
}
