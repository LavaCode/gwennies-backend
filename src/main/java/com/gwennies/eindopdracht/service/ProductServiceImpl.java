package com.gwennies.eindopdracht.service;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.gwennies.eindopdracht.domain.Product;
import com.gwennies.eindopdracht.repository.ProductRepository;
import com.gwennies.eindopdracht.util.FileUploadUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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

	@Override
    public void uploadProductPicture(MultipartFile multipartFile, Principal principal) throws IOException {
        Product product = productRepository.findByName(principal.getName());
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        String uploadDir = "productpictures/" + product.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        product.setProductPicture(fileName);
        productRepository.save(product);
    }


    @Override
    public String getProductPicture(Principal principal) throws IOException {

        Product product = productRepository.findByName(principal.getName());

        String fileName = product.getProductPicture();

        Path path = Paths.get("productpictures/" + product.getId() + "/" + fileName);
        if(path.endsWith("null")) path = Paths.get("productpictures/default.jpg");
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        return Base64.getEncoder().withoutPadding().encodeToString(resource.getByteArray());
    }
}
