package com.mlnguyendev.investmentplancalculator.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mlnguyendev.investmentplancalculator.model.Plan;
import com.mlnguyendev.investmentplancalculator.model.PlanDTO;
import com.mlnguyendev.investmentplancalculator.model.User;
import com.mlnguyendev.investmentplancalculator.service.PlanService;
import com.mlnguyendev.investmentplancalculator.service.UserService;

@Controller
public class CalculatorController {

	UserService userService;
	PlanService planService;
	
	public CalculatorController() {}
	
	@Autowired
	public CalculatorController(UserService userService, PlanService planService) {
		this.userService = userService;
		this.planService = planService;
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
	public String addPlan(Model model) {
		
		model.addAttribute("planDTO", new PlanDTO());
		
		return "calculator/add-plan";
	}
	
	@PostMapping("/calculator/addPlan")
	public String addPlanSubmission(@Valid PlanDTO planDTO,
										BindingResult bindingResult,
										Model model,
										Principal principal) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("planDTO", planDTO);
			return "calculator/addPlan";
		}
		
		try{
			User currentUser = userService.findByUsername(principal.getName());
			planService.createPlan(planDTO, currentUser);
			
		} catch (Exception e) { //TODO: Add a proper Plan exception
			bindingResult.rejectValue("name", "planDTO.name", "An account has already been registered with that email. TODO: All errors go here, add more error handling");
			model.addAttribute("planDTO", planDTO);
			return "calculator/addPlan";
		}
		
		return "redirect:/calculator";
	}
}
