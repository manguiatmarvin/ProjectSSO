package com.pccw.sso.dao;

import com.pccw.sso.model.ClientCredential;

public interface ClientCredentialDao {

	 public ClientCredential getClientCredentials(String clientId);

}
