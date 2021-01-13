package com.mlnguyendev.investmentplancalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mlnguyendev.investmentplancalculator.dao.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=UserRepository.class)
public class InvestmentplancalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestmentplancalculatorApplication.class, args);
	}

}
