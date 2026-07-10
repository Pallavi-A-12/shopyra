package com.shopyra.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopyra.backend.dto.ProductDTO;
import com.shopyra.backend.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO) {
		
		ProductDTO savedProduct = productService.saveProduct(productDTO);
		
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
		
		
	    return ResponseEntity.ok(productService.getProductById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(
			@PathVariable Long id,
			@Valid @RequestBody ProductDTO productDTO) {
		
		return ResponseEntity.ok(productService.updateProduct(id,  productDTO));
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		
		productService.deleteProduct(id);
		
		return ResponseEntity.ok("Product deleted successfully.");
	}
	
}
