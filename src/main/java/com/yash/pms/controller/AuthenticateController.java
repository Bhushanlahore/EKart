/*
 * this controller is for authentication
 * it generate the token and give authentication to user according its role*/

package com.yash.pms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pms.config.JwtUtils;
import com.yash.pms.exception.UserNotFoundException;
import com.yash.pms.model.JwtRequest;
import com.yash.pms.model.JwtResponse;
import com.yash.pms.model.User;
import com.yash.pms.services.impl.UserServiceDetailsImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserServiceDetailsImpl userServiceDetailsImpl;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	//generate token
	
		@PostMapping("/generate-token")
		public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
			try {
				
				authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
				
			}
			catch (UserNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new Exception("User Not Found");
			}
			
			
			//user  is authenticated
			
			UserDetails userDetails = this.userServiceDetailsImpl.loadUserByUsername(jwtRequest.getUsername());
			 String token= this.jwtUtils.generateToken(userDetails);
			 return ResponseEntity.ok(new JwtResponse(token));
		}
	
	
	private void authenticate(String username, String password) throws Exception {
		
		try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch (DisabledException e) {
			// TODO: handle exception
			throw new Exception("USER Disabled"+ e.getMessage());
		}catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("Invalid Credentials"+ e.getMessage());
		}
	}
	

	//current user details 
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User)this.userServiceDetailsImpl.loadUserByUsername(principal.getName()));
	}
}
