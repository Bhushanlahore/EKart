/* this is rolerepository interface which extend jparepository
 * We use  methods of jparepository
 * */

package com.yash.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.pms.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
