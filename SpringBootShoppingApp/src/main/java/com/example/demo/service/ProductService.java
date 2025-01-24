package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.exceptions.ProductNotFound;

public interface ProductService {

	public abstract String addproduct(Product product);

	public abstract Product updateproduct(Product product);

	public abstract String deleteproduct(int productId);

	public abstract Product getproductById(int productId) throws ProductNotFound;

	public abstract List<Product> getAllproducts();

	public abstract List<Product> getAllProductsBetween(int initialPrice, int finalPrice);
	
	public abstract List<Product> getProductsByCategory(String ProductCategory);
	
	public abstract List<Product> ProductPriceLessThan(int price);

}
