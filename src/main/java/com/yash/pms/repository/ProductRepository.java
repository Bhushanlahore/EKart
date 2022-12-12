/* this is productrepository interface which extend jparepository
 * We use  methods of jparepository
 * */

package com.yash.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.pms.model.product.Category;
import com.yash.pms.model.product.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

	//find Product by name
	public Product findProductByName(String name);
	
	//find product by category
	public List<Product> findByCategory(Category category);
}
