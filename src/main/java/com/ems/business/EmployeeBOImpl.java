package com.ems.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ems.dao.EmployeeDao;
import com.ems.model.Employee;
import com.ems.model.EmployeeLogin;
@Component
public class EmployeeBOImpl implements EmployeeBO {
	
     @Autowired
	private EmployeeDao empdao;  // inject
	
public EmployeeDao getEmpdao() {
		return empdao;
	}

	public void setEmpdao(EmployeeDao empdao) {
		this.empdao = empdao;
	}

	@Override
	public int login(EmployeeLogin empLogin) {

  // employee from data base
		
		
		Employee emp =empdao.getEmployee(empLogin.getUsername());
		if(emp==null)
		{
			return 1;
		}else if(emp.getStatus().equals("no"))
		{
			return 2;
		}
		else if(emp.getPassword().equals(empLogin.getPassword()) && emp.getStatus().equals("yes"))
		{
			return 3;
		}
		else
		{
		return 4;
		}
	}

	@Override
	public int createEmployee(Employee employee) {
        
		Employee e =empdao.getEmployee(employee.getUsername());
		if(e!=null)
		{
			return 1;
		}
		else
		{
			boolean status =empdao.saveEmplyee(employee);
			if(status)
			{
				return 2;
			}
			else
			{
				return 3;
			}
		}
		
	}

	@Override
	public boolean updateSalary(String username, double salary) {
		
		return  empdao.updateEmployee(username, salary);
	}

}
