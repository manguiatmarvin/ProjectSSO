package com.pccw.sso.dao;

import java.util.List;

import com.pccw.sso.model.Employee;

 
public interface EmployeeDAO {
 
    public void addEmployee(Employee employee);
 
    public List<Employee> getAllEmployees();
 
    public void deleteEmployee(Integer employeeId);
 
    public Employee updateEmployee(Employee employee);
 
    public Employee getEmployee(int employeeid);
}