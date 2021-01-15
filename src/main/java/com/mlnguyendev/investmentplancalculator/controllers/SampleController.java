package com.mlnguyendev.investmentplancalculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
	
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
}
