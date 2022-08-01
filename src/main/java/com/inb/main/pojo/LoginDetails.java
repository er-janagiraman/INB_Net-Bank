package com.inb.main.pojo;

public class LoginDetails {
	private String userId;
	private String password;
	private String role;

	public LoginDetails() {
		// TODO Auto-generated constructor stub
	}

	public LoginDetails(String userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginDetails [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}

}
