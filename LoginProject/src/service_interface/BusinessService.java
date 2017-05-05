package service_interface;

import domain.User;
import exception.UserExistException;

public interface BusinessService {

	//×¢²á
	public void register(User user) throws UserExistException;

	//µÇÂ¼
	public User login(String username, String password);

}