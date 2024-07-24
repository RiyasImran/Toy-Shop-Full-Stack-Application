package com.stockManagement.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stockManagement.exception.ResourceNotFoundException;
import com.stockManagement.model.ImageModel;
import com.stockManagement.model.Product;
import com.stockManagement.repository.ProductRepository;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController

@RequestMapping("/api/v1/")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	// get All Products
	@GetMapping("product")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("product/{id}")
	public ResponseEntity<Product> getById(@PathVariable  Integer id){
		Product product = productRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("id not found"+id));
		return ResponseEntity.ok().body(product);
		
	}
	
	//add the products
	@PostMapping(value = {"/product"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Product addProduct(@RequestPart("product") Product product,
							  @RequestPart("imageFile")MultipartFile[] file) {
		
		try {
			Set<ImageModel> images =uploadImages(file);
			product.setProductImages(images);
			
			return productRepository.save(product);
			
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
			
		}
		
		
	}
	
	
	public Set<ImageModel> uploadImages(MultipartFile[] multiPartFiles) throws IOException{
		
		Set<ImageModel> imageModels = new HashSet<>();
		
		for(MultipartFile file: multiPartFiles) {
			
			ImageModel img = new ImageModel(
					file.getOriginalFilename(),
				    file.getContentType(),
					file.getBytes()
					);
			
			imageModels.add(img);
		}
		
		return imageModels;
		
	}
	
	
	
	
	
	
	
	
	
	
	// Update the products
	@PutMapping("product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable  Integer id,@RequestBody Product productDetails) {
		
		Product product = productRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("id not found"+id));
		
		//product.setProductType(productDetails.getProductType());
		//product.setProductId(productDetails.getProductId());
		//product.setProductName(productDetails.getProductName());
		product.setProductPrice(productDetails.getProductPrice());
		product.setProductCount(productDetails.getProductCount());
		
		Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
		
	}
	
	//Delete the Product
	@DeleteMapping("product/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable  Integer id){
		Product product = productRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("id not found"+id));
		productRepository.delete(product);
		Map<String,Boolean>response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}
}
