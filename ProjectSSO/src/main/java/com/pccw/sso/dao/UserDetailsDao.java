package com.pccw.sso.dao;

import java.math.BigInteger;

import com.pccw.sso.model.User;

public interface UserDetailsDao {
	  User findUserByUsername(String username);
      void addUser(User user);
      void deleteUser(BigInteger userId);
      void updateUser(User user);
      

	}