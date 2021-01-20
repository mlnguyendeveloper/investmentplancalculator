package com.mlnguyendev.investmentplancalculator.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlnguyendev.investmentplancalculator.model.Authority;

public interface IAuthorityRepository extends JpaRepository<Authority, Integer> {

}
