package com.mlnguyendev.investmentplancalculator.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mlnguyendev.investmentplancalculator.dao.IUserRepository;
import com.mlnguyendev.investmentplancalculator.model.User;
import com.mlnguyendev.investmentplancalculator.model.UserDTO;

@Service
public class UserService implements IUserService {

	private IUserRepository userRepository;
	private AuthorityService authorityService;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(IUserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityService authorityService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authorityService = authorityService;
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
	public User register(UserDTO userDTO) throws Exception {
		User user = new User();
		
		//Set properties from the userDTO
		BeanUtils.copyProperties(userDTO, user);
		encodePassword(userDTO, user);
		
		//Newly registered users sould be ROLE_USER by default
		user.addAuthority(authorityService.findById(AuthorityService.RoleType.USER.ordinal()));
		userRepository.save(user);
		
		return user;
	}
	
	private void encodePassword(UserDTO userDTO, User user) {
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
	}

}
