package com.mlnguyendev.investmentplancalculator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mlnguyendev.investmentplancalculator.dao.IStepRepository;
import com.mlnguyendev.investmentplancalculator.model.Step;

public class StepService implements IStepService {

	private IStepRepository stepRepository;
	
	@Autowired
	public StepService(IStepRepository stepRepository) {
		this.stepRepository = stepRepository;
	}
	
	@Override
	public List<Step> findAll() {
		return stepRepository.findAll();
	}

	@Override
	public Step findById(int id) {
		Optional<Step> result = stepRepository.findById(id);
		
		Step step = null;
		
		if (result.isPresent()) {
			step = result.get();
		}
		
		return step;
	}

	@Override
	public void save(Step step) {
		stepRepository.save(step);
	}

	@Override
	public void deleteById(int id) {
		stepRepository.deleteById(id);
	}

}
