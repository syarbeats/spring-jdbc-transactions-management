package com.learning.spring.spring_transaction_management.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public abstract class AddEmployeeTransManagementDao extends JdbcDaoSupport implements EmployeeManagement{
	
	public void addEmployee(int id, String name, int salary) {
		getJdbcTemplate().update("Insert into Employee(id, name, salary) values(?,?,?)", id, name, salary); 
	}
}
