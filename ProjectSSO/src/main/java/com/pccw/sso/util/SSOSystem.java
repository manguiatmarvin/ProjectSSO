package com.pccw.sso.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pccw.sso.dao.AuthoritiesDao;
import com.pccw.sso.dao.ClientCredentialDao;
import com.pccw.sso.dao.EmployeeDAO;
import com.pccw.sso.dao.UserDetailsDao;
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
public class SSOSystem {

  
     
     public static BCryptPasswordEncoder getPasswordEncoder() {
    	 return  new BCryptPasswordEncoder();
     }

}
