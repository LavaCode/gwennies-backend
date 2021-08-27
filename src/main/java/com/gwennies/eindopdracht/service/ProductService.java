package com.gwennies.eindopdracht.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.security.Principal;

import com.gwennies.eindopdracht.domain.Product;


public interface ProductService {

	List<Product> getAllProducts();
	Product findProductById(Long id);
	Product findProductByName(String name);
	void addProduct(Product product);
	void updateProduct(Long id, Product product);
	void deleteProduct(Long id);
	void uploadProductPicture(MultipartFile multipartFile, Principal principal) throws IOException;
    String getProductPicture(Principal principal) throws IOException;
}
