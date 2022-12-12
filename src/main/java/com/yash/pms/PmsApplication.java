package com.yash.pms;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.yash.pms.model.Role;
import com.yash.pms.model.User;
import com.yash.pms.model.UserRole;
import com.yash.pms.services.UserService;

@SpringBootApplication
public class PmsApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(PmsApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Application started");
		
		//to run angular project
		//npm run-script ng serve -o
		
//		User user = new User();
//		
//		user.setFirstName("Bhushan");
//		user.setLastName("Lahore");
//		user.setUsername("Bhushan111");
//		user.setPassword(this.bCryptPasswordEncoder.encode("pass"));
//		user.setEmail("bhushanlahore@gmail.com");
//		user.setPhone("8888336210");
//		
//		Role role1 = new Role();
//		role1.setRoleId(45L);
//		role1.setRoleName("ADMIN");
//		
//		 Set<UserRole> userRolesetSet = new HashSet<>();
//		
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRolesetSet.add(userRole);
//		
//		User user1 = this.userService.createUser(user, userRolesetSet);
//	System.out.println(user1.getUsername());
	}

}
