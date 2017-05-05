package dao.imple;
import java.text.SimpleDateFormat;

import javax.management.RuntimeErrorException;

import org.dom4j.*;

import utils.XmlUtils;
import dao_interface.UserDao;
import domain.User;

public class UserDaoImpl implements UserDao {
	//����һ���û�

	public void add(User user){
	
		try {
			Document document = XmlUtils.getDocument();			//�õ���ǰ�����ݿ����
			Element root = document.getRootElement();			//�ѵ�ǰ���ݿ�����Ԫ�ض���װ��root��
			
			Element user_tag = root.addElement("user");			//�ڵ�ǰroot�м�������user
			user_tag.setAttributeValue("id", user.getId());		//д�����
			user_tag.setAttributeValue("username", user.getUsername());
			user_tag.setAttributeValue("password", user.getPassword());
			user_tag.setAttributeValue("email", user.getEmail());
			user_tag.setAttributeValue("birthday", user.getBirthday()==null?"":user.getBirthday().toLocaleString());
			user_tag.setAttributeValue("nickname", user.getNickname());
			
			XmlUtils.write2Xml(document);				//д�� ���ݿ�
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	//�����ݿ��������һ���û�����Ҫ�����û�����������ֶν��в��ң���¼��

	public User find(String username,String password){					
		try { 
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");     //������û������û�
			
			if(e==null){
				return null;
			}
			
			User user = new User();
			String date = e.attributeValue("birthday");
			
			if(date==null||date.equals("")){
				user.setBirthday(null);
			}
			else{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(df.parse(date));
			}
			
			user.setEmail(e.attributeValue("email"));
			user.setId(e.attributeValue("id"));
			user.setNickname(e.attributeValue("nickname"));
			user.setPassword(e.attributeValue("password"));
			user.setUsername(e.attributeValue("username"));
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	//�ж���ע����û��Ƿ��Ѿ������ݿ��д��ڣ������û����ж�

	public boolean find(String username){
		
		try {
			Document document = XmlUtils.getDocument();
			Element e =(Element) document.selectSingleNode("//user[@username='"+username+"']");		//���Ҳ���
			
			if(e==null){
				return false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
}
