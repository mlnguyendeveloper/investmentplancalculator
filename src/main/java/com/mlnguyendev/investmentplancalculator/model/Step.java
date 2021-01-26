package com.mlnguyendev.investmentplancalculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="step")
public class Step {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="starting_amount")
	private double startingAmount;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="return_rate")
	private double returnRate;
	
	@Column(name="additional_contribution")
	private double additionalContribution;
	
	@Column(name="contribution_timing")
	private int contributionTiming;
	
	public Step() {}

	public Step(double startingAmount, int duration, double returnRate, double additionalContribution,
			int contributionTiming) {
		this.startingAmount = startingAmount;
		this.duration = duration;
		this.returnRate = returnRate;
		this.additionalContribution = additionalContribution;
		this.contributionTiming = contributionTiming;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getStartingAmount() {
		return startingAmount;
	}

	public void setStartingAmount(double startingAmount) {
		this.startingAmount = startingAmount;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getReturnRate() {
		return returnRate;
	}

	public void setReturnRate(double returnRate) {
		this.returnRate = returnRate;
	}

	public double getAdditionalContribution() {
		return additionalContribution;
	}

	public void setAdditionalContribution(double additionalContribution) {
		this.additionalContribution = additionalContribution;
	}

	public int getContributionTiming() {
		return contributionTiming;
	}

	public void setContributionTiming(int contributionTiming) {
		this.contributionTiming = contributionTiming;
	}
	
}
