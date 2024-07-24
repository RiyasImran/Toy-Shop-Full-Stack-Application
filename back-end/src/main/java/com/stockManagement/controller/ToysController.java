package com.stockManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.stockManagement.model.Toys;
import com.stockManagement.repository.ToysRepository;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController

@RequestMapping("/api/v2/")
public class ToysController {
	
	@Autowired
	private ToysRepository toysRepository;
	
	// get All Products
		@GetMapping("toys")
		public List<Toys> getAllProducts(){
			return toysRepository.findAll();
		}
		
		@PostMapping("toys")
		public Toys addProduct(@RequestBody Toys toys) {
			return toysRepository.save(toys);
			
		}

}
