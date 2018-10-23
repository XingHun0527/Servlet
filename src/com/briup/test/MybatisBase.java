package com.briup.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.briup.bean.IStudentMapper;
import com.briup.bean.Student;
import com.briup.utils.MybatisSqlSessionFactory;

public class MybatisBase {

	@Test
	public void testEnviroment() throws Exception {
		SqlSessionFactoryBuilder builder=
				new SqlSessionFactoryBuilder();
		SqlSessionFactory factory=
				builder.build(Resources.getResourceAsStream("mybatis-config.xml"), "pro");
		SqlSession sqlSession=
				factory.openSession();
		System.out.println(sqlSession);
		IStudentMapper mapper=sqlSession.getMapper(IStudentMapper.class);
		mapper.saveStudent(new Student(1, "lily", 18, "鑻忓窞"));
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void selectStudent2() {

		SqlSession sqlSession=MybatisSqlSessionFactory.getSqlSession();
		IStudentMapper mapper=sqlSession.getMapper(IStudentMapper.class);
		//mapper.saveStudent(new Student(892,"12",12,"878"));
		Student student=new Student();
		student.setId(888);
		Student student2=mapper.selectStudentById(student);
		System.out.println(student2);
		sqlSession.close();
		
	}

	@Test
	public void selectStudent() {

		try {
			//1.
			SqlSessionFactoryBuilder builder=
					new SqlSessionFactoryBuilder();
			SqlSessionFactory factory=
					builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
			SqlSession sqlSession=factory.openSession();
			
			//2.
			Student student=new Student();
			student.setId(888);
			
			Student student2=sqlSession.selectOne("selectStudentById", student);
			System.out.println(student2);
			//3.
			sqlSession.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void saveStudent() {
		SqlSession sqlSession=null;
		try {
			SqlSessionFactoryBuilder builder=
					new SqlSessionFactoryBuilder();
			InputStream inputStream=
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory=
					builder.build(inputStream);
			sqlSession=factory.openSession();

			//sqlSession.insert("com.briup.bean.IStudentMapper.insertStudent");
			//sqlSession.insert("insertStudent");
//			sqlSession.insert("insertStudent2",new Student(890, "zhangsan", 19, "鏄嗗北"));
			IStudentMapper mapper=
					sqlSession.getMapper(IStudentMapper.class);
//			mapper.saveStudent(new Student());
//			mapper.insertStudent();
			mapper.insertStudent2(new Student(892,"tom",12,"鑻忓窞"));

			sqlSession.commit();
		} catch (Exception e) {
			if(sqlSession!=null) {

				sqlSession.rollback();
			}
			e.printStackTrace();
		}finally {

			if(sqlSession!=null) {

				sqlSession.close();
			}
		}
	}
	
}
