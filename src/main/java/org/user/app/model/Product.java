package org.user.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {

	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	 @NotBlank(message = "Name is mandatory")
	 @Column(name="name")
	private String name;
	 

	 @Column(name = "price")
	 @Min(value = 1, message = "Price must be greater than or equal to 1")
	private long price;
	 

	 @NotBlank(message = "Category is mandatory")
	 @Column(name="category")
	private String  category;
}
