package com.yash.pms.services;

import java.util.Set;

import com.yash.pms.exception.UserFoundException;
import com.yash.pms.model.User;
import com.yash.pms.model.UserRole;

public interface UserService {
			
	//create user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	//get user by username
	public User getUser(String username);
	
	//delete user by id
	public void deleteUser(Long id);
	
	//update user by id
	public void updateUser(User user, Long id);
	
	
}
