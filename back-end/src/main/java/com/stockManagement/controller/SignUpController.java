package com.stockManagement.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.stockManagement.model.SignUp;

import com.stockManagement.repository.SignupRepository;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/user/details/")
public class SignUpController {
	
		@Autowired
		private SignupRepository signupRepository;
		
		// get All Users
		@GetMapping("signup")
		public List<SignUp> getAllProducts(){
			return signupRepository.findAll();
		}
		
		//add the User
		@PostMapping("signup")
		public SignUp addProduct(@RequestBody SignUp signup) {
			return signupRepository.save(signup);
			
		}
		
}
