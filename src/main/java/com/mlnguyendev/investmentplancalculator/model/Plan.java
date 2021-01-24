package com.mlnguyendev.investmentplancalculator.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Plan {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL,
			fetch=FetchType.LAZY)
	@JoinColumn(name="step_id")
	private List<Step> steps;
	
	@OneToOne(cascade=CascadeType.ALL,
			fetch=FetchType.LAZY)
	@JoinColumn(name="result_id")
	private Result result;
	
	public Plan() {
		
	}

	public Plan(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Plan(String name, String description, List<Step> steps) {
		this.name = name;
		this.description = description;
		this.steps = steps;
	}

	
	public Plan(String name, String description, List<Step> steps, Result result) {
		this.name = name;
		this.description = description;
		this.steps = steps;
		this.result = result;
	}

	public int getId() {
		return id;
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

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	
	public void addStep(Step step) {
		if (steps == null) {
			steps = new LinkedList<Step>();
		}
		steps.add(step);
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
	
}
