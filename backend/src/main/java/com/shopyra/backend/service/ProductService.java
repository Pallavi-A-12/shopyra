package com.shopyra.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopyra.backend.entity.Product;
import com.shopyra.backend.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}
	
	public void checkProduct(Long id) {
		Optional<Product> product = productRepository.findById(id);
		
		if (product.isPresent()) {
			System.out.println("Product Found");
		} else {
			System.out.println("Product Not Found");
		}
		
	}
	
}
