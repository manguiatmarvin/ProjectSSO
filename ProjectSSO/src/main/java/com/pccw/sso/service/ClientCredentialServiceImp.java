package com.pccw.sso.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pccw.sso.dao.ClientCredentialDao;
import com.pccw.sso.model.ClientCredential;

/**
 * 
 * ProjectSSO 
 * @author Marvin Manguiat
 * @created 28 Aug 2018
 *
 */

@Service
public class ClientCredentialServiceImp implements ClientCredentialService {

	@Autowired
	private ClientCredentialDao clientCredentialDao;
	
	@Override
	@Transactional
	public ClientCredential getClientCredentials(String userId) {
		// TODO Auto-generated method stub
		return clientCredentialDao.getClientCredentials(userId);
	}

	@Override
	public Set<ClientCredential> getAllClientCredentials(String clientId) {
		// TODO Auto-generated method stub
		return clientCredentialDao.getAllClientCredentialByClientId(clientId);
	}

	@Override
	public void addClientCredential(ClientCredential c) {
		clientCredentialDao.saveClientCredentialByClientId(c);
		
	}

	@Override
	public void updateClientCredential(ClientCredential c) {
		clientCredentialDao.updateClientCredentialByClientId(c);
		
	}

	@Override
	public void deleteClientCredential(ClientCredential c) {
		clientCredentialDao.deleteClientCredentialByClientId(c);
		
	}

	
	

}
