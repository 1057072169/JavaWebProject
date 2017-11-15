package action;

import java.text.SimpleDateFormat;
import java.util.List;

import service.BooksDAO;
import service.impl.BooksDAOImpl;
import entity.Books;

public class BooksAction extends SuperAction {
	private static final long serialVersionUID = 1L;

	// 查询所有书籍
	public String query() {
		BooksDAO sdao = new BooksDAOImpl();
		List<Books> list = sdao.queryAllBooks();
		// 放进session中
		if (list != null && list.size() > 0) {
			session.setAttribute("books_list", list);// !!!!
		}
		return "query_success";
	}

	// 删除书籍
	public String delete() {
		BooksDAO sdao = new BooksDAOImpl();
		String sid = request.getParameter("sid");
		sdao.deleteBook(sid);// 调用删除方法
		return "delete_success";
	}

	// 添加书籍
	public String add() throws Exception {
		Books s = new Books();
		// 获得学生姓名
		s.setSname(request.getParameter("sname"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 判断管理员输入的日期是否为空
		// 不为空则继续后面的工作，为空则跳转到添加书籍失败界面
		if (request.getParameter("loandate") != "") {
			s.setLoandate(sdf.parse(request.getParameter("loandate")));
			s.setTotal(request.getParameter("total"));
			BooksDAO sdao = new BooksDAOImpl();
			sdao.addBooks(s);
			return "add_success";
		} else {
			return "add_failure";
		}

	}

	// 修改书籍
	public String modify() {
		// 获取学生编号
		String sid = request.getParameter("sid");
		BooksDAO sdao = new BooksDAOImpl();
		Books s = sdao.queryBooksBySid(sid);
		// 保存在会话中
		session.setAttribute("modify_books", s);// !!!!!
		return "modify_success";
	}

	// 保存修改后的书籍资料动作
	public String save() throws Exception {
		Books s = new Books();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 判断管理员输入的日期是否为空
		// 不为空则继续后面的工作，为空则跳转到添加书籍失败界面
		if (request.getParameter("loandate") != "") {
			s.setLoandate(sdf.parse(request.getParameter("loandate")));
			s.setTotal(request.getParameter("total"));// !!!
			BooksDAO sdao = new BooksDAOImpl();
			sdao.updateBook(s);
			return "save_success";
		} else {
			return "modify";
		}

	}
}
