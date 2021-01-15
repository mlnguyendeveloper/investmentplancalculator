package com.mlnguyendev.investmentplancalculator.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mlnguyendev.investmentplancalculator.dao.IUserRepository;
import com.mlnguyendev.investmentplancalculator.entity.MyUserDetails;
import com.mlnguyendev.investmentplancalculator.entity.User;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<User> user = userRepository.findByUserName(userName);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
		
		return user.map(MyUserDetails::new).get();
	}
}
