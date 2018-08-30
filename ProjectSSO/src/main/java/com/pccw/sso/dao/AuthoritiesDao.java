package com.pccw.sso.dao;

import java.math.BigInteger;

import com.pccw.sso.model.Authorities;

public interface AuthoritiesDao {
	public void addAuthority(Authorities auth);
	public void deleteAuthority(BigInteger auth_id);
	public void updateAuthority(Authorities auth);
	public Authorities getAuthorities(BigInteger autority_id);
	
}
