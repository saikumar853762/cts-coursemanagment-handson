package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ems.dao.EmployeeDao;
import com.ems.model.AdminLogin;
import com.ems.model.Employee;

@Controller
@SessionAttributes(names = "admin")
public class AdminController {
	@Autowired
	private EmployeeDao dao;
	
	
	public EmployeeDao getDao() {
		return dao;
	}

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value="adminlogin",method = RequestMethod.GET)
	public String getAdminLoginForm(Model model)
	{
		model.addAttribute("adminlogin", new AdminLogin());
		return "adminlogin";
		
	}

	
	@RequestMapping(value="alogin", method = RequestMethod.POST)
	
	public String adminLoginCheck(@ModelAttribute("adminlogin") AdminLogin alogin,Model model)
	{
		
		if(alogin.getUsername().equals("krishna") && alogin.getPassword().equals("krishna"))
		{
			model.addAttribute("admin",alogin.getUsername());
			return "adminhome";
		}
		
		
		else
		{
			model.addAttribute("message","Invalid User name or Password <a href='adminlogin'>Login again</a>");
		return "failure";
		}
	}
	@RequestMapping(value="/listEmployee",method = RequestMethod.GET)
	public String showEmployees(Model model)
	{
		List<Employee> employeeList= dao.getEmployees();
		
		model.addAttribute("empList", employeeList);
		return "adminhome";
	}
	
	
}
