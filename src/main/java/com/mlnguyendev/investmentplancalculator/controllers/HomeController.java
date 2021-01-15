package com.mlnguyendev.investmentplancalculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mlnguyendev.investmentplancalculator.entity.UserDTO;
import com.mlnguyendev.investmentplancalculator.service.UserService;

@Controller
public class HomeController {
	
	UserService userService;
	
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		
		theModel.addAttribute("theDate", new java.util.Date());
		
		return "helloworld";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user-test-page";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin-test-page";
	}
	
	@GetMapping("/registration")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new UserDTO());
	    
	    return "registration";
	}
	
	@PostMapping("/user/registration")
	public String registerUserAccount
	      (@ModelAttribute("user") @Validated UserDTO userDTO) {
	    

		System.out.println("Received user: " + userDTO.getFirstName() + " " + userDTO.getLastName());
		
	    return "index";
	}
}
