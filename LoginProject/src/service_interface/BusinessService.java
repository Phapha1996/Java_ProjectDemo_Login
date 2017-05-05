package service_interface;

import domain.User;
import exception.UserExistException;

public interface BusinessService {

	//ע��
	public void register(User user) throws UserExistException;

	//��¼
	public User login(String username, String password);

}