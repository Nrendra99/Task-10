package org.user.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.user.app.model.Product;
import org.user.app.service.ProductService;

import jakarta.validation.Valid;


@Controller
public class ProductController {

	@Autowired 
	private ProductService productService;
	
	@GetMapping("/home")
	public String productsHomePage(Model model){
		
		return "homepage";
	}
	
	@GetMapping("/addProducts")
	public String showAddPrdouctsForm(Model model )
	{
		model.addAttribute("Product", new Product());
		return "add product";
	}
	
	@PostMapping("/process")
	public String addPoductsProcess(@Valid Product product, BindingResult result,Model model )
	{
		if(result.hasErrors())
		{
			return "add product";
		}
		
		this.productService.addProuduct(product);
		return "redirect:/products";
	}
	
	@GetMapping("/view/{category}")
	public String viewProductsByCategory(@PathVariable String category, Model model) {
	    model.addAttribute("products", this.productService.showBycategory(category));
	    return "categories";
	}
	
	@GetMapping("/products")
	public String productList(Model model)
	{
		model.addAttribute("products", this.productService.getProducts());
		return "product page";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id)
	{
		this.productService.deleteProductById(id);
		return "redirect:/products";
	}
}
