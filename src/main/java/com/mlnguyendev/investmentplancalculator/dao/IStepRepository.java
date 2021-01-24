package com.mlnguyendev.investmentplancalculator.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlnguyendev.investmentplancalculator.model.Step;

public interface IStepRepository extends JpaRepository<Step, Integer> {

}
