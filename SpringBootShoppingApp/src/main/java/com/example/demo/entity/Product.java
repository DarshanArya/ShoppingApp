package com.example.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity

@Table
public class Product {
	@Id
	private int productId;
	private String productName;
	private int productPrice;
	private String productCategory;
	private Date productValidity;
	
	@ManyToOne
	@JoinColumn(name="cart_id", referencedColumnName="cartId")
	@JsonBackReference
	private Cart cart;
	

}
