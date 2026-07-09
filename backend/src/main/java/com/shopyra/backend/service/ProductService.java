package com.shopyra.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopyra.backend.dto.ProductDTO;
import com.shopyra.backend.entity.Product;
import com.shopyra.backend.exception.ProductNotFoundException;
import com.shopyra.backend.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductDTO saveProduct(ProductDTO productDTO) {
		
		Product product = convertToEntity(productDTO);
		
		Product savedProduct = productRepository.save(product);
		
		return convertToDTO(savedProduct);
	}
	
	public List<ProductDTO> getAllProducts() {
		
		List<Product> products = productRepository.findAll();
		
		List<ProductDTO> productDTOs = new ArrayList<>();
		
		for (Product product : products) {
			productDTOs.add(convertToDTO(product));
		}
		
		return productDTOs;
	}
	
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}
	
	public Product updateProduct(Long id, Product updateProduct) {
		
		Product existingProduct = productRepository.findById(id)
			.orElseThrow( () -> new ProductNotFoundException("Product not Found with ID :"+id));			
		
		existingProduct.setName(updateProduct.getName());
		existingProduct.setDescription(updateProduct.getDescription());
		existingProduct.setPrice(updateProduct.getPrice());
		existingProduct.setStock(updateProduct.getStock());
		
		return productRepository.save(existingProduct);
		
	}
	
	public void deleteProduct(Long id) {
		
		Product product = productRepository.findById(id)
				.orElseThrow( () -> 
						new ProductNotFoundException("Product not Found with ID : "+id));
		
		productRepository.delete(product);
	}
	
	private Product convertToEntity(ProductDTO dto) {
		
		Product product = new Product();
		
		product.setId(dto.getId());
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setPrice(dto.getPrice());
		product.setStock(dto.getStock());
		
		return product;
	}
	
	private ProductDTO convertToDTO(Product product) {

	    ProductDTO dto = new ProductDTO();

	    dto.setId(product.getId());
	    dto.setName(product.getName());
	    dto.setDescription(product.getDescription());
	    dto.setPrice(product.getPrice());
	    dto.setStock(product.getStock());

	    return dto;
	}
	
}
