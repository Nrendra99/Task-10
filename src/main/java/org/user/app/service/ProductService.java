package org.user.app.service;

import java.util.List;
import org.user.app.model.Product;

public interface ProductService {

    /**
     * Adds a new product to the repository.
     * 
     * @param product The product to be added.
     * @return The added product.
     */
    public Product addProduct(Product product);

    /**
     * Retrieves all products from the repository.
     * 
     * @return A list of all products.
     */
    public List<Product> getProducts();

    /**
     * Retrieves products by their category.
     * 
     * @param category The category to filter products by.
     * @return A list of products that belong to the specified category.
     */
    public List<Product> showByCategory(String category);

    /**
     * Deletes a product from the repository by its ID.
     * 
     * @param id The ID of the product to be deleted.
     */
    public void deleteProductById(Long id);
}
