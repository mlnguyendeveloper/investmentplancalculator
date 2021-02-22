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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mlnguyendev.investmentplancalculator.model.Plan;
import com.mlnguyendev.investmentplancalculator.model.Step;
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
		
		//to be used in the navbar
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
		
		model.addAttribute("plan", new Plan());
		
		return "calculator/add-plan";
	}
	
	@PostMapping("/calculator/addPlan")
	public String addPlanSubmission(@Valid Plan plan,
										BindingResult bindingResult,
										Model model,
										Principal principal) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("plan", plan);
			return "calculator/addPlan";
		}
		
		try{
			User currentUser = userService.findByUsername(principal.getName());
			planService.save(plan);
			currentUser.addPlan(plan);
			userService.save(currentUser);
			
		} catch (Exception e) { //TODO: Add a proper Plan exception
			bindingResult.rejectValue("name", "plan.name", "An account has already been registered with that email. TODO: All errors go here, add more error handling");
			model.addAttribute("plan", plan);
			return "calculator/addPlan";
		}
		
		return "redirect:/calculator";
	}
	
	
	@GetMapping("/calculator/planFinance")
	public String planFinance(@RequestParam("planId") int theId,
									Model theModel) {
		
		Plan plan = planService.findById(theId);
		
		// set plan as a model attribute, ensure it has at least 1 step, to pre-populate the form
		if (plan.getSteps().size() == 0) {
			plan.addStep(new Step());
			planService.save(plan);
		}

		theModel.addAttribute("plan", plan);
		
		// send over to our form
		return "calculator/plan";			
	}
	
	@PostMapping("/calculator/planFinance/steps")
	public String saveSteps(@Valid Plan plan,
							BindingResult bindingResult,
							Model model,
							Principal principal,
							@RequestParam("stepIndex") int stepIndex,
							@RequestParam("action") String action,
							RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("plan", plan);
			return "redirect:/calculator/planFinance";
		}
		
		switch(action) {
			case "add":
				plan.addStep(stepIndex, new Step());
				planService.save(plan);
				break;
			case "remove":
				plan.removeStep(stepIndex - 1);
				planService.save(plan);
				break;
			default:
				break;
		}
		
		model.addAttribute("plan", plan);
		redirectAttributes.addAttribute("planId", plan.getId());
		return "redirect:/calculator/planFinance";
	}
	
}




