package com.pccw.sso.service;
import java.util.List;

import com.pccw.sso.model.Employee;
public interface EmployeeService {
	 public void addEmployee(Employee employee);
	 
	    public List<Employee> getAllEmployees();
	 
	    public void deleteEmployee(Integer employeeId);
	 
	    public Employee getEmployee(int employeeid);
	 
	    public Employee updateEmployee(Employee employee);
	}
