package com.briup.bean;

/**
 * 数据库的类型：   Java中类型：
 * 	number         整数 浮点数
 *  varchar2       String
 *  date           java.sql.Date
 *  
 *  JDBC 
 *  		处理结果集
 *  		 select id,name,age from briup_student where id=1;
 *  		 while(rs.next()){
 *  			Integer id=rs.getInteger("id");
 *  			String name=rs.getString("name");
 *  		}
 *  
 * 
 * 
 * */
public class Student {
	private Integer id;
	private String name;
	private int age;
	private String address;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(Integer id, String name, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Student(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	
	
}
