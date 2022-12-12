/*
 * This is the userrole model class which contains all the field of userrole class
 * it also contain getter/setter method and constructor
 * */

package com.yash.pms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userRoldId;
	 
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne
	private Role role;
	
	public UserRole() {
		
	}

	public long getUserRoldId() {
		return userRoldId;
	}

	public void setUserRoldId(long userRoldId) {
		this.userRoldId = userRoldId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}

