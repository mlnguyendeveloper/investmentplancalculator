package com.mlnguyendev.investmentplancalculator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mlnguyendev.investmentplancalculator.dao.IResultRepository;
import com.mlnguyendev.investmentplancalculator.model.Result;

public class ResultService implements IResultService {

	private IResultRepository resultRepository;
	
	@Autowired
	public ResultService(IResultRepository resultRepository) {
		this.resultRepository = resultRepository;
	}
	
	@Override
	public List<Result> findAll() {
		return resultRepository.findAll();
	}

	@Override
	public Result findById(int id) {
		Optional<Result> resultById = resultRepository.findById(id);
		
		Result result = null;
		
		if(resultById.isPresent()) {
			result = resultById.get();
		}
		
		return result;
	}

	@Override
	public void save(Result result) {
		resultRepository.save(result);
	}

	@Override
	public void deleteById(int id) {
		resultRepository.deleteById(id);
	}

}
