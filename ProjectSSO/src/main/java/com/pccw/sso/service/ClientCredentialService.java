package com.pccw.sso.service;

import com.pccw.sso.model.ClientCredential;

public interface ClientCredentialService {
	

	 public ClientCredential getClientCredentials(String clientId);
}
