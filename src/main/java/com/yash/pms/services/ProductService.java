/* this is productservice interface which contains methods that we use for operations
 * productserviceimpl class implemetns this productservice
 * */

package com.yash.pms.services;

import java.util.List;
import java.util.Set;

import com.yash.pms.model.product.Category;
import com.yash.pms.model.product.Product;


public interface ProductService {
	
	//add products
	public Product addProduct(Product product) throws Exception;
	
	//update products
	public Product updateProduct(Product product);
	
	//get all products
	public Set<Product> getProducts();
	
	//get single product by id
	public Product getProduct(Long productId);
	
	//delete quiz by id
	public  void deleteProduct(Long productId);

	
	//get product of category
	public List<Product>  getProductOfCategory(Category category);

	public int getproductprice(long id);
}
