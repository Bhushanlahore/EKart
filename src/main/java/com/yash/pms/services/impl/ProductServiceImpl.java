/*this is productservice implementation class which implements productservice
 * we write our actual logic in this class
 * */
package com.yash.pms.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.pms.exception.ProductFoundException;
import com.yash.pms.model.product.Category;
import com.yash.pms.model.product.Product;
import com.yash.pms.repository.ProductRepository;
import com.yash.pms.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	//add product if product present throw productFoundException
	@Override
	public Product addProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		Product localProduct = this.productRepository.findProductByName(product.getName());
		if(localProduct != null) {
			System.out.println("Product Found!!!");
			throw new ProductFoundException();
		}else {
			
			localProduct = this.productRepository.save(product);
		}
		
		return localProduct;
	}

	//update product
	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return this.productRepository.save(product);
	}

	// get all products
	@Override
	public Set<Product> getProducts() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.productRepository.findAll());
	}

	//get product by id
	@Override
	public Product getProduct(Long productId) {
		// TODO Auto-generated method stub
		return this.productRepository.findById(productId).get();
	}

	//delete product by id
	@Override
	public void deleteProduct(Long productId) {
		// TODO Auto-generated method stub	
		this.productRepository.deleteById(productId);
	}

	//get product according to category
	@Override
	public List<Product> getProductOfCategory(Category category) {
		// TODO Auto-generated method stub
		return	this.productRepository.findByCategory(category);
	}
	public int getproductprice(long id) {
		Product product= this.productRepository.findById(id).get();
		 return product.getPrice();
	}

}
