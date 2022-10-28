package com.spring.firstAPI.EmployeeManagementSystem.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.firstAPI.EmployeeManagementSystem.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao{

	//inject Entity manager
	@Autowired
	public EntityManager entityManager;
	
	
	@Override
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee", Employee.class);
		
		return theQuery.getResultList();
	}

	@Override
	public Employee findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee theEmployee = currentSession.get(Employee.class, id);
		
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery =
				currentSession.createQuery("delete from Employee where id = :employeeId");
		theQuery.setParameter("employeeId", id);
		theQuery.executeUpdate();
	}

	
}
