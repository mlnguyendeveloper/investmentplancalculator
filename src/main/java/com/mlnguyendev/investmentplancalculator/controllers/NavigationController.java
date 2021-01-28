package com.mlnguyendev.investmentplancalculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

	@GetMapping("/calculator")
	public String getCalculator(Model model) {
		model.addAttribute("activePage", "calculator");
		return "calculator/investmentplanner";
	}
}
