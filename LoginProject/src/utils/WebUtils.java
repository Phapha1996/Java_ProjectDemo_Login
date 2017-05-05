package utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import web.formbean.RegisterForm;



import domain.User;


public class WebUtils {

	//��request�����ݷ�װ��bean��
	public static <T> T requestToBean(HttpServletRequest request,Class<T> beanClass){
		
		
		try{
			T bean= beanClass.newInstance();		//����Ҫ��װ���ݵ�bean
			Enumeration e = request.getParameterNames();		//��request�����ݷ�װ��bean��
			while(e.hasMoreElements()){
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		}catch(Exception e){
		 throw new RuntimeException();
		}

	}
	
	
	//����bean����BeanUtils
	public static void copyBean(Object src,Object dest){
		ConvertUtils.register(new Converter(){							//���¶���BeanUtils������������������ַ���֮���ת��
			public Object convert(Class type,Object value){

				if(value==null)
					return null;
				String str = (String)value;
				if(str.trim().equals(""))
					return null;
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
					
				} catch (java.text.ParseException e) {	
					throw new RuntimeException();
				}
			}
		
		},Date.class);
		
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (IllegalAccessException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
	}

	
	//����һ��40�������Ҳ����ڶ�����ID��
	public static String generateID(){
		
		return UUID.randomUUID().toString();
	
	}
	
	


	public static void bean1tobean2(User bean2,RegisterForm bean1){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		bean2.setUsername(bean1.getUsername());
		bean2.setPassword(bean1.getPassword());
		bean2.setEmail(bean1.getEmail());
		bean2.setNickname(bean1.getNickname());
		
		if(bean1.getBirthday()==null||bean1.getBirthday().trim().equals("")){
			bean2.setBirthday(null);
		}
		else{	
		try {
			bean2.setBirthday(df.parse(bean1.getBirthday()));
			
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		
		}
	}

}
