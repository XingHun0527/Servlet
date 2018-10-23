package com.briup.test;

public class User {
	private int id;
	private String name;
	private String gender;
	private String password;
	
	
	public User(){
		
	}
	
	


	public User(String name, String gender, String password) {
		super();
		this.name = name;
		this.gender = gender;
		this.password = password;
	}




	public User(int id, String name, String gender, String password) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.password = password;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", password=" + password + "]";
	}
	
	
}
