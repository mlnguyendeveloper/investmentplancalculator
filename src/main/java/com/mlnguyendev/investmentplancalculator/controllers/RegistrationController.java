package com.mlnguyendev.investmentplancalculator.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mlnguyendev.investmentplancalculator.model.UserDTO;

@Controller
public class RegistrationController {

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("userDTO", new UserDTO());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String userRegistration(@Valid UserDTO userDTO,
										BindingResult bindingResult,
										Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("userDTO", new UserDTO());
			return "register";
		}
		
		return "redirect:user";
	}
	
	
}
