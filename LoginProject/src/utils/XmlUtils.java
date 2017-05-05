package utils;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
//xml工具类（当前是用xml模拟一个数据库）
public class XmlUtils {

	private static String filepath;						//xml（数据库）的位置
	
	
	static{
		filepath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();			//得到这个xml的地址（动态的得到）
	}
	
	
	public static Document getDocument() throws Exception{
		SAXReader reader = new SAXReader();
		
		Document document = reader.read(new File(filepath));			//读出当前xml文件，然后封装到一个document对象当中
			
		return document;
	}
	
	
	public static void write2Xml(Document document) throws IOException{			//可以对xml文档进行写操作
		
		OutputFormat format = OutputFormat.createPrettyPrint();					//获得写xml的流
		format.setEncoding("UTF-8");											//以utf-8码表写入
		XMLWriter writer = new XMLWriter(new FileOutputStream(filepath),format);		
		writer.write(document);		
		writer.close();
	}
	
	
}
