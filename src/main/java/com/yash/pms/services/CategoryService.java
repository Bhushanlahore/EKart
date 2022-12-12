/* this is Categoryservice interface which contains methods that we use for operations
 * categoryserviceimpl class implemetns this categoryservice
 * */

package com.yash.pms.services;

import java.util.List;
import java.util.Set;

import com.yash.pms.model.product.Category;

public interface CategoryService {

	//add category
	public Category addCategory(Category category) throws Exception;
	
	//update category
	public Category updateCategory(Category category);
	
	//get all categories
	public Set<Category> getCategories();
	
	//get a single category by id
	public Category getCategory(Long categoryId);
	
	//delete category by id
	public void deleteCategory(Long categoryId);
}
