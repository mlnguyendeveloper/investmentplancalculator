package com.mlnguyendev.investmentplancalculator.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="plan")
public class Plan {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="starting_amount")
	private double startingAmount;
	
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

	public Plan(String name, String description, double startingAmount) {
		this.name = name;
		this.description = description;
		this.startingAmount = startingAmount;
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

	public double getStartingAmount() {
		return startingAmount;
	}

	public void setStartingAmount(double startingAmount) {
		this.startingAmount = startingAmount;
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
	
	public void addStep(int index, Step step) {
		if (steps == null) {
			steps = new LinkedList<Step>();
			steps.add(step);
		} else {
			steps.add(index, step);
		}
	}
	
	public void removeStep(int index) {
		steps.remove(index);
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", name=" + name + ", description=" + description + ", startingAmount="
				+ startingAmount + ", steps=" + steps + ", result=" + result + "]";
	}
	
}
