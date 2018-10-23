package com.briup.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.briup.bean.Address;
import com.briup.bean.Customer;
import com.briup.dao.ICustomerMapper;
import com.briup.utils.MybatisSqlSessionFactory;


public class CustomerTest {
	SqlSession sqlSession=null;
	ICustomerMapper mapper=null;
	
	@Before
	public void before() {
		try {
			//璁剧疆閫夌敤鐨勬棩蹇楄褰曟柟娉�
			//LogFactory.useJdkLogging();
//			LogFactory.useLog4JLogging();
//			LogFactory.useSlf4jLogging();
//			LogFactory.useStdOutLogging();
			sqlSession=MybatisSqlSessionFactory.getSqlSession();
			mapper=sqlSession.getMapper(ICustomerMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void commitSession() {
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void saveCustomer() {
		try {
			Customer customer=new Customer();
//			customer.setId(1);
			customer.setUsername("tom");
			customer.setPassword("q22");
			customer.setDob(new Date());
			Address address=new Address("姹熻嫃", "鏄嗗北", "瀛﹂櫌璺�");
			customer.setAddress(address);
			//mapper.saveCustomer(customer);
//			mapper.saveCustomerWithAutoId(customer);
//			mapper.saveCustomerWithAutoIdByOracle1(customer);
			mapper.saveCustomerWithAutoIdByOracle2(customer);
			System.out.println(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void selectCustomer() {
		Customer customer=mapper.selectCustomerById(2);
		System.out.println(customer);
		System.out.println(customer.getAddress().getCity());
	}
	
	@Test
	public void updateCustomer() {
		Customer customer=new Customer();
		customer.setId(1);
		customer.setUsername("tom");
		customer.setPassword("123");
		Address address=new Address("姹熻嫃", "鏄嗗北", "椹瀺灞辫矾");
		customer.setAddress(address);
		mapper.updateCustomer(customer);
	}
	@Test
	public void deleteCustomer() {
		try {
			mapper.deleteCustomerById(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
