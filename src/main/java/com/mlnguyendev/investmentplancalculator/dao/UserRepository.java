package com.mlnguyendev.investmentplancalculator.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlnguyendev.investmentplancalculator.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}
