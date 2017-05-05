package service.imple;

import service_interface.BusinessService;
import utils.ServiceUtils;
import dao.imple.UserDaoImpl;
import dao.imple.UserDaoJdbcImpl;
import dao_interface.UserDao;
import domain.User;
import exception.UserExistException;
import factory.DaoFactory;
//��web���ṩ���е�ҵ�����
public class BusinessServiceImpl implements BusinessService {

	private UserDao dao = DaoFactory.getInstance().createUserDao();
	
	
	//ע��
	
	public void register(User user) throws UserExistException{
	
		boolean b = dao.find(user.getUsername());								//�жϵ�ǰ�û��Ƿ����
		//String username123= user.getUsername();		null
		
		if(b){
			throw new UserExistException();
		}
		else{
			user.setPassword(ServiceUtils.md5(user.getPassword()));				//���ܺ������
			dao.add(user) ;
		}
		
	}
	
	
	//��¼
	
	public User login(String username,String password){
	
		password = ServiceUtils.md5(password);								//����֮���ٸ����ݿ���ж���    
		
		return dao.find(username, password);
	}
	
	
	
}
