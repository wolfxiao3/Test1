package com.AbuOnlineShopping.bean.coin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.AbuOnlineShopping.bean.comm.database.DBConnect;

public class UserCoinSelectBean {
	public String selectUserCoin(String ID, int i){   //��ѯ�û�������Ϣ
		String condition = null;
		if(i == 0){     //���ΪiΪ0�����ʾ��ѯ�������
			condition = "select coin from user where id =' " + ID + "'";
		}
		if(i == 1){    //���iΪ1����ʾ��ѯ���ѽ��
			condition = "select consum from user where id =' " + ID + "'";
		}
		if(i == 2){     //���iΪ2����ʾ��ѯ�����ܶ�
			condition = "select consum+coin from user where id =' " + ID + "'";
		}
		if(i == 3){     //���Ϊ3����ʾ��ѯ�û�����
			condition = "select name from user where id =' " + ID + "'";
		}
		if(i == 4){    //���Ϊ4����ʾ��ѯ�û�����
			condition = "select type from user where id ='" + ID + "'";
		}
		ResultSet rs = null;
		Statement sql = null;
		String str = new String();
		try{
			Connection conn = DBConnect.getConnection();     //��������
			sql = conn.createStatement();       //����Statement
			rs = sql.executeQuery(condition);  //ִ�����ݿ��ѯ
			while (rs.next()){
				str = rs.getString(1);      //ȡ��ResultSet��һ�ֶ�
			}
			rs.close();          //�ر�ResultSet
			sql.close();       //�ر�statement
			conn.close();     //�ر�����
		}catch(SQLException e){
			e.printStackTrace();     //�����쳣
		}
		return str;       //���ز�ѯ���
	}

}
