package com.verispjdbcprg.verispjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.verispjdbcprg.verispjdbc.model.Employee;
import com.verispjdbcprg.verispjdbc.repository.EmployeeRepository;

@Repository
public class EmployeeDao implements EmployeeRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Employee> getEmployeeList() {
		String sql="select * from employee";
		List<Employee> list=jdbcTemplate
				.query(sql, 
						new BeanPropertyRowMapper(Employee.class));
		
		return list;
	}

}
