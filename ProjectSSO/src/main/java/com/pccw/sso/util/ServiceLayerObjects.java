package com.pccw.sso.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pccw.sso.service.AutoritiesService;
import com.pccw.sso.service.ClientCredentialService;
import com.pccw.sso.service.EmployeeService;
import com.pccw.sso.service.UserService;

/**
 * 
 * ProjectSSO 
 * @author Marvin Manguiat
 * @created 31 Aug 2018
 *
 */

@Service
public class ServiceLayerObjects {
 
	
	/**
	 * Service Layer Objects 
	 */
	@Autowired 
	public UserService userService;
	
	@Autowired
	public AutoritiesService autoritiesService;
	
	@Autowired 
	public ClientCredentialService clientCredentialService;
	
	@Autowired 
	public EmployeeService employeeService;
	
	
	
}
