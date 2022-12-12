/*This is  categorycontroller class. from this class we navigate to many methods
 * that perform category operations.
 * its has various mapping like getmapping, putmapping, deletemapping to perform operations
 * on category*/

package com.yash.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pms.model.product.Category;
import com.yash.pms.services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	//add category
	@PostMapping("/")
	public ResponseEntity<Category>addCategory(@RequestBody Category category) throws Exception{
	 Category category1 =this.categoryService.addCategory(category);
	 return ResponseEntity.ok(category1);
	} 
	
	//get category
	@GetMapping("/{cid}")
	public Category getCategory(@PathVariable("cid") Long cid) {
		
		return this.categoryService.getCategory(cid);
	}
	
	//get all categories
	@GetMapping("/")
	public ResponseEntity<?> getCategories(){
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	//update category
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		return this.categoryService.updateCategory(category);
	}
	
	//delete category
	@DeleteMapping("/{cid}")
	public void deleteCategory(@PathVariable("cid") Long cid) {
		this.categoryService.deleteCategory(cid);
	}
}
