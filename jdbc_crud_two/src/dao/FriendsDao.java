package dao;

import java.util.List;

import entity.Friends;

/**
 * 
 * @ClassName: UsersDao.java
 * @Description: 作为接口定义了添加，删除，更新，查找，获得所有小伙伴的方法
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年11月6日 下午12:02:18
 */
public interface FriendsDao {
	public int addFriends(Friends u);

	public int delFriends(int id);

	public int updateFriends(Friends u);

	public Friends findUserById(int id);

	public List<Friends> getAllFriends();
}