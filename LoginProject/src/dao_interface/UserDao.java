package dao_interface;

import domain.User;

public interface UserDao {

	//增加一名用户
	public  void add(User user);

	//从数据库里面查找一个用户<登录>
	public  User find(String username, String password);

	//查找想注册的用户是否已经在数据库中存在
	public  boolean find(String username);

}