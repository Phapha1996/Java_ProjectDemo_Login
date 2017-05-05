package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import dao_interface.UserDao;

public class DaoFactory {

	private UserDao userdao = null;
	private static final DaoFactory instance = new DaoFactory(); 	
	
	
	private DaoFactory(){
		try{
		InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		Properties pro = new Properties();
		pro.load(in);
		String daoclassName = pro.getProperty("userdao");
		userdao = (UserDao) Class.forName(daoclassName).newInstance();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
	}
	
	
	public static DaoFactory getInstance(){
		return instance;
	}
	
	
	public UserDao createUserDao(){
		
		return userdao;
	}
	
	
}
