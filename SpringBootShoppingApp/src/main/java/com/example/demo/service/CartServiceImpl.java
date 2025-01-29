package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepositorty;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class CartServiceImpl implements CartService{
	 CartRepositorty repository;
	@Override
	public Cart addToCart(Cart cart) {
		// TODO Auto-generated method stub
		return repository.save(cart);
	}
	@Override
	public Cart updatecart(Cart cart) {
		repository.save(cart);

		return repository.save(cart);
	}
	@Override
	public String deletecart(int cartId) {
		// TODO Auto-generated method stub
		repository.deleteById(cartId);
		return "cart deleted Successfully";
	}

}
