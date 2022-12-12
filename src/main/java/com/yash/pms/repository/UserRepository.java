/* this is userrepository interface which extend jparepository
 * We use  methods of jparepository
 * */

package com.yash.pms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.pms.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	//find user by username
	public User findByUsername(String username);
	
	
	
	

}
