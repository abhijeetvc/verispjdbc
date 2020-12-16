package com.verispjdbcprg.verispjdbc.repository;

import java.util.List;

import com.verispjdbcprg.verispjdbc.model.Employee;

public interface EmployeeRepository {
	
	List<Employee> getEmployeeList();

}
