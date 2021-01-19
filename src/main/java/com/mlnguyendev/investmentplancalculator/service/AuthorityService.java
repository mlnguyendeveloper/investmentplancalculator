package com.mlnguyendev.investmentplancalculator.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mlnguyendev.investmentplancalculator.dao.IAuthorityRepository;
import com.mlnguyendev.investmentplancalculator.model.Authority;

public class AuthorityService implements IAuthorityService {

	IAuthorityRepository authorityRepository;
	
	@Autowired
	public AuthorityService(IAuthorityRepository authorityRepository) {
		this.authorityRepository = authorityRepository;
	}
	
	@Override
	public Authority findById(int id) {
		Optional<Authority> result = authorityRepository.findById(id);
		
		Authority authority = null;
		
		if (result.isPresent()) {
			authority = result.get();
		}
		
		return authority;
	}
	
	public static enum RoleType{
		USER, ADMIN, MANAGER
	}

}
