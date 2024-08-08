package org.user.app.service;

import java.util.List;

import org.user.app.model.Product;


public interface ProductService {
   
	public Product addProuduct (Product product);
	public List<Product> getProducts();
	public List<Product> showBycategory(String category);
	public void deleteProductById(Long id);
	}
