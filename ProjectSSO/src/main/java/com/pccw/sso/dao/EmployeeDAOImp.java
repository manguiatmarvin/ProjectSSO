package com.pccw.sso.dao;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.pccw.sso.model.Authorities;
import com.pccw.sso.model.Employee;
import com.pccw.sso.model.User;


@Repository
public class EmployeeDAOImp implements EmployeeDAO {
 
	   @Autowired 
	   private  SessionFactory sssionFactory;
 
    public void addEmployee(Employee employee) {
    	sssionFactory.getCurrentSession().saveOrUpdate(employee);
    }
 
    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {
 
        return sssionFactory.getCurrentSession().createQuery("from Employee")
                .list();
    }
 
    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = (Employee) sssionFactory.getCurrentSession().load(
                Employee.class, employeeId);
        if (null != employee) {
        	sssionFactory.getCurrentSession().delete(employee);
        }
 
    }
 
    public Employee getEmployee(int empid) {
        return (Employee) sssionFactory.getCurrentSession().getSession().get(
                Employee.class, empid);
    }
 
    @Override
    public Employee updateEmployee(Employee employee) {
    	sssionFactory.getCurrentSession().update(employee);
        return employee;
    }
 
}