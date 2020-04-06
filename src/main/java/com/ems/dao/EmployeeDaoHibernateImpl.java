package com.ems.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ems.model.Employee;


@Component
public class EmployeeDaoHibernateImpl implements EmployeeDao {
     @Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Employee getEmployee(String username) {


		/*
		 * Configuration cfg = new Configuration(); cfg.configure("hibernate.cfg.xml");
		 * 
		 * SessionFactory sessionFactory= cfg.buildSessionFactory();
		 * 
		 * Session session = sessionFactory.openSession();
		 */
		
		Employee emp = hibernateTemplate.get(Employee.class, username);
		
		
		return emp;
	}
     @Transactional
	@Override
	public boolean saveEmplyee(Employee employee) {

        // SessionFactory // Session  // Transaction
		
		/*
		 * Configuration cfg = new Configuration(); cfg.configure("hibernate.cfg.xml");
		 * 
		 * SessionFactory sessionFactory= cfg.buildSessionFactory();
		 * 
		 * Session session = sessionFactory.openSession();
		 * 
		 * Transaction tx = session.beginTransaction();
		 */
		
		

		String username =(String) hibernateTemplate.save(employee);  // commit jdbc autocommit - true

		if(username!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> getEmployees() {



		  
		/*
		 * List l = hibernateTemplate.getSessionFactory().getCurrentSession().
		 * createQuery("from employee").list();
		 * 
		 * List<Employee> empList=new ArrayList<Employee>();
		 * 
		 * for(Object o:l) { Employee e = (Employee) o; empList.add(e);
		 * 
		 * 
		 * } return empList;
		 */
		
		  return hibernateTemplate.execute(new HibernateCallback<List<Employee>>() {
		  
		  @Override public List<Employee> doInHibernate(Session session) throws
		  HibernateException {
		  
		  
		  return session.createQuery("from Employee").list() ; } });
		 

		
	
	}
@Transactional
	@Override
	public boolean updateEmployee(String username, double salary) {
		Employee emp =  hibernateTemplate.get(Employee.class, username);
		emp.setSalary(salary);
		hibernateTemplate.update(emp);
		Employee emp1 =  hibernateTemplate.get(Employee.class, username);
		if(emp1.getSalary()==salary)
		{
			return true;
		}
		return false;
	}

}
