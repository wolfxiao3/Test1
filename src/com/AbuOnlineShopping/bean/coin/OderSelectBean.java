package com.AbuOnlineShopping.bean.coin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.AbuOnlineShopping.bean.comm.database.DBConnect;

public class OderSelectBean {
	private String s_year = "1950";
	private String s_month = "1";
	private String s_day = "1";
	private String e_year = "2099";
	private String e_month = "1";
	private String e_day = "1";
	private String status = "0";
	private String num = null;
	
	public OderSelectBean(){
		
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

	public void setStatus(String status) {
		this.status = status;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	public StringBuffer selectOder(String userId){
		String oderType = null;
		int j = Integer.parseInt(status);
		switch (j){
		case 0:
			oderType = "Any"; break;
		case 1:
			oderType = "正在处理";break;
		case 2:
			oderType = "支付成功";break;
		case 3:
			oderType = "支付失败";break;
		}
		
		String s_date = s_year+"-"+s_month+"-"+s_day;
		
		String e_date = e_year+"-"+e_month+"-"+e_day;
		
		String condition;
		
		if(num != null){
			condition = "select oderId,type,price,date_time,productName from oder where userId = '"+userId+"'and oderId='"+num+"'";}
		else{
			condition = "select oderId,type,price,date_time,productName from oder where userId ='"+userId+"'and date_time<='"+e_date+"'and date_time>='"+s_date+ "'";
		   if(j != 0){
			   condition += "and type='" + oderType + "'";}
		}
		ResultSet rs = null;
		Statement sql = null;
		String num,status,date,coin,name;
		StringBuffer buffer = new StringBuffer();
		try{
			Connection conn = DBConnect.getConnection();
			sql = conn.createStatement();
			rs = sql.executeQuery(condition);

			buffer.append("<table>");
			buffer.append("<tr>");
			buffer.append("<td>订单号</td>");
			buffer.append("<td>订单状态</td>");
			buffer.append("<td>金额</td>");
			buffer.append("<td>订单创建时间</td>");
			buffer.append("<td>订购商品名称</td>");
			buffer.append("</tr>");
			while(rs.next()){
				buffer.append("<tr>");
				num = rs.getString(1);
				status = rs.getString(2);
				coin = rs.getString(3);
				date = rs.getString(4);
				name = rs.getString(5);
				buffer.append("<td>"+num+"</td>");
				buffer.append("<td>"+status+"</td>");
				buffer.append("<td>"+coin+"</td>");
				buffer.append("<td>"+date+"</td>");
				buffer.append("<td>"+name+"</td>");
				buffer.append("</tr>");
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
