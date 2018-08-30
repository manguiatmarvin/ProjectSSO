package com.pccw.sso.service;

import java.math.BigInteger;

import com.pccw.sso.model.Authorities;

public interface AutoritiesService {
	
	 public Authorities getAutoritiesById(BigInteger authority_id);
	 public void saveAuthorities(Authorities auth);
	 public void removeAuthories(BigInteger authority_id);
     public void updateAuthorities(Authorities auth);

}