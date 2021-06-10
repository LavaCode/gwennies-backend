package com.gwennies.eindopdracht.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwennies.eindopdracht.domain.Product;
import com.gwennies.eindopdracht.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	@Override
	public Product findProductById(Long id) {
		return productRepository.findById(id)
        .orElse(null);

	}
	
	@Override
	public Product findProductByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	@Override
	public void updateProduct(Long id, Product product) {
		product.setId(id);
		productRepository.save(product);
	}
	
	@Override
	public void deleteProduct(Long id) {
		Product product = productRepository.findById(id)
        .orElse(null);
		productRepository.delete(product);
	}

}
