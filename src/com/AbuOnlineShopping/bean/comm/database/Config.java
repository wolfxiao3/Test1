package com.AbuOnlineShopping.bean.comm.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private static Properties prop = new Properties();
	static{
		try{
			prop.load(new FileInputStream("d://eclipse/workspace/AbuOnlineShopping/src/com/AbuOnlineShopping/bean/comm/database/config.properties"));
			//获得配置文件
		}catch (IOException e){
			e.printStackTrace();//抛出异常
		}
	}
	//获得相关数据库的连接信息
	public static String CONNECTION_TYPE = prop.getProperty("conn_type");
	public static String CONNECTION_URL = prop.getProperty("conn_url");
	public static String CONNECTION_USER = prop.getProperty("conn_user");
	public static String CONNECTION_PWD = prop.getProperty("conn_pwd");
	public static String CONNECTION_DRIVER = prop.getProperty("conn_driver");

}
