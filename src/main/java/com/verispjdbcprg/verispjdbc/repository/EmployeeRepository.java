package com.verispjdbcprg.verispjdbc.repository;

import java.util.List;
import java.util.Map;

import com.verispjdbcprg.verispjdbc.model.Employee;

public interface EmployeeRepository {
	
	List<Employee> getEmployeeList();
	
	String insertEmployee(Employee employee);
	
	Employee getEmployeeById(Integer id);
	
	String updateEmployee(Employee employee);
	
	List<Map<String,Object>> getCombinedData();

}
