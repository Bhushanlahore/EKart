/*this is userservicedetails implementation class which implements userservicedetails
 * we write our actual logic in this class
 * */

package com.yash.pms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yash.pms.model.User;
import com.yash.pms.repository.UserRepository;

@Service
public class UserServiceDetailsImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	//get user details
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userRepository.findByUsername(username);
		if(user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username Not Found"); 
		}
		return user;
	}

}
