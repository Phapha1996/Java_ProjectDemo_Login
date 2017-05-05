package dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import utils.JdbcUtils;
import dao_interface.UserDao;
import domain.User;

public class UserDaoJdbcImpl implements UserDao {

	//增加一个用户
	@Override
	public void add(User user){
	
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{	
		con = JdbcUtils.getConnection();
		String sql = "INSERT INTO user(id,username,password,email,birthday,nickname) VALUES (?,?,?,?,?,?)";
		st = con.prepareStatement(sql);
		st.setString(1, user.getId());
		st.setString(2, user.getUsername());
		st.setString(3, user.getPassword());
		st.setString(4, user.getEmail());
		
		if(user.getBirthday()!=null){										//判断传过来的生日是否为空
			st.setDate(5, new java.sql.Date(user.getBirthday().getTime()));
		}else{
			st.setDate(5, null);
		}
		
		st.setString(6, user.getNickname());
		st.executeUpdate();
		
		}catch(Exception e){
			throw new RuntimeException();
		}finally{
			JdbcUtils.release(con, st, rs);
		}
		
	}

	//查找这个用户
	@Override
	public User find(String username, String password) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM user WHERE username=? AND password=?";
			st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			
			rs = st.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				user.setBirthday(rs.getDate("birthday"));
				return user;
			}
			
			return null;
		} catch (Exception e) {
			throw new RuntimeException();
		}finally{
			JdbcUtils.release(con, st, rs);
		}
	
	}

	
	//查找这个用户，只是鉴定是否已经存在
	@Override
	public boolean find(String username) {
	
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "SELECT * FROM user WHERE username=?";
			st = con.prepareStatement(sql);						//对sql语句进行预编译
			st.setString(1, username);							//第一个问号用username替换username
			rs = st.executeQuery();								//发送的是预编译的sql语句
			if(rs.next()){
				return true;
			}
			
		} catch (Exception e) {
			throw new RuntimeException();
		}finally{
			JdbcUtils.release(con, st, rs);
		}
		
		return false;
	}
	
	
	//改一个用户
	

}
