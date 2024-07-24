package com.stockManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockManagement.model.Decoration;
import com.stockManagement.model.Toys;
import com.stockManagement.repository.DecorationRepository;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController

@RequestMapping("/api/v3/")
public class DecorationController {
	@Autowired
	private DecorationRepository decorationRepository;
	
	// get All Products
		@GetMapping("decoration")
		public List<Decoration> getAllProducts(){
			return decorationRepository.findAll();
		}
		
		@PostMapping("decoration")
		public Decoration addProduct(@RequestBody Decoration decoration) {
			return decorationRepository.save(decoration);
			
		}

}
