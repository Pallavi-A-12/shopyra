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
	
	public Product updateProduct(Long id, Product updateProduct) {
		
		Product existingProduct = productRepository.findById(id)
			.orElseThrow( () -> new RuntimeException("Product not Found"));			
		
		existingProduct.setName(updateProduct.getName());
		existingProduct.setDescription(updateProduct.getDescription());
		existingProduct.setPrice(updateProduct.getPrice());
		existingProduct.setStock(updateProduct.getStock());
		
		return productRepository.save(existingProduct);
		
	}
	
	
	
	
}
