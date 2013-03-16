
<%
	session.setAttribute("userId", "1");
%>
<%@ page language="java" contentType="text/html"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="selectUserCoinBean"
	class="com.AbuOnlineShopping.bean.coin.UserCoinSelectBean"></jsp:useBean>
<jsp:useBean id="consume"
	class="com.AbuOnlineShopping.bean.coin.ConsumeSelectBean"></jsp:useBean>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<
<style type="text/css">
<!--
@import url("../Buy/style/cal/rightcal_style02.css");
-->
</style>
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航</title>
</head>
<body topmargin="0">
	<%
		String id = (String) session.getAttribute("userId");
		String Balance = selectUserCoinBean.selectUserCoin(id, 0);
		String Consume = selectUserCoinBean.selectUserCoin(id, 1);
		String All = selectUserCoinBean.selectUserCoin(id, 2);
		String Name = selectUserCoinBean.selectUserCoin(id, 3);
		String type = selectUserCoinBean.selectUserCoin(id, 4);
	%>

	<div align="center">
		<%@ include file="/Coin/left.jsp"%>
		<tr>
			<td width="10" rowspan="7" align="center">&nbsp;</td>
			<td height="10" colspan="2" align="center">&nbsp;</td>
		</tr>
		<tr>
			<td height="25" class="cal_content02">
				<table width="100%" height="25" border="0" cellpadding="0"
					cellspace="0" class="left_td01">
					<tr>
						<td class="left_td1"><%=Name%>您好，您的用户状态：<%=type%></td>
					</tr>
				</table>
			</td>
			<td width="12" rowspace="6" align="center">&nbsp;</td>
		</tr>
		<tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="1"
					class="left_content">
					<tr>
						<td width="45%" height="20" class="cal_td06">累计充值：<%=All%>电子货币
						</td>
					</tr>
					<tr>
						<td heigth="20" class="cal_td06">累计消费：<%=Consume%> 电子货币
						</td>
					</tr>
					<tr>
						<td heigt="20" class="cal_td06">账户余额：<%=Balance%> 电子货币
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="25" class="left_content">目前您的总消费金额为：<%=Consume%>电子货币。记录如下：
						</td>
					</tr>
					<tr>
						<td class="left_content">
							<table width="100%" height="75" border="0" cellpadding="0"
								cellspacing="0">
								<tr>
									<%
										StringBuffer buffer = consume.selectConsume(id);
									%>
									<%=buffer%>
								</tr>
							</table>
						</td>
					</tr>


				</table>
	</div>

</body>
</html>