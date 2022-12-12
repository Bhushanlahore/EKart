/*this is categoryservice implementation class which implements categoryservice
 * we write our actual logic in this class
 * */

package com.yash.pms.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.pms.exception.CategoryFoundException;
import com.yash.pms.model.product.Category;
import com.yash.pms.repository.CategoryRepository;
import com.yash.pms.services.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	//add categories 
	//no duplicate categories
	@Override
	public Category addCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		Category localCategory = this.categoryRepository.findCategoryByName(category.getName());
		
		if(localCategory != null) {
			
			System.out.println("Category Already Present");
			throw new CategoryFoundException();
		}else {
			
			localCategory = this.categoryRepository.save(category);
		}
		return localCategory;
	}

	
	//update categories
	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return	this.categoryRepository.save(category);
	}

	
	//get all categories
	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return  new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	
	//get category by id
	@Override
	public Category getCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(categoryId).get();
	}

	
	//delete category by id
	@Override
	public void deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		this.categoryRepository.deleteById(categoryId);
		
	}

	
}
