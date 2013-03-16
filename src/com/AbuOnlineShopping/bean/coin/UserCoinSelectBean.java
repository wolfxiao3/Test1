package com.AbuOnlineShopping.bean.coin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.AbuOnlineShopping.bean.comm.database.DBConnect;

public class UserCoinSelectBean {
	public String selectUserCoin(String ID, int i){   //查询用户基本信息
		String condition = null;
		if(i == 0){     //如果为i为0，则表示查询货币余额
			condition = "select coin from user where id =' " + ID + "'";
		}
		if(i == 1){    //如果i为1，表示查询消费金额
			condition = "select consum from user where id =' " + ID + "'";
		}
		if(i == 2){     //如果i为2，表示查询货币总额
			condition = "select consum+coin from user where id =' " + ID + "'";
		}
		if(i == 3){     //如果为3，表示查询用户姓名
			condition = "select name from user where id =' " + ID + "'";
		}
		if(i == 4){    //如果为4，表示查询用户类型
			condition = "select type from user where id ='" + ID + "'";
		}
		ResultSet rs = null;
		Statement sql = null;
		String str = new String();
		try{
			Connection conn = DBConnect.getConnection();     //建立连接
			sql = conn.createStatement();       //建立Statement
			rs = sql.executeQuery(condition);  //执行数据库查询
			while (rs.next()){
				str = rs.getString(1);      //取得ResultSet第一字段
			}
			rs.close();          //关闭ResultSet
			sql.close();       //关闭statement
			conn.close();     //关闭连接
		}catch(SQLException e){
			e.printStackTrace();     //跟踪异常
		}
		return str;       //返回查询结果
	}

}
