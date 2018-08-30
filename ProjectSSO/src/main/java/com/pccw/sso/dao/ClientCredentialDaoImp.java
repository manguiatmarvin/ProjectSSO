package com.pccw.sso.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pccw.sso.model.ClientCredential;


@Repository
public class ClientCredentialDaoImp implements ClientCredentialDao {
	
    @Autowired 
   private  SessionFactory sessionFactory;
	
	
	@Override
	public ClientCredential getClientCredentials(String clientId) {
		// TODO Auto-generated method stub
		Session ses = sessionFactory.getCurrentSession();
		ClientCredential cred = null;
		 Query query = ses.createQuery("FROM ClientCredential WHERE clientId = :client_id");
		 query.setParameter("client_id", clientId);
		 try {
			 cred = (ClientCredential)query.getSingleResult();
		 }catch(NoResultException nr) {
			 System.out.println(nr.getMessage());
		 }
		 
		return cred;
	}

}
