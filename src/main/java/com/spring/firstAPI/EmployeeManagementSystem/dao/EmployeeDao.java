package com.spring.firstAPI.EmployeeManagementSystem.dao;

import java.util.List;

import com.spring.firstAPI.EmployeeManagementSystem.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}
