
<%
	session.setAttribute("userId", "1");
%>

<%@ page language="java" contentType="text/html"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="com.AbuOnlineShopping.bean.coin.OderSelectBean"%>
<%@ page import="java.sql.*"%>

<jsp:useBean id="selectOderBean"
	class="com.AbuOnlineShopping.bean.coin.OderSelectBean" scope="request"></jsp:useBean>
<jsp:setProperty property="s_year" name="selectOderBean" param="s_year" />
<jsp:setProperty property="s_month" name="selectOderBean"
	param="s_month" />
<jsp:setProperty property="s_day" name="selectOderBean" param="s_day" />
<jsp:setProperty property="e_year" name="selectOderBean" param="e_year" />
<jsp:setProperty property="e_month" name="selectOderBean"
	param="e_month" />
<jsp:setProperty property="e_day" name="selectOderBean" param="e_day" />
<jsp:setProperty property="status" name="selectOderBean" param="status" />
<jsp:setProperty property="num" name="selectOderBean" param="num" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html; gb2312">
<title>导航</title>
</head>
<body topmargin="0">
	<div align="center">
		<%@ include file="/Coin/left.jsp"%>

		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td height="280" valign="top" bgcolor="#FFFFFF">
				<form name="formal" action="" Method="post">
					<table>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>
								<%
									String id = (String) session.getAttribute("userId");
									StringBuffer result = selectOderBean.selectOder(id);
								%> <%=result %>
							</td>
						</tr>
						<tr>
						<td height="25" align="left" bgcolor="#FFFFFF">
					<span>订单号：</span><span><span><input name="num" size="20"></span></span>
						</td>
						</tr>
						<tr>
						<td height="48" valign="top" bgcolor="#FFFFFF">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
						   <tr>
						   <td height="25">
						   <strong>选择类型：<select name="status">
						   <option selected value="0">请选择</option>
						   <option value="1">正在处理</option>
						   <option value="2">支付成功</option>
						   <option value="3">支付失败</option>
						   </select></strong>
						   </td>
						   </tr>
						   <tr>
						   <td height="25">
						   <strong>充值时间：</strong>
						   </td>
						   </tr>
						   
						   <tr><td height="25" bgcolor="#FFFFFF">
						   起始时间:
						   <select name="s_year">
						   <option selected value="1900">请选择</option>
						   <option>2004</option>
						   <option>2005</option>
						   <option>2006</option>
						   <option>2007</option>
						   </select>
						年
						<select name="s_month">
						<option selected value = "1">请选择</option>
						<option> 1 </option>
						<option> 2 </option>
						<option> 3 </option>
						<option> 4 </option>
						<option> 5 </option>
						<option> 6 </option>
						<option> 7 </option>
						<option> 8 </option>
						<option> 9 </option>
						<option> 10 </option>
						<option> 11 </option>
						<option> 12 </option>
						</select>
						月
						<select name="s_day">
						<option selected value = "1">请选择</option>
						<option> 1 </option>
						<option> 2 </option>
						<option> 3 </option>
						<option> 4 </option>
						<option> 5 </option>
						<option> 6 </option>
						<option> 7 </option>
						<option> 8 </option>
						<option> 19 </option>
						</select>日   截止日期
						<select name="e_year">
						   <option selected value="2099">请选择</option>
						   <option>2004</option>
						   <option>2005</option>
						   <option>2006</option>
						   <option>2007</option>
						   </select>
						年
						<select name="e_month">
						<option selected value = "1">请选择</option>
						<option> 1 </option>
						<option> 2 </option>
						<option> 3 </option>
						<option> 4 </option>
						<option> 5 </option>
						<option> 6 </option>
						<option> 7 </option>
						<option> 8 </option>
						<option> 9 </option>
						<option> 10 </option>
						<option> 11 </option>
						<option> 12 </option>
						</select>
						月
						<select name="e_day">
						<option selected value = "1">请选择</option>
						<option> 1 </option>
						<option> 2 </option>
						<option> 3 </option>
						<option> 4 </option>
						<option> 5 </option>
						<option> 6 </option>
						<option> 7 </option>
						<option> 8 </option>
						<option> 19 </option>
						</select>日
						</td>
						</tr>
						<tr>
						<td><input type="submit" id="button3" name="button3" value="查询" />
						</td>
					     </tr>
					     <tr bgcolor="#DFF1FD">
					     <td height="25" align="center" bgcolor="#FFFFFF">
					     </td>
					    </tr>
					     </table>
					        </td>
					     </tr>
					     </table>
					     </form>
					     </td>
					     <td width="12" align="center">&nbsp;</td>
					     </tr>
					     
					     </div>
					     </body>
					     </html>
					  