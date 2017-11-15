package service;

import java.util.List;

import entity.Books;

/**
 * @ClassName: BooksDAO.java
 * @Description: 书籍业务逻辑接口
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年11月14日 下午8:19:19
 */
public interface BooksDAO {
	//查询所有书籍资料
	public List<Books> queryAllBooks();

	// 根据书籍编号查询书籍资料
	public Books queryBooksBySid(String sid);

	// 添加书籍资料
	public boolean addBooks(Books s);

	// 修改书籍资料
	public boolean updateBook(Books s);

	//删除书籍资料
	public boolean deleteBook(String sid);

}
