/*
 * This is the jwtresponse model class which contains all the field of jwtresponse class
 * it also contain getter/setter method and constructor
 * */

package com.yash.pms.model;

public class JwtResponse {
	
	String token;

	
	
	public JwtResponse() {
	}



	public JwtResponse(String token) {
		super();
		this.token = token;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}
	
	
}
