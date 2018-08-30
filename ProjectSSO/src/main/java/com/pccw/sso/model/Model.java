package com.pccw.sso.model;

import java.util.Date;

public class Model {
	
	String username;
	Date creted;
	Date modified;
    boolean enabled;
    
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreted() {
		return creted;
	}
	public void setCreted(Date creted) {
		this.creted = creted;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
