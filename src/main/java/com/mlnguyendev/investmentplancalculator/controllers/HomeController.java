package com.mlnguyendev.investmentplancalculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.mlnguyendev.investmentplancalculator.service.UserService;

@Controller
public class HomeController {
	
	UserService userService;
	
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("activePage", "home");
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
	
}
