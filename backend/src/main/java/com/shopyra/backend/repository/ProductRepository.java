package com.shopyra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopyra.backend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
}
