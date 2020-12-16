package com.verispjdbcprg.verispjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verispjdbcprg.verispjdbc.dao.EmployeeDao;
import com.verispjdbcprg.verispjdbc.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping("/getemployeedata")
	public List<Employee> getEmployeeData(){
		return employeeDao.getEmployeeList();
	}
}
