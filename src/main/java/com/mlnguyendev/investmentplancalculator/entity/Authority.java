package com.mlnguyendev.investmentplancalculator.entity;

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
import javax.persistence.Table;

@Entity
@Table(name="authority")
public class Authority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="role")
	private String role;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, 
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.REFRESH})
	@JoinTable(
			name="user_authority",
			joinColumns=@JoinColumn(name="authority_id"),
			inverseJoinColumns=@JoinColumn(name="user_id"))
	private List<User> users;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		if (users==null) {
			users = new ArrayList<>();
		}
		
		users.add(user);
	}
	
}
