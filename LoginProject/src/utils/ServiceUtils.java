package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import sun.misc.*;



public class ServiceUtils {

	//MD5¼ÓÃÜ
	public static String md5(String message){
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(message.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			
			return encoder.encode(md5);
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}	
	}
	
	//UUID²úÉúid
	public static String getID(){
		return UUID.randomUUID().toString();
	}
	
	
}
