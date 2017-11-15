package servlet;

import impl.FriendsDaoImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FriendsDao;
import entity.Friends;

public class ServletFriends extends HttpServlet {

	private static final long serialVersionUID = 1L;
  //doGet()也执行doPost()方法
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//创建session对象，用于保存返回给客户端的数据
		HttpSession session = request.getSession();
		//创建输出对象，用于输出
		PrintWriter out = response.getWriter();

		FriendsDao ud = new FriendsDaoImpl();
		// 获得do属性
		String dos = request.getParameter("do");
		if (dos == null || dos.equals("")) {
			dos = "index";
		}
		// 主页
		if (dos.equals("index")) {
			List<Friends> ulist = ud.getAllFriends();
			session.setAttribute("ulist", ulist);
			response.sendRedirect("index.jsp");
			return;
		}
		if (dos.equals("add")) {

			try {
				//名字获取
				String name = request.getParameter("name");
				//年龄获取
				String ages = request.getParameter("age");
				int age = Integer.parseInt(ages);
				//电话号码获取
				String phonenum = request.getParameter("phonenum");
				//生日获取
				String dates = request.getParameter("date");
				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
				Date date;
				date = (Date) sdf.parse(dates);
				//爱好获取
				String favorite = request.getParameter("favorite");
				//带参数的构造方法创建一个Friends对象
				Friends u = new Friends(0, name, age, phonenum, date, favorite);
				//调用addFriends()方法把创建的对象u添加到数据库
				ud.addFriends(u);
				// 添加成功并跳转页面
				out.print("<script>alert('新增成功！');window.location='servletfriends?do=index';</script>");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (dos.equals("del")) {
			String ids = request.getParameter("id");
			int id = Integer.parseInt(ids);
			ud.delFriends(id);
			out.print("<script>alert('删除成功！');window.location='servletfriends?do=index';</script>");
			return;
		}
		if (dos.equals("editbefore")) {
			String ids = request.getParameter("id");
			int id = Integer.parseInt(ids);
			Friends f = ud.findUserById(id);
			session.setAttribute("edituser", f);
			response.sendRedirect("edit.jsp");
			return;
		}
		if (dos.equals("edit")) {

			try {
				String name = request.getParameter("name");
				String ages = request.getParameter("age");
				int age = Integer.parseInt(ages);
				String phonenum = request.getParameter("phonenum");
				String date1 = request.getParameter("date");
				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
				Date date;
				date = (Date) sdf.parse(date1); // java.sql.Date
				String favorite = request.getParameter("favorite");
				Friends f = new Friends(0, name, age, phonenum, date, favorite);
				ud.updateFriends(f);
				out.print("<script>alert('修改成功！');window.location='servletfriends?do=index';</script>");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return;
		}
	}
}