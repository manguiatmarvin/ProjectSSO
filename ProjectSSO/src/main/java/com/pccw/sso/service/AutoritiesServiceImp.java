package com.pccw.sso.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pccw.sso.dao.AuthoritiesDao;
import com.pccw.sso.model.Authorities;

@Service
public class AutoritiesServiceImp implements AutoritiesService {
	
	
	@Autowired
	private AuthoritiesDao authoritiesDao;

	@Override
	public Authorities getAutoritiesById(BigInteger authority_id) {
		// TODO Auto-generated method stub
		return authoritiesDao.getAuthorities(authority_id);
	}

	@Override
	public void saveAuthorities(Authorities auth) {
		authoritiesDao.addAuthority(auth);
		
	}

	@Override
	public void removeAuthories(BigInteger authority_id) {
		authoritiesDao.deleteAuthority(authority_id);
		
	}

	@Override
	public void updateAuthorities(Authorities auth) {
		authoritiesDao.updateAuthority(auth);
		
	}

}
