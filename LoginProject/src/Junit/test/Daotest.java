package Junit.test;

import java.util.Date;

import org.junit.Test;

import dao.imple.UserDaoImpl;
import dao_interface.UserDao;
import domain.User;

public class Daotest {

	@Test
	public void UserDaoTest(){
		
	User user = new User();
	UserDao dao = new UserDaoImpl();
	user.setId("3140767117");
	user.setNickname("≤Ã÷«∑®");
	user.setUsername("fage");
	user.setEmail("1115054416@qq.com");
	user.setPassword("zhuzhu123.com");
	user.setBirthday(new Date());
	dao.add(user);
	}
	
	@Test
	public void UserSerchTest(){
		UserDao dao = new UserDaoImpl();
		User user = dao.find("fage", "zhuzhu123.com");
		String nickname = user.getNickname();
	}
}
