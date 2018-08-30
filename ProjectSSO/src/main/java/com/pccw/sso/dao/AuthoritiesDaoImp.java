package com.pccw.sso.dao;

import java.math.BigInteger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pccw.sso.model.Authorities;


@Repository
public class AuthoritiesDaoImp implements AuthoritiesDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addAuthority(Authorities auth) {
		
		Authorities authority = auth;
		sessionFactory.getCurrentSession().save(auth);
		
	}

	@Override
	public void deleteAuthority(BigInteger auth_id) {
		//utilsService.getActiveHibernateSession().delete(arg0);
		
	}

	@Override
	public void updateAuthority(Authorities auth) {
		sessionFactory.getCurrentSession().update(auth);
		
	}

	@Override
	public Authorities getAuthorities(BigInteger autority_id) {
		// TODO Auto-generated method stub
		return (Authorities) sessionFactory.getCurrentSession().get(Authorities.class, autority_id);
	}

}
