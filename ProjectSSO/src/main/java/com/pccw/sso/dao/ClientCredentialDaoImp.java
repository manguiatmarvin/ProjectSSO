package com.pccw.sso.dao;

import java.util.Set;

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
		 Query query = ses.createQuery("FROM ClientCredential WHERE clientId = :client_id ORDER BY Created");
		 query.setParameter("client_id", clientId);
		 try {
			 cred = (ClientCredential)query.getSingleResult();
		 }catch(NoResultException nr) {
			 System.out.println(nr.getMessage());
		 }
		 
		return cred;
	}


	@Override
	public Set<ClientCredential> getAllClientCredentialByClientId(String userId) {
		// TODO Auto-generated method stub
		Session ses = sessionFactory.getCurrentSession();
		Set<ClientCredential> credList = null;
		 Query query = ses.createQuery("FROM ClientCredential WHERE userId = :userId");
		 query.setParameter("user_id", userId);
		 try {
			 credList = (Set<ClientCredential>)query.getResultList();
		 }catch(NoResultException nr) {
			 System.out.println(nr.getMessage());
		 }
		 
		return credList;
	}


	@Override
	public void saveClientCredentialByClientId(ClientCredential clientCredential) {
		sessionFactory.getCurrentSession().save(clientCredential);
		
	}


	@Override
	public void updateClientCredentialByClientId(ClientCredential clientCredential) {
		sessionFactory.getCurrentSession().update(clientCredential);
		
	}


	@Override
	public void deleteClientCredentialByClientId(ClientCredential clientCredential) {
		sessionFactory.getCurrentSession().delete(clientCredential);
		
	}

}
