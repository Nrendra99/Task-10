package org.user.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.app.model.Product;
import org.user.app.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService {
	
	@Autowired
	private ProductRepository ProductRepository;

	@Override
	public Product addProuduct(Product product) {
		return this.ProductRepository.save(product);
	}

	@Override
	public List<Product> getProducts() {
		return this.ProductRepository.findAll();
	}

	@Override
	public List<Product> showBycategory(String category) {
		return this.ProductRepository.findBycategory(category);
	}

	@Override
	public void deleteProductById(Long id) {
	    this.ProductRepository.deleteById(id);
	}

}
