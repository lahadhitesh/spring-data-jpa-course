package com.data.jpa.demo;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.data.jpa.demo.entity.Product;
import com.data.jpa.demo.repository.ProductRepository;

@SpringBootTest

class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void saveProduct() {
		// create products
		Product product = new Product();
		product.setName("Product 1");
		product.setDescription("Product description 1");
		product.setSku("100ABC");
		product.setPrice(new BigDecimal(100));
		product.setActive(true);
		product.setImageUrl("product1.png");

		// save products
		Product saveProduct = productRepository.save(product);

		// display product info
		System.out.println(saveProduct.getId());
		System.out.println(saveProduct.toString());
	}

	@Test
	void updateProduct() {

		Long id = 1L;

		// get product
		Product product = productRepository.findById(id).get();

		// update products
		product.setName("Product 2 updated");
		product.setDescription("Product description 2 updated");

		// save products
		productRepository.save(product);
	}

	@Test
	void findById() {
		Long id = 1L;

		Product product = productRepository.findById(id).get();
		System.out.println(product);
	}

	@Test
	void saveAllProducts() {

		Product product = new Product();

		product.setActive(true);
		product.setDescription("Product A Description");
		product.setImageUrl("Product A.png");
		product.setName("Product A");
		product.setPrice(new BigDecimal(25000));
		product.setSku("500ABC");

		Product product1 = new Product();

		product1.setActive(true);
		product1.setDescription("Product B Description");
		product1.setImageUrl("Product B.png");
		product1.setName("Product B");
		product1.setPrice(new BigDecimal(50000));
		product1.setSku("800XYZ");

		productRepository.saveAll(List.of(product, product1));
	}

	@Test
	void findAllProducts() {
		List<Product> product = productRepository.findAll();

		product.forEach(List -> {
			System.out.println(product);
		});

		System.out.println("===========================================");

		product.forEach((p) -> System.out.println(p.getName()));
	}

	@Test
	void deleteProductById() {
		Long id = 1L;
		productRepository.deleteById(id);

	}

	@Test
	void deleteEntityProduct() {
		Product product = productRepository.findById(2L).get();
		productRepository.delete(product);
	}

	@Test
	void deleteAllProducts() {
		List<Product> product = productRepository.findAll();
		productRepository.deleteAll(product);
	}

	@Test
	void countAllProducts() {
		Long count = productRepository.count();
		System.out.println(count);
	}

	@Test
	void existProductsById() {
		boolean check8 = productRepository.existsById(8L);
		boolean check9 = productRepository.existsById(9L);
		System.out.println(check8);
		System.out.println(check9);
	}
}
