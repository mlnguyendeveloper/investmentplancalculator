package com.mlnguyendev.investmentplancalculator.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDTO {

	@NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    @NotEmpty
    private String matchingPassword;
    
    @NotEmpty
    @Email
    private String email;
    
	public UserDTO() {
		
	}
	
    public UserDTO(@NotEmpty String username, @NotEmpty String password, @NotEmpty String matchingPassword,
			@NotEmpty @Email String email) {
		this.username = username;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.email = email;
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

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", matchingPassword=" + matchingPassword
				+ ", email=" + email + "]";
	}
    
}
