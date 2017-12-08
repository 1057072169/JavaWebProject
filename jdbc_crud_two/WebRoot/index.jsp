<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Friends"%>
<%@ page import="impl.FriendsDaoImpl"%>
<%@ page import="dao.FriendsDao"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//下面的语句初始为初始化页面，如果不加下面语句访问主页不会显示数据库中保存的数据
	FriendsDao ud = new FriendsDaoImpl();
	List<Friends> ulist = ud.getAllFriends();
	session.setAttribute("ulist", ulist);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/foundation/5.5.3/css/foundation.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/foundation/5.5.3/js/foundation.min.js"></script>
<script
	src="https://cdn.bootcss.com/foundation/5.5.3/js/vendor/modernizr.js"></script>
<style type="text/css">
table {
	margin: auto;
}

td {
	text-align: center;
}

h1 {
	margin-left: 40%;
}

a#add {
	margin-left: 45%;
}
</style>
</head>
<body style="padding:20px;">
	<h1>通讯录主页</h1>
	<a id="add" href="add.jsp">新增小伙伴</a>
	<table>
		<thead>
			<tr>
				<th>序号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>电话</th>
				<th>生日</th>
				<th>爱好</th>
				<th>操作</th>
			</tr>
		</thead>
		<%--<c:forEach/>标签遍历List--%>
		<c:forEach items="${ulist}" var="friend">
			<tbody>
				<tr>
					<td>${friend.id }</td>
					<td>${friend.name }</td>
					<td>${friend.age }</td>
					<td>${friend.phonenum }</td>
					<td>${friend.date }</td>
					<td>${friend.favorite }</td>
					<td><a href="servletfriends?do=editbefore&id=${friend.id }">修改</a>
						<a href="servletfriends?do=del&id=${friend.id }"
						onclick="javascript:return confirm('确认删除吗？');">删除</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>