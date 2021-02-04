package com.mlnguyendev.investmentplancalculator.model;

import javax.validation.constraints.NotEmpty;

public class PlanDTO {
	
	@NotEmpty
	private String name;
	
	private String description;
	
	public PlanDTO() {}

	public PlanDTO(@NotEmpty String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
