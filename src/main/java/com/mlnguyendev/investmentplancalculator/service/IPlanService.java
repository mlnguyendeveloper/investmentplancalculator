package com.mlnguyendev.investmentplancalculator.service;

import java.util.List;

import com.mlnguyendev.investmentplancalculator.model.Plan;
import com.mlnguyendev.investmentplancalculator.model.PlanDTO;
import com.mlnguyendev.investmentplancalculator.model.User;

public interface IPlanService {
	public List<Plan> findAll();
	public Plan findById(int id);
	public Plan findByName(String name);
	public void save(Plan plan);
	public void deleteById(int id);
	public void createPlan(PlanDTO planDTO, User user);
}
