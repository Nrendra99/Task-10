package org.user.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.user.app.model.Product;

@Repository//Marks the interface as a Spring Data JPA repository, enabling CRUD operations and custom queries.
public interface ProductRepository extends JpaRepository<Product, Long> { //Extends JpaRepository, providing standard CRUD operations and pagination support for Product entities with Long as the ID type.

    /**
     * Retrieves a list of products that belong to the specified category.
     * 
     * @param category The category to filter products by.
     * @return A list of products in the specified category.
     */
    public List<Product> findByCategory(String category);
}