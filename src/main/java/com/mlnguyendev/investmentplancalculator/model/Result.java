package com.mlnguyendev.investmentplancalculator.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Result {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="end_balance")
	private double endBalance;
	
	@Column(name="starting_amount")
	private double startingAmount;
	
	@Column(name="total_principal")
	private double totalPrincipal;
	
	@Column(name="total_interest")
	private double totalInterest;
	
	public Result() {}

	public Result(double endBalance, double startingAmount, double totalPrincipal, double totalInterest) {
		this.endBalance = endBalance;
		this.startingAmount = startingAmount;
		this.totalPrincipal = totalPrincipal;
		this.totalInterest = totalInterest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getEndBalance() {
		return endBalance;
	}

	public void setEndBalance(double endBalance) {
		this.endBalance = endBalance;
	}

	public double getStartingAmount() {
		return startingAmount;
	}

	public void setStartingAmount(double startingAmount) {
		this.startingAmount = startingAmount;
	}

	public double getTotalPrincipal() {
		return totalPrincipal;
	}

	public void setTotalPrincipal(double totalPrincipal) {
		this.totalPrincipal = totalPrincipal;
	}

	public double getTotalInterest() {
		return totalInterest;
	}

	public void setTotalInterest(double totalInterest) {
		this.totalInterest = totalInterest;
	}
	
}
