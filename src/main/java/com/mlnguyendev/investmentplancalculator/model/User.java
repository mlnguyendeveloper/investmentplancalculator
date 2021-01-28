package com.mlnguyendev.investmentplancalculator.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="username",
			unique=true)
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email",
			unique=true)
	private String email;
	
	@ManyToMany(fetch=FetchType.EAGER,
			cascade= {CascadeType.PERSIST, 
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.REFRESH})
	@JoinTable(
			name="user_authority",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="authority_id"))
	private List<Authority> authorities;
	
	@OneToMany(cascade=CascadeType.ALL,
			fetch=FetchType.LAZY)
	@JoinColumn(name="plan_id")
	private List<Plan> plans;
	
	@Column(name="enabled")
	private boolean enabled;
	
	public User() {
		
	}

	public User(String username, String password, String email, List<Authority> authorities, boolean enabled) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.authorities = authorities;
		this.enabled = enabled;
	}
	
	public User(String username, String password, String email, List<Authority> authorities, List<Plan> plans,
			boolean enabled) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.authorities = authorities;
		this.plans = plans;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Authority> getAuthorities() {
		return authorities;
	}
	
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public void addAuthority(Authority authority) {
		if (authorities == null) {
			authorities = new ArrayList<>();
		}
		authorities.add(authority);
	}
	
	public void addPlan(Plan plan) {
		if (plans == null) {
			plans = new ArrayList<>();
		}
		plans.add(plan);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", authorities=" + authorities.size() + ", plans=" + plans.size() + ", enabled=" + enabled + "]";
	}

}
