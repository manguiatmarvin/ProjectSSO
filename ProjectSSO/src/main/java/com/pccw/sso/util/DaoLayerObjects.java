package com.pccw.sso.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pccw.sso.dao.AuthoritiesDao;
import com.pccw.sso.dao.ClientCredentialDao;
import com.pccw.sso.dao.EmployeeDAO;
import com.pccw.sso.dao.UserDetailsDao;

/**
 * 
 * ProjectSSO 
 * @author Marvin Manguiat
 * @created 31 Aug 2018
 *
 */

@Service
public class DaoLayerObjects {
	
	/**
	 * Dao Layer Objects 
	 */
	@Autowired
	public AuthoritiesDao authoritiesDao;
	
	@Autowired
	public ClientCredentialDao clientCredentialDao;
	
	@Autowired 
	public EmployeeDAO employeeDAO;
	
	@Autowired 
    public UserDetailsDao userDetailsDao;

}
