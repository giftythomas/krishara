package com.freestyle.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoleAuthority {

	@Id
	
	private int user_id;
	
	private String authority;
	public int getId() {
		return user_id;
	}
	public void setId(int user_id) {
		this.user_id = user_id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
