package com.mlnguyendev.investmentplancalculator.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlnguyendev.investmentplancalculator.model.Plan;

public interface IPlanRepository extends JpaRepository<Plan, Integer> {

}
