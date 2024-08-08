package org.user.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.user.app.model.Product;

@Repository
public interface ProductRepository extends JpaRepository< Product, Long> {

	public List<Product> findBycategory(String category);
}
