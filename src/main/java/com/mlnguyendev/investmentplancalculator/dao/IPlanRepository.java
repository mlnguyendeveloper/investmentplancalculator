package com.mlnguyendev.investmentplancalculator.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlnguyendev.investmentplancalculator.model.Plan;

public interface IPlanRepository extends JpaRepository<Plan, Integer> {

	Optional<Plan> findByName(String name);
}
