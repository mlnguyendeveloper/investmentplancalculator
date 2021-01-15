package com.mlnguyendev.investmentplancalculator.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlnguyendev.investmentplancalculator.dao.IUserRepository;
import com.mlnguyendev.investmentplancalculator.entity.User;
import com.mlnguyendev.investmentplancalculator.entity.UserDTO;

@Service
public class UserService implements IUserService {

	IUserRepository userRepository;
	
	@Autowired
	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		Optional<User> result = userRepository.findById(id);
		
		User user = null;
		
		if (result.isPresent()) {
			user = result.get();
		}
		
		return user;
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findByUsername(String userName) {
		Optional<User> result = userRepository.findByUserName(userName);
		
		User user = null;
		
		if (result.isPresent()) {
			user = result.get();
		}
		
		return user;
	}

	@Override
	@Transactional
	public User registerNewUser(UserDTO userDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
