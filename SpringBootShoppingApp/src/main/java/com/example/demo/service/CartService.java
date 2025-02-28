package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cart;

public interface CartService {
	
	public abstract Cart addToCart(Cart cart);

	public abstract Cart updatecart(Cart cart);

	public abstract String deletecart(int cartId);

	public abstract List<Cart> getAllCart();

	
}
