package com.mlnguyendev.investmentplancalculator.service;

import java.util.List;

import com.mlnguyendev.investmentplancalculator.model.Result;

public interface IResultService {
	public List<Result> findAll();
	public Result findById(int id);
	public void save(Result result);
	public void deleteById(int id);
}
