package com.gwennies.eindopdracht.controller;

import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import com.gwennies.eindopdracht.domain.Product;
import com.gwennies.eindopdracht.dto.AddProductDto;
import com.gwennies.eindopdracht.exceptions.ProductException;
import com.gwennies.eindopdracht.service.ProductService;
import com.gwennies.eindopdracht.util.FileUploadUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	@CrossOrigin(origins = "http://localhost:8090")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> list = productService.getAllProducts();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<?> findProductById(@PathVariable Long id) throws ProductException {
		Product product = productService.findProductById(id);
		if (product == null) {
			throw new ProductException("Product with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(product);
	}

	@PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> addProduct(@Valid @RequestBody Product product, Errors errors, @RequestParam("image") MultipartFile multipartFile) throws ProductException, IOException {

		if (errors.hasErrors()) {
			throw new ProductException(errors.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}

		boolean productExists = productService.findProductByName(product.getName()) != null;
		if (productExists) {
			throw new ProductException("Unable to create. A product with name " + product.getName() + " already exist.",
					HttpStatus.CONFLICT);

		}

		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		productService.addProduct(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId())
				.toUri();
		String uploadDir = "product-photos";
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		return ResponseEntity.created(location).build();
	}

	@PostMapping(value = "files", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE} )
		  public ResponseEntity<Object> addProduct(AddProductDto dto) throws IOException {
			 FileUploadUtil.saveFile("static/files", dto.file.getOriginalFilename(), dto.file);
			 return ResponseEntity.ok().build();
		  }

	@PutMapping("/change/{id}")
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

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) throws ProductException {
		Product currentProduct = productService.findProductById(id);
		if (currentProduct == null) {
			throw new ProductException("Unable to delete. Product with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
		productService.deleteProduct(id);
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/product/productpicture")
    public ResponseEntity<Object> setProductPicture( @RequestParam("file") MultipartFile file, Principal principal) throws IOException {
        productService.uploadProductPicture(file, principal);
        return ResponseEntity.ok().body("Product picture updated!");
    }

    @GetMapping("/product/productpicture")
    public ResponseEntity<Object> getProductPicture(Principal principal) throws IOException {
       return ResponseEntity.ok().body(productService.getProductPicture(principal));
    }
}