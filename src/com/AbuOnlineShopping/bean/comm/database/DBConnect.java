package com.AbuOnlineShopping.bean.comm.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnection(){    //�������ݿ�
		Connection conn = null;    //�������ӣ���ֵΪ��
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();  //��������ļ��ӿ�
			conn = DriverManager.getConnection(Config.CONNECTION_URL,Config.CONNECTION_USER,Config.CONNECTION_PWD);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (conn == null) {
			System.out.println("no get connection!throws Exception");  //ûȡ�����ӣ���ӡ����
		}
		return conn;      //ȡ������
	}

}


