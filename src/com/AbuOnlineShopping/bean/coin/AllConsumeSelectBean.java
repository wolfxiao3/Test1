package com.AbuOnlineShopping.bean.coin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.AbuOnlineShopping.bean.comm.database.DBConnect;

public class AllConsumeSelectBean {
	String s_year = "1900", s_month = "1", s_day = "1", e_year = "2099",
			e_month = "12", e_day = "31", num = null, type = "0";

	public AllConsumeSelectBean() {

	}

	public void setS_year(String s_year) {
		this.s_year = s_year;
	}

	public void setS_month(String s_month) {
		this.s_month = s_month;
	}

	public void setS_day(String s_day) {
		this.s_day = s_day;
	}

	public void setE_year(String e_year) {
		this.e_year = e_year;
	}

	public void setE_month(String e_month) {
		this.e_month = e_month;
	}

	public void setE_day(String e_day) {
		this.e_day = e_day;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public void setType(String type) {
		this.type = type;
	}

	public StringBuffer selectConsume(String userId) {
		String s_date = s_year + "-" + s_month + "-" + s_day;
		String e_date = e_year + "-" + e_month + "-" + e_day;
		String condition;
		if (num != null) {
			condition = "select consumeId,productName,price,date_time from consume where userId= '"
					+ userId + "' and consumeId = " + num + "";
		} else {
			condition = "select consumeId,productName,price,date_time from consume where userId= '"
					+ userId
					+ "' and date_time<='"
					+ e_date
					+ "'and date_time>='"
					+ s_date + "'";
		}
		
		ResultSet rs = null;
		Statement sql = null;
		String name,coin,date,num;
		
		StringBuffer buffer = new StringBuffer();
		try {
			Connection conn = DBConnect.getConnection();
			sql = conn.createStatement();
			rs = sql.executeQuery(condition);
			buffer.append("<table>");
			buffer.append("<tr>");
			buffer.append("<td>消费记录编号</td>");
			buffer.append("<td>商品名称</td>");
			buffer.append("<td>商品价格</td>");
			buffer.append("<td>购买日期</td>");
			buffer.append("</tr>");
			while(rs.next()){
				buffer.append("<tr>");
				num = rs.getString(1);
				buffer.append("<td>"+num+"</td>");
				name = rs.getString(2);
				buffer.append("<td>"+name+"</td>");
				coin = rs.getString(3);
				buffer.append("<td>"+coin+"</td>");
				date = rs.getString(4);
				buffer.append("<td>"+date+"</td>");
				buffer.append("</tr>");
			}
			buffer.append("</table>");
			rs.close();
			sql.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buffer;
	}
}
