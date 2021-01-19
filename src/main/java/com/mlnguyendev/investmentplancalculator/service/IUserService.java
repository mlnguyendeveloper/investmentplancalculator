package com.mlnguyendev.investmentplancalculator.service;

import java.util.List;

import com.mlnguyendev.investmentplancalculator.model.User;
import com.mlnguyendev.investmentplancalculator.model.UserDTO;

public interface IUserService {
	
	public List<User> findAll();
	public User findById(int id);
	public User findByUsername(String userName);
	public void save(User user);
	public void deleteById(int id);
	
	public User registerNewUser(UserDTO userDTO) 
			throws Exception;
}
