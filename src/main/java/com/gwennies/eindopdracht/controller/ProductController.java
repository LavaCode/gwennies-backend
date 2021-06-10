package com.gwennies.eindopdracht.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.gwennies.eindopdracht.domain.Product;
import com.gwennies.eindopdracht.exceptions.ProductException;
import com.gwennies.eindopdracht.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping()
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> list = productService.getAllProducts();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findProductById(@PathVariable Long id) throws ProductException {
		Product product = productService.findProductById(id);
		if (product == null) {
			throw new ProductException("Product with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(product);
	}

	@PostMapping()
	public ResponseEntity<?> addProduct(@Valid @RequestBody Product product, Errors errors) throws ProductException {

		if (errors.hasErrors()) {
			throw new ProductException(errors.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}

		boolean productExists = productService.findProductByName(product.getName()) != null;
		if (productExists) {
			throw new ProductException("Unable to create. A product with name " + product.getName() + " already exist.",
					HttpStatus.CONFLICT);

		}

		productService.addProduct(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long id, @Valid @RequestBody Product product, Errors errors)
			throws ProductException {
		if (errors.hasErrors()) {
			throw new ProductException(errors.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
		Product currentProduct = productService.findProductById(id);
		if (currentProduct == null) {
			throw new ProductException("Unable to update. Product with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
		productService.updateProduct(id, product);

		return ResponseEntity.ok(product);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) throws ProductException {
		Product currentProduct = productService.findProductById(id);
		if (currentProduct == null) {
			throw new ProductException("Unable to delete. Product with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
		productService.deleteProduct(id);
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}
}