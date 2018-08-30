package com.pccw.sso.service;

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
	public ClientCredential getClientCredentials(String clientId) {
		// TODO Auto-generated method stub
		return clientCredentialDao.getClientCredentials(clientId);
	}

	
	

}
