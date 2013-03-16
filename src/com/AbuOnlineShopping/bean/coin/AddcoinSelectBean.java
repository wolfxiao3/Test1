package com.AbuOnlineShopping.bean.coin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.AbuOnlineShopping.bean.comm.database.DBConnect;

public class AddcoinSelectBean {
	String s_year = "1900", s_month = "1", s_day = "1", e_year = "2099",
			e_month = "12", e_day = "30", type = "0", num = null;

	public AddcoinSelectBean() {

	}

	public void setType(String type) {
		this.type = type;
	}

	public void setNum(String num) {
		this.num = num;
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

	public StringBuffer selectAddcoin(String userId) {
		String type1 = null;
		int j = Integer.parseInt(type);
		switch (j) {
		case 0:
			type1 = "Any";
			break;
		case 1:
			type1 = "在线充值";
			break;
		case 2:
			type1 = "代理充值";
			break;
		case 3:
			type1 = "汇款充值";
			break;
		case 4:
			type1 = "个人银行充值";
			break;
		}
		String s_date = s_year + "-" + s_month + "-" + s_day;
		String e_date = e_year + "-" + e_month + "-" + e_day;
		String condition;
		if (num != null) {
			condition = "select add_id,type,coin date_time from add_money where user_id ='"
					+ userId + "'and add_id=" + num + "";
		} else {
			condition = "select add_id,type,coin,date_time from add_money where user_id = '"
					+ userId
					+ "'and date_time<='"
					+ e_date
					+ "'and date_time>='" + s_date + "'";
			if (j != 0) {
				condition += "and type ='" + type1 + "'";
			}
		}
        ResultSet rs = null;
        Statement sql = null;
        String type, coin, date, num;
        StringBuffer buffer = new StringBuffer();
        try{
        	Connection conn = DBConnect.getConnection();
        	sql= conn.createStatement();
        	rs = sql.executeQuery(condition);
        	buffer.append("<table>");
        	buffer.append("<tr>");
        	buffer.append("<td>充值编号</td>");
        	buffer.append("<td>充值类型</td>");
        	buffer.append("<td>充值金额</td>");
        	buffer.append("<td>充值时间</td>");
        	buffer.append("</tr>");
        	while(rs.next()){
        		buffer.append("<tr>");
        		num = rs.getString(1);
        		buffer.append("<td>"+num+"</td>");
        		type = rs.getString(2);
        		buffer.append("<td>"+type+"</td>");
        		coin = rs.getString(3);
        		buffer.append("<td>"+coin+"</td>");
        		date = rs.getString(4);
        		buffer.append("<td>"+date+"</td>");
        	}
        	buffer.append("</table>");
        	rs.close();
        	sql.close();
        	conn.close();
        	
        }catch(SQLException e){
        	e.printStackTrace();
        }
        return buffer;
        
	}
}
