package com.shopyra.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shopyra.backend.entity.Product;
import com.shopyra.backend.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		
		System.out.println("===== ProductController Called =====");
		System.out.println(product);
		
		
		
		return productService.saveProduct(product);
	}
	
}
