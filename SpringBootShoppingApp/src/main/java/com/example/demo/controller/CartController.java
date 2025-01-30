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

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.service.CartService;

import ch.qos.logback.classic.Logger;
import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/cart")
@AllArgsConstructor


public class CartController {
private static final Logger logger = (Logger) LoggerFactory.getLogger(ProductController.class);
	
	CartService service;
	@PostMapping("/save") ////http://localhost:8080/products/save
	public Cart saveCart(@RequestBody Cart cart) {
		
		
		return service.addToCart(cart);
		
	


}
	@PutMapping("/update")
	public Cart updateCartBody(@RequestBody Cart cart) {
		return service.updatecart(cart);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteCart(@PathVariable("id") int cartId) {
		return service.deletecart(cartId);
	}
	@GetMapping("/getAll") // http://localhost:8081/products/getAll
	public List<Cart> getAllCart() {
		
		return service.getAllCart();
	}


}
