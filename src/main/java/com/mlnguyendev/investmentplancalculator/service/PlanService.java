package com.mlnguyendev.investmentplancalculator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlnguyendev.investmentplancalculator.dao.IPlanRepository;
import com.mlnguyendev.investmentplancalculator.model.Plan;

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
}
