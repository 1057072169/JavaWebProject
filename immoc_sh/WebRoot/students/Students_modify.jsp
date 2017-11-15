<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;学生管理<span>&nbsp;
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="<%=path%>/students/Students_query.action">学生列表</a><span>&nbsp;
	</div>
</div>
<div id="tips">
</div>
<div id="mainContainer">
<!-- 从session中获取学生集合 -->
<strong>修改学生资料</strong>
<br>
<br>

<form name="modifyForm" action="<%=path%>/students/Students_save.action" method="post">
<table width="400" >
  <tr>
    <td width="30%">学号：</td>
    <td><input type="text" name="sid" value='<s:property value="#session.modify_students.sid"/>'  readonly="readonly"/></td>
  </tr>
  <tr>
    <td width="30%">姓名：</td>
    <td><input type="text" name="sname" value='<s:property value="#session.modify_students.sname"/>'/></td>
  </tr>
  <tr>
    <td>联系方式：</td>
      <td><input type="text" name="gender" /></td>
  </tr>
  <tr>
    <td>借书日期：</td>
    <td><input name="birthday" type="text" id="control_date" size="20"
      maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" 
      value="<s:date name="#session.modify_students.birthday" format="yyyy-MM-dd"/>"
      />
    </td>
  </tr>
  <tr>
    <td>借入书籍编号：</td>
    <td><input type="text" name="address" value='<s:property value="#session.modify_students.address"/>'/></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="修改"></td>
  </tr>
</table>
</form>


</div>
</body>
</html>