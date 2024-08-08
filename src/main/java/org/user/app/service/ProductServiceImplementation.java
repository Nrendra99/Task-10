package org.user.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.app.model.Product;
import org.user.app.repository.ProductRepository;

@Service//Marks the class as a Spring service component, allowing it to be detected and managed by Spring.
public class ProductServiceImplementation implements ProductService {

    // Injecting the ProductRepository bean for database operations
    @Autowired
    private ProductRepository ProductRepository;

    /**
     * Adds a new product to the repository.
     * 
     * @param product The product to be added.
     * @return The added product.
     */
    @Override
    public Product addProduct(Product product) {
        // Save the product to the database
        return this.ProductRepository.save(product);
    }

    /**
     * Retrieves all products from the repository.
     * 
     * @return A list of all products.
     */
    @Override
    public List<Product> getProducts() {
        // Retrieve all products from the database
        return this.ProductRepository.findAll();
    }

    /**
     * Retrieves products by category.
     * 
     * @param category The category to filter products by.
     * @return A list of products that belong to the specified category.
     */
    @Override
    public List<Product> showByCategory(String category) {
        // Retrieve products by category from the database
        return this.ProductRepository.findByCategory(category);
    }

    /**
     * Deletes a product by its ID.
     * 
     * @param id The ID of the product to be deleted.
     */
    @Override
    public void deleteProductById(Long id) {
        // Delete the product from the database by its ID
        this.ProductRepository.deleteById(id);
    }
}