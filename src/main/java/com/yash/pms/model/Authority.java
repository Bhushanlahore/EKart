/*
 * This is the Authority model class which contains all the field of Authority class
 * it also contain getter/setter method and constructor
 * */

package com.yash.pms.model;

import org.springframework.security.core.GrantedAuthority;


public class Authority implements GrantedAuthority{

	
	private String authority;
	
	public Authority(String authority) {
		this.authority = authority;
	}
	
	//return user authority whether its is admin or normal user
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}
			
	
}
