package com.briup.dao;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.briup.test.User;
import com.briup.utils.ConnectionFactory;


//涓庢暟鎹簱涓殑s_user琛ㄧ浉瀵瑰簲锛屽鍒犳敼鏌�
public class UserDao {
		
	public void saveUser(User user) throws ClassNotFoundException{	
		try {
			//		1.鑾峰彇杩炴帴瀵硅薄
					Connection connection=ConnectionFactory.getConnection();
			//		2.鑾峰彇PrepartedStatement瀵硅薄
					String sql="insert into s_user(id,name,password,gender) values(t_user_seq.nextval,?,?,?)";
					PreparedStatement pStatement=connection.prepareStatement(sql);
			//		3.鎵цSQL璇彞
					pStatement.setString(1, user.getName());
					pStatement.setString(2, user.getPassword());
					pStatement.setString(3, user.getGender());
					pStatement.executeUpdate();
			//		4.鍏抽棴璧勬簮
					ConnectionFactory.close(connection, pStatement, null);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
	public void updateUser(User user){
		
	}
	
	public void deleteUser(int id){
		
	}
	
	public User selectUserById(int id){
		return null;
		
	}
	
	public List<User> selectAllUser(){
		return null;
		
	}
}
