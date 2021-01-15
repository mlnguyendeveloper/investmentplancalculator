package com.mlnguyendev.investmentplancalculator.service;

import java.util.List;

import com.mlnguyendev.investmentplancalculator.entity.User;

public interface UserService {
	
	public List<User> findAll();
	public User findById(int id);
	public void save(User user);
	public void deleteById(int id);
}
