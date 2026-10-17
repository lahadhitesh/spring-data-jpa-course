package com.data.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.jpa.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
