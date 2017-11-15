package service.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import db.MyHibernateSessionFactory;
import entity.Books;
import service.BooksDAO;

/**
 * @ClassName: BooksDAOImpl.java
 * @Description: 书籍业务逻辑接口实现类
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年11月14日 下午8:34:05
 */
public class BooksDAOImpl implements BooksDAO {
	/**
	 * 查询所有书籍资料
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Books> queryAllBooks() {
		Transaction tx = null;
		List<Books> list = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Books";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return list;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	/**
	 * 根据书籍编号查询书籍资料
	 */
	@Override
	public Books queryBooksBySid(String sid) {
		Transaction tx = null;
		Books s = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			s = (Books) session.get(Books.class, sid);
			tx.commit();
			return s;
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return s;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	/**
	 * 添加书籍资料
	 */
	@Override
	public boolean addBooks(Books s) {
		// 设置学生学号为getNewSid()生成的学号
		s.setSid(getNewSid());
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	/**
	 * 修改书籍资料
	 */
	@Override
	public boolean updateBook(Books s) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	/**
	 * 删除书籍资料
	 */
	@Override
	public boolean deleteBook(String sid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			Books s = (Books) session.get(Books.class, sid);
			session.delete(s);
			tx.commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	/**
	 * 生成书籍编号的方法
	 * 
	 * @return 书籍号
	 */
	private String getNewSid() {
		Transaction tx = null;
		String hql = "";
		String sid = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			// 获得当前学生的最大编号
			hql = "select max(sid) from Books";
			Query query = session.createQuery(hql);
			sid = (String) query.uniqueResult();
			if (sid == null || "".equals(sid)) {
				// 给一个默认的最大编号
				sid = "B0000001";
			} else {
				// 取后7位
				String temp = sid.substring(1);
				// 转成数字
				int i = Integer.parseInt(temp);
				i++;
				// 还原成字符串
				temp = String.valueOf(i);
				int len = temp.length();
				// 凑够7位
				for (int j = 0; j < 7 - len; j++) {
					temp = "0" + temp;
				}
				sid = "B" + temp;
			}
			tx.commit();
			return sid;
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

}
