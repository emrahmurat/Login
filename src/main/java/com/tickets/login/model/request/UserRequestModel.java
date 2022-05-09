package com.tickets.login.model.request;

public class UserRequestModel {
	private int id;
	private String fullName;
	private String birthday;
	private String email;
	private String password;
	public UserRequestModel(int id, String fullName, String birthday, String email, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
	}
	public UserRequestModel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
