package com.AbuOnlineShopping.bean.coin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.AbuOnlineShopping.bean.comm.database.DBConnect;

public class ConsumeSelectBean {
	public ConsumeSelectBean(){     //构造函数，写不写都会有
		
	}
	
	public StringBuffer selectConsume(String userId){
		String condition = "select count(userId) as num, productName, sun(price) as total from consume where userId ='"+userId+"'group by productName";
		ResultSet rs = null;
		Statement sql = null;
		StringBuffer buffer = new StringBuffer();
		String num, name, coin;
		try{
			Connection conn = DBConnect.getConnection();
			sql = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = sql.executeQuery(condition);
			while(rs.next()){
				
				num = rs.getString(1);
				name = rs.getString(2);
				coin = rs.getString(3);
				buffer.append(num + "个" + name +"," + "金额:" + coin + "<br>");
			}
			rs.close();
			sql.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return buffer;
	}
	
}
