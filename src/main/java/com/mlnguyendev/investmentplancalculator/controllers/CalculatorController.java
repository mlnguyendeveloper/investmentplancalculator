package com.mlnguyendev.investmentplancalculator.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mlnguyendev.investmentplancalculator.model.Plan;
import com.mlnguyendev.investmentplancalculator.model.User;
import com.mlnguyendev.investmentplancalculator.service.UserService;

@Controller
public class CalculatorController {

	UserService userService;
	
	public CalculatorController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/calculator")
	public String getCalculator(Model model, Principal principal) {
		
		model.addAttribute("activePage", "calculator");
		
		
		//Get the currently logged user's plans to display.
		User currentUser = userService.findByUsername(principal.getName());
		List<Plan> plans = currentUser.getPlans();
		
		//bind the plans if they exist
		if (!plans.isEmpty()){
			model.addAttribute("plans", plans);
		}
		
		return "calculator/investmentplanner";
	}
	
	@GetMapping("/calculator/addPlan")
	public String addPlan() {
		
		return null;
	}
}
