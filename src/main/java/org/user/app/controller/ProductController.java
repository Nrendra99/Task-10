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

/**
 * Controller for handling requests related to products.
 */
@Controller// Marks the class as a Spring MVC controller to handle web requests.
public class ProductController {

    @Autowired//Injects the ProductService dependency.
    private ProductService productService;
    
    /**
     * Displays the home page of the product management system.
     * 
     * @param model The model to add attributes for the view.
     * @return The name of the home page view.
     */
    @GetMapping("/home")
    public String productsHomePage(Model model){
        return "homepage";
    }
    
    /**
     * Displays the form for adding a new product.
     * 
     * @param model The model to add attributes for the view.
     * @return The name of the form view to add a product.
     */
    @GetMapping("/addProducts")
    public String showAddProductsForm(Model model) {
        model.addAttribute("Product", new Product());
        return "add product";
    }
    
    /**
     * Processes the form submission for adding a new product.
     * 
     * @param product The product to be added, validated by the form.
     * @param result The binding result to capture validation errors.
     * @param model The model to add attributes for the view.
     * @return Redirects to the product list if successful, or returns to the form if there are validation errors.
     */
    @PostMapping("/process")
    public String addProductsProcess(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add product";
        }
        
        this.productService.addProduct(product);
        return "redirect:/products";
    }
    
    /**
     * Displays products filtered by the specified category.
     * 
     * @param category The category to filter products by.
     * @param model The model to add attributes for the view.
     * @return The name of the view to display products by category.
     */
    @GetMapping("/view/{category}")
    public String viewProductsByCategory(@PathVariable String category, Model model) {
        model.addAttribute("products", this.productService.showByCategory(category));
        return "categories";
    }
    
    /**
     * Displays a list of all products.
     * 
     * @param model The model to add attributes for the view.
     * @return The name of the view to display the product list.
     */
    @GetMapping("/products")
    public String productList(Model model) {
        model.addAttribute("products", this.productService.getProducts());
        return "product page";
    }
    
    /**
     * Deletes a product by its ID.
     * 
     * @param id The ID of the product to be deleted.
     * @return Redirects to the product list.
     */
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.productService.deleteProductById(id);
        return "redirect:/products";
    }
}
