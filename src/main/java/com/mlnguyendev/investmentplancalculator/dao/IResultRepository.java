package com.mlnguyendev.investmentplancalculator.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlnguyendev.investmentplancalculator.model.Result;

public interface IResultRepository extends JpaRepository<Result, Integer>{

}
