package com.mlnguyendev.investmentplancalculator.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mlnguyendev.investmentplancalculator.model.UserDTO;
import com.mlnguyendev.investmentplancalculator.service.UserService;

@Controller
public class RegistrationController {
	
	UserService userService;
	
	@Autowired
	public RegistrationController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("userDTO", new UserDTO());
		
		return "authentication/registration";
	}
	
	@PostMapping("/register")
	public String userRegistration(@Valid UserDTO userDTO,
										BindingResult bindingResult,
										Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("userDTO", userDTO);
			return "authentication/registration";
		}
		
		try{
			userService.register(userDTO);
		} catch (Exception e) { //TODO: Add a proper UserAlreadyExistException
			bindingResult.rejectValue("email", "userDTO.email", "An account has already been registered with that email. TODO: All errors go here, add more error handling");
			model.addAttribute("userDTO", userDTO);
			return "authentication/registration";
		}
		
		return "redirect:user";
	}
	
	
}
