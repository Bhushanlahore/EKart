/*
 * This is the jwtrequest model class which contains all the field of jwtrequest class
 * it also contain getter/setter method and constructor
 * */

package com.yash.pms.model;

public class JwtRequest {
		
	String username;
	String password;
	
	
	
	public JwtRequest() {

	}



	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
