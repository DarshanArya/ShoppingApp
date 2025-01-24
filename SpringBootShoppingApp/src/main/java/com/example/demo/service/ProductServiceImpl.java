package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exceptions.ProductNotFound;
import com.example.demo.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ProductServiceImpl implements ProductService {

	ProductRepository repository;

	public String addproduct(Product product) {

		Product product1 = repository.save(product);
		if (product1 != null)
			return "product saved sucessfully";
		else
			return "failed to save product";
	}

	@Override
	public Product updateproduct(Product product) {
		repository.save(product);

		return repository.save(product);
	}

	@Override
	public String deleteproduct(int productId) {
		repository.deleteById(productId);
		return "Product deleted Successfully";
	}

	@Override
	public Product getproductById(int productId) throws ProductNotFound {
		Optional<Product> optional=repository.findById(productId);
		if(optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("no product found with given id");
	} 

	@Override
	public List<Product> getAllproducts() {

		return repository.findAll();
	}

	@Override
	public List<Product> getAllProductsBetween(int initialPrice, int finalPrice) {

		return repository.getAllProductsBetween(initialPrice, finalPrice);
	}
	
	

	@Override
	public List<Product> getProductsByCategory(String productCategory) {
		return repository.findByProductCategory(productCategory);
		
	}

	@Override
	public List<Product> ProductPriceLessThan(int price) {
		return repository.findByProductPriceLessThan(price);
	}

}
