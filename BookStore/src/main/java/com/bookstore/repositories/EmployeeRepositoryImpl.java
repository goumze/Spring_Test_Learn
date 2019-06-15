package com.bookstore.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.domain.Employee;

@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository<Employee> {
	
	private JdbcOperations jdbc;

	 @Autowired
	 public EmployeeRepositoryImpl(JdbcOperations jdbc) {
	    this.jdbc = jdbc;
	  }

	@Override
	public Employee findOne(String username) {
		return jdbc.queryForObject("select user_id, email, password, first_name, last_name from USER_LOGIN where email=?", 
	        (rs,rownum)->{
	        		Employee emp=new Employee(); 	
	        		emp.setFirstName(rs.getString("first_name").trim());
	        		emp.setLastName(rs.getString("last_name").trim());
	        		emp.setUsername(rs.getString("email").trim());
	        		emp.setPassword(rs.getString("password").trim());
	        		return emp;
		  }, username);
	}

	@Override
	public void save(Employee spittle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> remove() {
		// TODO Auto-generated method stub
		return null;
	}

	
	 
	 

	
}
