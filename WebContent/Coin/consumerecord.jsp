<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%
	session.setAttribute("userId", "1");
%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.AbuOnlineShopping.bean.coin.AllConsumeSelectBean"%>
<jsp:useBean id="selectBean"
	class="com.AbuOnlineShopping.bean.coin.AllConsumeSelectBean"
	scope="request"></jsp:useBean>
	<jsp:setProperty property="s_year" name="selectBean"
	param="s_year" />
<jsp:setProperty property="s_month" name="selectBean"
	param="s_month" />
<jsp:setProperty property="s_day" name="selectBean" param="s_day" />
<jsp:setProperty property="e_year" name="selectBean"
	param="e_year" />
<jsp:setProperty property="e_month" name="selectBean"
	param="e_month" />
<jsp:setProperty property="e_day" name="selectBean" param="e_day" />
<jsp:setProperty property="type" name="selectBean" param="type" />
<jsp:setProperty property="num" name="selectBean" param="num" />
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
<body>
	<form action="" method="post">
		<div align="center">

			<%@include file="/Coin/left.jsp"%>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><table>
						<tr>
							<td><span>您的消费记录如下：</span></td>
						</tr>
						<tr>
							<td>
								<%
									String id = (String) session.getAttribute("userId");
									StringBuffer result = selectBean.selectConsume(id);
								%> <%=result%></td>
						</tr>
						<tr>
							<td><span>查询</span></td>
						</tr>
						<tr>
							<td>
								<table></table>
							</td>
						</tr>
						<tr>
							<td><span>消费记录编号：</span><span><span><input
										name="num"></span></span></td>
						</tr>
						<tr>
							<td><table>
							<tr>
							<td><strong>消费时间：</strong>
							</td>
							</tr>
									<tr>
										<td>起始时间: <select name="s_year">
												<option selected value="1900">请选择</option>
												<option>2005</option>
												<option>2006</option>
												<option>2007</option>
												<option>2008</option>
										</select>年 <select name="s_month">
												<option selected value="1">请选择</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
												<option>6</option>
												<option>7</option>
												<option>8</option>
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
												<option>11</option>
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
												<option>8</option>
												<option>9</option>
												<option>10</option>
												<option>11</option>
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
												<option>12</option>
												<option>13</option>
										</select>日
										</td>
									</tr>
									<td>&nbsp;<input type="submit" name="button1" value="查询" />
									</td>
									<tr>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>

		</div>
	</FORM>
</body>
</html>
