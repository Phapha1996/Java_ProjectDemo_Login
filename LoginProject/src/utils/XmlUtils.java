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
//xml�����ࣨ��ǰ����xmlģ��һ�����ݿ⣩
public class XmlUtils {

	private static String filepath;						//xml�����ݿ⣩��λ��
	
	
	static{
		filepath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();			//�õ����xml�ĵ�ַ����̬�ĵõ���
	}
	
	
	public static Document getDocument() throws Exception{
		SAXReader reader = new SAXReader();
		
		Document document = reader.read(new File(filepath));			//������ǰxml�ļ���Ȼ���װ��һ��document������
			
		return document;
	}
	
	
	public static void write2Xml(Document document) throws IOException{			//���Զ�xml�ĵ�����д����
		
		OutputFormat format = OutputFormat.createPrettyPrint();					//���дxml����
		format.setEncoding("UTF-8");											//��utf-8���д��
		XMLWriter writer = new XMLWriter(new FileOutputStream(filepath),format);		
		writer.write(document);		
		writer.close();
	}
	
	
}
