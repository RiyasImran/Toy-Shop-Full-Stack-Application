package com.stockManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockManagement.exception.ResourceNotFoundException;

import com.stockManagement.model.ViewCart;
import com.stockManagement.repository.CartRepository;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController

@RequestMapping("/view/cart")
public class CartController {
	@Autowired
	private CartRepository cartRepository;
	
	
	// get All Products
		@GetMapping("/details")
		public List<ViewCart> getAllProducts(){
			return cartRepository.findAll();
		}
		
		
		//add the products
		@PostMapping("/details")
		public ViewCart addProduct(@RequestBody ViewCart viewCart) {
			return cartRepository.save(viewCart);
			
		}
		
		
		// Update the products
		@PutMapping("details/{id}")
		public ResponseEntity<ViewCart> updateProduct(@PathVariable  Integer id,@RequestBody ViewCart viewCartDetails) {
			
			ViewCart viewCart = cartRepository.findById(id)
					.orElseThrow(()->new ResourceNotFoundException("id not found"+id));
			
			
			//viewCart.setProductPrice(viewCartDetails.getProductPrice());
			//viewCart.setProductCount(viewCartDetails.getProductCount());
			viewCart.setTotalPrice(viewCartDetails.getProductCount()*viewCartDetails.getProductPrice());
			
			ViewCart updatedProduct = cartRepository.save(viewCart);
			return ResponseEntity.ok(updatedProduct);
			
		}
		
		
		//Delete the Product
		@DeleteMapping("details/{id}")
		public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable  Integer id){
			ViewCart viewCart = cartRepository.findById(id)
					.orElseThrow(()->new ResourceNotFoundException("id not found"+id));
			cartRepository.delete(viewCart);
			Map<String,Boolean>response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
			
			
		}
}
