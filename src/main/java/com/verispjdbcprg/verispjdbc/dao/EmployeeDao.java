package com.verispjdbcprg.verispjdbc.dao;

import java.sql.Types;
import java.util.List;
import java.util.Map;

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

	@Override
	public String insertEmployee(Employee employee) {
		String sql="insert into employee values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {
				employee.getId(),
				employee.getName(),
				employee.getCity(),
				employee.getDepartment().getId()},new int[] {Types.INTEGER,Types.VARCHAR,
						Types.VARCHAR,
						Types.INTEGER});
		return "Employee saved";
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		 String sql="select * from employee where id=?";
		 Employee emp= (Employee) jdbcTemplate.queryForObject(sql, 
				 new Object[] {id},new int[] {Types.INTEGER},new BeanPropertyRowMapper(Employee.class));
		return emp;
	}

	@Override
	public String updateEmployee(Employee employee) {
		String sql="update employee set name=?, city=? where id=?";
		jdbcTemplate.update(sql, new Object[] {
				employee.getName(),
				employee.getCity(),
				employee.getId()});
		return "Employee Updated";
	}

	@Override
	public List<Map<String, Object>> getCombinedData() {
		String sql="select e.id,e.name,e.city,d.name as deptName from employee e,department d where e.dept_id=d.id";
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}

}
