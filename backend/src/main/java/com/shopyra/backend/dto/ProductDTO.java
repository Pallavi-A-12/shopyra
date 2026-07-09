package com.shopyra.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductDTO {

	private Long id;
	
	@NotBlank(message = "Product name cannot be empty")
	private String name;
	
	@NotBlank(message = "Product description cannot be empty")
	private String description;
	
	@NotNull(message = "Price is required")
	@Positive(message = "Price must be greater than zero")
	private Double price;
	
	@NotNull(message = "Stock is required")
	@Min(value = 0, message = "Stock cannot be negative")
	private Integer stock;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(Long id, String name, String description, Double price, Integer stock) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
