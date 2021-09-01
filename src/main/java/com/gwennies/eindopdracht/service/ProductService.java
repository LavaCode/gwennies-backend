package com.gwennies.eindopdracht.service;

import java.util.List;

import com.gwennies.eindopdracht.domain.Product;


public interface ProductService {

	List<Product> getAllProducts();
	Product findProductById(Long id);
	Product findProductByName(String name);
	Product addProduct(Product product);
	void updateProduct(Long id, Product product);
	void deleteProduct(Long id);
}
