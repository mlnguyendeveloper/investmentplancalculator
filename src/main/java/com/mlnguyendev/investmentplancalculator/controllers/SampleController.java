package com.mlnguyendev.investmentplancalculator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@GetMapping("/")
	public String home() {
		return("index");
	}
	
	@GetMapping("/user")
	public String user() {
		return ("user-test-page");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return ("admin-test-page");
	}
}
