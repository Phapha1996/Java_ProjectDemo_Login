package Junit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import org.junit.Test;

import utils.WebUtils;
import dao.imple.UserDaoJdbcImpl;
import dao_interface.UserDao;
import domain.User;

public class DaoJdbcTest {

	@Test
	public void testAdd(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		UserDao dao  = new UserDaoJdbcImpl();
		User user = new User();
		user.setId(WebUtils.generateID());
		user.setUsername("anbei");
		user.setPassword("hahaha");
		user.setEmail("111fa@qq.com");
		user.setNickname("°²±¶");
		dao.add(user);
	
	
	}
}
