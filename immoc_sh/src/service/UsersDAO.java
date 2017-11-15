package service;

import entity.Users;
/**
 * @ClassName: UsersDAO.java
 * @Description: 用户业务逻辑接口
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年11月14日 下午8:27:51
 */
public interface UsersDAO {
	//用户登录方法
	public boolean usersLogin(Users u);
}
