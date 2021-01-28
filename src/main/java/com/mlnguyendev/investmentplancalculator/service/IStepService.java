package com.mlnguyendev.investmentplancalculator.service;

import java.util.List;

import com.mlnguyendev.investmentplancalculator.model.Step;

public interface IStepService {
	public List<Step> findAll();
	public Step findById(int id);
	public void save(Step step);
	public void deleteById(int id);
}
