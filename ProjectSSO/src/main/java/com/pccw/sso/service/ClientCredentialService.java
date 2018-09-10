package com.pccw.sso.service;

import java.util.Set;

import com.pccw.sso.model.ClientCredential;

public interface ClientCredentialService {
	

	 public ClientCredential getClientCredentials(String clientId);
	 public Set<ClientCredential> getAllClientCredentials(String userId);
	 public void addClientCredential(ClientCredential c);
	 public void updateClientCredential(ClientCredential c);
	 public void deleteClientCredential(ClientCredential c);
}
