package com.ems.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ems.business.EmployeeBO;
import com.ems.model.Employee;
import com.ems.model.EmployeeLogin;
import com.sun.javafx.sg.prism.NGShape.Mode;
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeBO empBo;
	
	
	
	
	public EmployeeBO getEmpBo() {
		return empBo;
	}
	public void setEmpBo(EmployeeBO empBo) {
		this.empBo = empBo;
	}
	@RequestMapping(value="/employeelogin", method = RequestMethod.GET)
	public String getEmployeeLoginForm(Model model)
	{
		EmployeeLogin emplogin = new EmployeeLogin();
		
		model.addAttribute("emplogin", emplogin);
		return "emplogin";
	}
	@RequestMapping(value="/employeeregister",method = RequestMethod.GET)
	public String getEmployeeRegForm(Model model)
	{
		Employee emp = new Employee();
		model.addAttribute("emp", emp);
		return "empregister";
	}
	
	@RequestMapping(value="/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute("emp") Employee emp, BindingResult  result, Model model)
	{
		if(result.hasErrors())
		{
			return "empregister";
		}
		else {
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		Date date = new Date();
		emp.setDateCreated(date);
		emp.setStatus("no");
		int res = empBo.createEmployee(emp);
		String message= null;
		if(res==1)
		{
			
			message="You are already registered<a href='employeelogin'>Login here</a>";
			
			model.addAttribute("message", message);
			return "success";
		}
		else if(res==2)
		{
			message="Congrates your registration is successfull<br><a href='employeelogin'>Login here</a>";
			model.addAttribute("message", message);
			return "success";
		}
		else
		{
			message="Sorry somethig goes wrong";
			model.addAttribute("message", message);
			return "failure";
		}
		
		}
		
	}
	
	@RequestMapping(value="/elogin" , method = RequestMethod.POST)
	public String checkEmployeeLogin(@ModelAttribute("emplogin") EmployeeLogin elogin,Model model) {
		
		
		String message=null;
		
		int res =empBo.login(elogin);
		
		if(res==1)
		{
			message="You are Not yet registered<a href='employeeregister'> Register here</a>";
		
		  model.addAttribute("message", message);
		  
		  return "failure";
		}
		else if(res==2)
		{
			message="You are Not yet activated Please wait for admin confirmation<a href='index.jsp'>Home</a>";
			
			  model.addAttribute("message", message);
			  
			  return "failure";
			
		}
		else if(res==3)
		{
			 model.addAttribute("empname",elogin.getUsername());
			 return "emphome";
		}else
		{
			message="Invalid User name or password <a href='employeelogin'>Login again</a>";
			
			  model.addAttribute("message", message);
			  
			  return "failure";
		}
		
		
		
	}
	
	
	
	
}
