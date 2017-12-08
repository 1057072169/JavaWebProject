package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Users;
import service.UsersDAO;
import util.MyHibernateSessionFactory;

/**
 * @ClassName: UsersDAOImpl.java
 * @Description: 用户业务逻辑接口实现类
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年11月14日 下午8:37:10
 */
public class UsersDAOImpl implements UsersDAO {
	/**
	 * 用户登录方法
	 */
	@Override
	public boolean usersLogin(Users u) {
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where username=? and password=? ";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			tx.commit();
			if (list.size() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

}
