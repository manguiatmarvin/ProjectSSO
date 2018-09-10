package com.pccw.sso.dao;

import java.util.Set;

import com.pccw.sso.model.ClientCredential;

public interface ClientCredentialDao {

	 public ClientCredential getClientCredentials(String userId);
	 public Set<ClientCredential> getAllClientCredentialByClientId(String clientId);
	 public void saveClientCredentialByClientId(ClientCredential clientCredential);
	 public void updateClientCredentialByClientId(ClientCredential clientCredential);
	 public void deleteClientCredentialByClientId(ClientCredential clientCredential);

}
