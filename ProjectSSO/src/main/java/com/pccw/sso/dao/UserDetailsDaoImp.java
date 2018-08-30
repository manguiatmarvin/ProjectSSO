package com.pccw.sso.dao;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pccw.sso.model.Authorities;
import com.pccw.sso.model.User;



@Repository
public class UserDetailsDaoImp implements UserDetailsDao {
	
	   @Autowired 
	   private  SessionFactory sssionFactory;
	  
	@Transactional
	@Override
	public User findUserByUsername(String username) {
		BigInteger userId = null;
		Session session = sssionFactory.getCurrentSession();
		
		Query query = session.createQuery("SELECT e.id FROM User e WHERE e.username=:username");
		query.setParameter("username", username);
		userId = (BigInteger) query.uniqueResult();
		if (userId != null) {
			return session.get(User.class, userId);
		}
		return null;
	}

	
	@Transactional
    @Override
	public void addUser(User user) {
    	System.out.println("Adding new user "+user.getUsername());
    	   Authorities au = new Authorities();
		   au.setAuthority("ROLE_ADMIN");
		   au.setUser(user);
		   au.setAuthorityId(null);
		   Set<Authorities> authList = new HashSet<>();
		   authList.add(au);
		   user.setAuthorities(authList); 
		   sssionFactory.getCurrentSession().save(user);
		
	}

	@Transactional
	@Override
	public void deleteUser(BigInteger userId) {
		 sssionFactory.getCurrentSession().delete(String.valueOf(userId),User.class);
		
	}

	@Transactional
	@Override
	public void updateUser(User user) {
		 sssionFactory.getCurrentSession().update(user);
		
	}
	

}