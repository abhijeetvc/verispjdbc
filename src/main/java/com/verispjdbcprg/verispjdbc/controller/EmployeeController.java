package com.verispjdbcprg.verispjdbc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/save")
	public String saveEMployee(@RequestBody Employee employee) {
		return employeeDao.insertEmployee(employee);
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		return employeeDao.getEmployeeById(id);
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {
		return employeeDao.updateEmployee(employee);
	}
	
	@GetMapping("/getjoindata")
	public List<Map<String,Object>> getJoinData(){
		return employeeDao.getCombinedData();
	}
}
