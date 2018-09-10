package com.pccw.sso.service;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pccw.sso.dao.AuthoritiesDao;
import com.pccw.sso.dao.UserDetailsDao;
import com.pccw.sso.model.Authorities;
import com.pccw.sso.model.User;



@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired 
	private UserDetailsDao userDetailsDao;
	  
	@Override
	public void addNewUser(User user) {
		userDetailsDao.addUser(user);
	}

	@Override
	public void deleteUSer(BigInteger userId) {
		userDetailsDao.deleteUser(userId);
		
	}

	@Override
	public void updateUser(User user) {
		userDetailsDao.updateUser(user);
	}

	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userDetailsDao.findUserByUsername(username);
	}




}
