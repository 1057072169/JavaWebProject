<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/default.css" />
<link rel="stylesheet" type="text/css" href="../css/modify.css" />
<body>
	<script type="text/javascript" src="../js/Calendar3.js"></script>
	<div id="navi">
		<div id='naviDiv'>
			<span><img src="../images/arror.gif" width="7" height="11"
				border="0" alt=""></span>&nbsp;书籍管理<span>&nbsp; <span><img
					src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a
				href="<%=path%>/books/Books_query.action">书籍列表</a><span>&nbsp;
			
		</div>
	</div>
	<div id="tips"></div>
	<div id="mainContainer">
		<!-- 从session中获取学生集合 -->
		<strong>修改书籍资料</strong> <br> <br>
		<form name="modifyForm" action="<%=path%>/books/Books_save.action"
			method="post">
			<table width="400">
				<tr>
					<td width="30%">编号：</td>
					<td><input type="text" name="sid"
						value='<s:property value="#session.modify_books.sid"/>'
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td width="30%">书名：</td>
					<td><input type="text" name="sname"
						value='<s:property value="#session.modify_books.sname"/>' /></td>
				</tr>
				<tr>
					<td>最近出借日期：</td>
					<td><input name="loandate" type="text" id="control_date"
						size="20" maxlength="10" onclick="new Calendar().show(this);"
						readonly="readonly"
						value="<s:date name="#session.modify_books.loandate" format="yyyy-MM-dd"/>" />
					</td>
				</tr>
				<tr>
					<td>所剩数目：</td>
					<td><input type="text" name="total"
						value='<s:property value="#session.modify_books.total"/>' /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input class="button"
						type="submit" value="修改"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>