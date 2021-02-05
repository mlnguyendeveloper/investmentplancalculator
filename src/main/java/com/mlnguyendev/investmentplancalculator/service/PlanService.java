package com.mlnguyendev.investmentplancalculator.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlnguyendev.investmentplancalculator.dao.IPlanRepository;
import com.mlnguyendev.investmentplancalculator.model.Plan;
import com.mlnguyendev.investmentplancalculator.model.PlanDTO;
import com.mlnguyendev.investmentplancalculator.model.User;

@Service
public class PlanService implements IPlanService {

	private IPlanRepository planRepository;
	
	@Autowired
	public PlanService(IPlanRepository planRepository) {
		this.planRepository = planRepository;
	}
	
	@Override
	public List<Plan> findAll() {
		return planRepository.findAll();
	}

	@Override
	public Plan findById(int id) {
		Optional<Plan> result = planRepository.findById(id);
		
		Plan plan = null;
		
		if (result.isPresent()) {
			plan = result.get();
		}
		
		return plan;
	}

	@Override
	public Plan findByName(String name) {
		Optional<Plan> result = planRepository.findByName(name);
		
		Plan plan = null;
		
		if (result.isPresent()) {
			plan = result.get();
		}
		
		return plan;
	}

	@Override
	public void save(Plan plan) {
		planRepository.save(plan);
	}

	@Override
	public void deleteById(int id) {
		planRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void createPlan(PlanDTO planDTO, User user) {
		Plan plan = new Plan();
		
		//Set properties from the PlanDTO
		BeanUtils.copyProperties(planDTO, plan);
		
		//Saves the newly created plan
		planRepository.save(plan);
		
		//Updates the user with a new plan
		user.addPlan(plan);
	}
}
