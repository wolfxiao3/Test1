<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%
	session.setAttribute("userId", "1");
%>
<%@ page import="com.AbuOnlineShopping.bean.coin.AddcoinSelectBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="selectaddcoinBean"
	class="com.AbuOnlineShopping.bean.coin.AddcoinSelectBean"
	scope="request">
</jsp:useBean>

<jsp:setProperty property="s_year" name="selectaddcoinBean"
	param="s_year" />
<jsp:setProperty property="s_month" name="selectaddcoinBean"
	param="s_month" />
<jsp:setProperty property="s_day" name="selectaddcoinBean" param="s_day" />
<jsp:setProperty property="e_year" name="selectaddcoinBean"
	param="e_year" />
<jsp:setProperty property="e_month" name="selectaddcoinBean"
	param="e_month" />
<jsp:setProperty property="e_day" name="selectaddcoinBean" param="e_day" />
<jsp:setProperty property="type" name="selectaddcoinBean" param="type" />
<jsp:setProperty property="num" name="selectaddcoinBean" param="num" />

<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html">
<title>导航</title>
</head>
<body topmargin="0">
<form action="" method="post">
	<div align="center">
		<%@ include file="/Coin/left.jsp"%>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><table>
					<tr>
						<td>您的充值情况如下：</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td>
				<%
				String id = (String) session.getAttribute("userId");
				StringBuffer result = selectaddcoinBean.selectAddcoin(id);
			%> <%=result%>
			</td>

		</tr>
		<tr>
			<td><table>
					<tr>
						<td><span>查询</span></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><table>
					<tr>
						<td><span>充值类型</span> <select name="type">
								<option selected value="0">所有类型</option>
								<option value="1">在线充值</option>
								<option value="2">个人银行充值</option>
								<option value="3">代理充值</option>
								<option value="4">汇款充值</option>
						</select></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><span>充值编号：</span> <span><span><input
						name="num"></span></span></td>
		</tr>
		<tr>
		<tr>
			<td><table>
					<tr>
						<td><strong>充值时间：</strong></td>
					</tr>
					<tr>
						<td>起始时间：<select name="s_year">
								<option selected value="1900">请选择</option>
								<option>2005</option>
								<option>2006</option>
								<option>2007</option>
						</select>年 <select name="s_month">
								<option selected value="1">请选择</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
								<option>11</option>
								<option>12</option>
						</select>月 <select name="s_day">
								<option selected value="1">请选择</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
						</select>日 -截止日期： <select name="e_year">
								<option selected value="2099">请选择</option>
								<option>2005</option>
								<option>2006</option>
								<option>2007</option>
								<option>2008</option>
						</select>年 <select name="e_month">
								<option selected value="1">请选择</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
						</select>月 <select name="e_day">
								<option selected value="1">请选择</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
								<option>10</option>
								<option>11</option>
						</select>日 <input type="Submit" name="button1" value="查询" />
						</td>
					</tr>
				</table></td>
				
		</tr>
		



	</div>
</form>
</body>
</html>