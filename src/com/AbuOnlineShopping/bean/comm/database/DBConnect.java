package com.AbuOnlineShopping.bean.comm.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnection(){    //连接数据库
		Connection conn = null;    //建立连接，初值为空
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();  //获得配置文件接口
			conn = DriverManager.getConnection(Config.CONNECTION_URL,Config.CONNECTION_USER,Config.CONNECTION_PWD);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (conn == null) {
			System.out.println("no get connection!throws Exception");  //没取得连接，打印错误
		}
		return conn;      //取得连接
	}

}


