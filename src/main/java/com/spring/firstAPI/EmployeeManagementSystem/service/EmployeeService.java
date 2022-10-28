package com.spring.firstAPI.EmployeeManagementSystem.service;

import java.util.List;

import com.spring.firstAPI.EmployeeManagementSystem.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}
