/*this is userservice implementation class which implements userservice
 * we write our actual logic in this class
 * */

package com.yash.pms.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.pms.exception.UserFoundException;
import com.yash.pms.model.User;
import com.yash.pms.model.UserRole;
import com.yash.pms.repository.RoleRepository;
import com.yash.pms.repository.UserRepository;
import com.yash.pms.services.UserService;

import antlr.collections.List;

@Service
public class UserServiceImpl implements UserService{

	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	//create user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		User localUser =this.userRepository.findByUsername(user.getUsername());
		
		//if username present
		if(localUser != null) {
			System.out.println("User Already Present!!");
			throw new UserFoundException();
		}
		else {
			//create user
			//save user roles
			for(UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			localUser = this.userRepository.save(user);
		}
		return localUser;
	}

	
	//getting user by username
	@Override
	public User getUser(String username) {
		
		return this.userRepository.findByUsername(username);
	}

	
	//delete user by user od
	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		 this.userRepository.deleteById(id);
	}

	//update user
	@Override
	public void updateUser(User user, Long id) {
		// TODO Auto-generated method stub
		this.userRepository.save(user);
	}



	




}
