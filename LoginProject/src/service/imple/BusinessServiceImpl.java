package service.imple;

import service_interface.BusinessService;
import utils.ServiceUtils;
import dao.imple.UserDaoImpl;
import dao.imple.UserDaoJdbcImpl;
import dao_interface.UserDao;
import domain.User;
import exception.UserExistException;
import factory.DaoFactory;
//对web层提供所有的业务服务
public class BusinessServiceImpl implements BusinessService {

	private UserDao dao = DaoFactory.getInstance().createUserDao();
	
	
	//注册
	
	public void register(User user) throws UserExistException{
	
		boolean b = dao.find(user.getUsername());								//判断当前用户是否存在
		//String username123= user.getUsername();		null
		
		if(b){
			throw new UserExistException();
		}
		else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));				//加密后的密码
			dao.add(user) ;
		}
		
	}
	
	
	//登录
	
	public User login(String username,String password){
	
		password = ServiceUtils.md5(password);								//加密之后再跟数据库进行对照    
		
		return dao.find(username, password);
	}
	
	
	
}
