package com.pccw.sso.service;

import java.math.BigInteger;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pccw.sso.model.User;

public interface UserService extends UserDetailsService{
	
	public void addNewUser(User user);
	public void deleteUSer(BigInteger userId);
	public void updateUser(User user);
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	public User getUser(String username) throws UsernameNotFoundException;
	

}
