package com.briup.bean;
/**
 * bean
 * utils 
 * web
 * service IUserSerivce
 * 	impl
 * dao IUserDao  mybatis
 * 	impl
 *   
 * dao灞傛帴鍙�
 * */
public interface IStudentMapper {
	/**
	 * 淇濆瓨瀛︾敓淇℃伅 
	 * */
	public void saveStudent(Student student);
	
	public void insertStudent();
	
	public void insertStudent2(Student student);
	
	public Student selectStudentById(Student student);
}
