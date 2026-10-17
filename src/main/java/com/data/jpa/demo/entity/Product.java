package com.data.jpa.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(
		name = "product", schema = "spring_data_jpa",
		uniqueConstraints = {
		@UniqueConstraint(columnNames = "spring_data_jpa")
		}
	)

public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "stock_keeping_unit", nullable = false)
	private String sku;
	
	@Column(nullable = false)
	private String name;
	private String description;
	private BigDecimal price;
	private boolean isActive;
	private String imageUrl;
}
