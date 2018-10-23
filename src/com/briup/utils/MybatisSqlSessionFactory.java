package com.briup.utils;

import java.io.IOException;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * 鐢ㄦ潵鑾峰彇SqlSession瀵硅�? 
 * */
public class MybatisSqlSessionFactory {
	private static SqlSessionFactory factory;
	static {
		try {
			SqlSessionFactoryBuilder builder=
					new SqlSessionFactoryBuilder();
			factory=
					builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		//涓嶈繘琛岃嚜鍔ㄦ彁浜や簨鍔�
		return getSqlSession(false);
	}
	public static SqlSession getSqlSession(boolean autoCommit) {
		SqlSession sqlSession=null;
		if(factory!=null) {
			sqlSession = factory.openSession(autoCommit);
		}
		return sqlSession;
	}
	
//	public static SqlSessionFactory getFactory() {
//		SqlSessionFactoryBuilder builder=
//				new SqlSessionFactoryBuilder();
//		//鐩稿綋浜嶺ML閰嶇疆鏂囦欢涓殑鏍规爣绛�
//		Configuration config=new Configuration();
//		TransactionFactory transactionFactory=new JdbcTransactionFactory();
//		DataSource dataSource=DataSourceFactory.getDataSource();
//		Environment oracle=new Environment("oracle", transactionFactory, dataSource);
//		Environment mysql=new Environment("mysql", transactionFactory, dataSource);
//		config.setEnvironment(oracle);
//		config.setEnvironment(mysql);
//		config.getTypeAliasRegistry().registerAlias(Student.class);
//		config.getTypeHandlerRegistry().register(AddressHandler.class);
//		config.addMapper(ICustomerMapper.class);
////		factory=builder.build(config);
//		return factory;
//	}	
}
