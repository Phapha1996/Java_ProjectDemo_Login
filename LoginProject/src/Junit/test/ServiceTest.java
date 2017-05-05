package Junit.test;

import java.util.Date;

import org.junit.Test;

import service.imple.BusinessServiceImpl;
import service_interface.BusinessService;
import dao.imple.UserDaoImpl;
import dao_interface.UserDao;
import domain.User;
import exception.UserExistException;

public class ServiceTest {

	@Test
	public void ServiceTest() {
		BusinessService b = new BusinessServiceImpl();
		User user = new User();
		user.setId("3140767117");
		user.setNickname("蔡智法");
		user.setUsername("luoxin");
		user.setEmail("1115054416@qq.com");
		user.setPassword("zhuzhu123.com");
		user.setBirthday(new Date());
		
		try {
			b.register(user);
			System.out.print("注册成功！");
		} catch (UserExistException e) {
			
			System.out.print("注册账户已经存在！！！！");
		}
	}
	
	@Test
	public void ServiceTest2(){
		BusinessService b = new BusinessServiceImpl();
		User user = b.login("luoxin", "zhuzhu123.com");
		if(user==null){
			System.out.println("您好，您输入账号或密码错误！");
		}
		else{
			System.out.println("登录成功！");
		}
	}
	

}
