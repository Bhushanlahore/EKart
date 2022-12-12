/*This is  productcontroller class. from this class we navigate to many methods
 * that perform product operations.
 * its has various mapping like getmapping, putmapping, deletemapping to perform operations
 * on product*/



package com.yash.pms.controller;

import java.util.List;

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
import com.yash.pms.model.product.Product;
import com.yash.pms.services.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	//add product
	@PostMapping("/")
	public ResponseEntity<Product> add(@RequestBody Product product) throws Exception{
		
		return ResponseEntity.ok(this.productService.addProduct(product));
	}

	//update product
	@PutMapping("/")
	public ResponseEntity<Product> update(@RequestBody Product product){
		return ResponseEntity.ok(this.productService.updateProduct(product));
	}
	
	//get all product
	@GetMapping("/")
	public ResponseEntity<?> getAll(Product product){
		return ResponseEntity.ok(this.productService.getProducts());
	}
	
	//get single product by id
	@GetMapping("/{id}")
	public Product get(@PathVariable("id") Long id) {
		return this.productService.getProduct(id);
	}
	
	//delete product by id
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		 this.productService.deleteProduct(id);
	}
	
	//get product by category
	@GetMapping("/category/{cid}")
	public List<Product> getProductofCategory(@PathVariable("cid") Long cid){
		
		Category category = new Category();
		category.setCid(cid);
		return this.productService.getProductOfCategory(category);
	}
	@GetMapping("/productprice/{id}")
	public int getpriceproduct(@PathVariable("id") long id){
		System.out.println("id"+id);
		
		return this.productService.getproductprice(id);
		
	}
}
