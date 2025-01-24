package com.example.demo.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.exceptions.ProductNotFound;
import com.example.demo.service.ProductService;

import ch.qos.logback.classic.Logger;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(ProductController.class);
	
	ProductService service;
	@PostMapping("/save") ////http://localhost:8080/products/save
	public String saveProduct(@RequestBody Product product) {
		logger.info("Recived request to save Product:{}", product);
		String response =service.addproduct(product);
		return service.addproduct(product);
		
	}
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateproduct(product);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int productId) {
		return service.deleteproduct(productId);
	}
	@GetMapping("/getById/{id}") //http://localhost:8080/products/getById/---
	public Product getProduct(@PathVariable("id") int productId)  throws ProductNotFound{
		return service.getproductById(productId);
	}
	@GetMapping("/getAll") //http://localhost:8080/products/getAll
	public List<Product> getAllProducts() {
		return service.getAllproducts();
	}
	@GetMapping("/getBetween/{price1}/{price2}") //http://localhost:8080/products/getBetween/--/--
	public List<Product> getAllProductsBetween(@PathVariable("price1") int initialPrice, @PathVariable("price2") int finalPrice) {
		return service.getAllProductsBetween(initialPrice, finalPrice);
		
	}
	@GetMapping("/getByCategory/{category}") // http://localhost:8081/products/getByCategory/Electronics
	public List<Product> getProductByCategory(@PathVariable("category") String Category) {
		logger.info("Retrieved Product with productCategory {} successfully", Category);
		return service.getProductsByCategory(Category);
	}
 
	@GetMapping("/getProductLessThan/{price}") // http://localhost:8081/products/getProductLessThan/20000
	public List<Product> getProductLessThanPrice(@PathVariable("price") int productprice) {
		logger.info("Retrieved Product with productPrice less than {} successfully", productprice);
		return service.ProductPriceLessThan(productprice);
	}
	


}
