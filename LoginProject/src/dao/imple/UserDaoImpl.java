package dao.imple;
import java.text.SimpleDateFormat;

import javax.management.RuntimeErrorException;

import org.dom4j.*;

import utils.XmlUtils;
import dao_interface.UserDao;
import domain.User;

public class UserDaoImpl implements UserDao {
	//增加一名用户

	public void add(User user){
	
		try {
			Document document = XmlUtils.getDocument();			//得到当前的数据库对象
			Element root = document.getRootElement();			//把当前数据库对象的元素都封装到root中
			
			Element user_tag = root.addElement("user");			//在当前root中加入插入的user
			user_tag.setAttributeValue("id", user.getId());		//写入操作
			user_tag.setAttributeValue("username", user.getUsername());
			user_tag.setAttributeValue("password", user.getPassword());
			user_tag.setAttributeValue("email", user.getEmail());
			user_tag.setAttributeValue("birthday", user.getBirthday()==null?"":user.getBirthday().toLocaleString());
			user_tag.setAttributeValue("nickname", user.getNickname());
			
			XmlUtils.write2Xml(document);				//写回 数据库
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	//从数据库里面查找一个用户，主要根据用户名，密码等字段进行查找（登录）

	public User find(String username,String password){					
		try { 
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");     //搜索有没有这个用户
			
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
	
	//判断想注册的用户是否已经在数据库中存在，根据用户名判断

	public boolean find(String username){
		
		try {
			Document document = XmlUtils.getDocument();
			Element e =(Element) document.selectSingleNode("//user[@username='"+username+"']");		//查找操作
			
			if(e==null){
				return false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
}
