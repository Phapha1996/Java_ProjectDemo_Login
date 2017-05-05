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
		user.setNickname("���Ƿ�");
		user.setUsername("luoxin");
		user.setEmail("1115054416@qq.com");
		user.setPassword("zhuzhu123.com");
		user.setBirthday(new Date());
		
		try {
			b.register(user);
			System.out.print("ע��ɹ���");
		} catch (UserExistException e) {
			
			System.out.print("ע���˻��Ѿ����ڣ�������");
		}
	}
	
	@Test
	public void ServiceTest2(){
		BusinessService b = new BusinessServiceImpl();
		User user = b.login("luoxin", "zhuzhu123.com");
		if(user==null){
			System.out.println("���ã��������˺Ż��������");
		}
		else{
			System.out.println("��¼�ɹ���");
		}
	}
	

}
