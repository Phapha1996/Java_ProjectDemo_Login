package dao_interface;

import domain.User;

public interface UserDao {

	//����һ���û�
	public  void add(User user);

	//�����ݿ��������һ���û�<��¼>
	public  User find(String username, String password);

	//������ע����û��Ƿ��Ѿ������ݿ��д���
	public  boolean find(String username);

}