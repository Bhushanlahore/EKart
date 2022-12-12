/* this is Categoryrepository interface which extend jparepository
 * We use  methods of jparepository
 * */

package com.yash.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.pms.model.product.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

			
	//find category by name
	public Category findCategoryByName(String name);

}
