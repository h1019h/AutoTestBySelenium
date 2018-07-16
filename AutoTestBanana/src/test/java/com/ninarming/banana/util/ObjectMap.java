package com.ninarming.banana.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
public class ObjectMap {
	Properties properties;
	String separativeSign = UtilConstant.SEPARATIVESIGN;
	//构造函数，首先传入要读取的文件地址
	public ObjectMap(String propFile){
		properties = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream(propFile);
				properties.load(in);
		
			in.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("读取文件对象出错");
			e.printStackTrace();
		}
		
		
	}
	
	//主要用于元素定位的那个配置文件
	public String getLocator(String ElementNameInpropFile) {
		
		String locator = properties.getProperty(ElementNameInpropFile);
		System.out.println("locator:"+locator);
		
		String locatorType = locator.split(separativeSign)[0];
		String locatorValue = locator.split(separativeSign)[1];
	//	int i=0;
		//配置文件进行转码
		try {
			locatorValue = new String(locatorValue.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("这个文件默认编码格式不是ISO-8859-1");
		}
		//调试作用：
//		System.out.println("获取到的定位类型："+locatorType+" 获取的定位表达式 "+locatorValue);
		//最低的java7版本
		switch(locatorType.toLowerCase()){
		case "id":return "1"+separativeSign+locatorValue;
		case "name":return "2"+separativeSign+locatorValue;
		case "xpath":return "3"+separativeSign+locatorValue;
		case "classname":return "4"+separativeSign+locatorValue;
		case "linktext":return "5"+separativeSign+locatorValue;
		//默认返回需要考虑一下哈
		default:return null; 
		
		}
	}

	
	//不同情况下的用户名和密码的测试数据的配置文件
	public String getUserInfo(String user){
		String info = null;
		return info;
	}
	/**测试这两个代码有没有问题**/
	public void test(String locator){ {
			int locatorType = Integer.parseInt(locator.split(separativeSign)[0]);
			String locatorValue = locator.split(separativeSign)[1];
			switch (locatorType) {
			case 1:System.out.println(locatorValue+"1");break;
			case 2:System.out.println(locatorValue+"2");break;
			// 应该是报错才是
			default:;

			}

		}
	}
}
