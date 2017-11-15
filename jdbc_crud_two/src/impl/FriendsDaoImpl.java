package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.FriendsDao;
import entity.Friends;

/**
 * @ClassName: FriendsDaoImpl.java
 * @Description: 实现了FriendsDao接口中添加，删除，更新，查找，获得所有小伙伴的方法
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年11月13日 下午12:26:49
 */
public class FriendsDaoImpl extends BaseDao implements FriendsDao {

	Connection conn = null;
	// 预编译的SQL语句对象
	// 一个SQL语句被预先编译并存储在PreparedStatement对象中。然后可以使用该对象多次有效地执行该语句。
	PreparedStatement pstmt = null;
	// 表示数据库结果集的数据表，通常是通过执行查询数据库的语句生成的。
	ResultSet rs = null;

	/**
	 * 添加小伙伴
	 */
	@Override
	public int addFriends(Friends f) {
		int num = 0;
		String sql = "insert into jdbc_crud_two(name,age,phonenum,date,favorite) values(?,?,?,?,?)";
		try {
			num = executeUpdate(sql, f.getName(), f.getAge(), f.getPhonenum(),
					f.getDate(), f.getFavorite());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	/**
	 * 删除小伙伴
	 */
	@Override
	public int delFriends(int id) {
		int num = 0;
		String sql = "delete from jdbc_crud_two where id=?";
		try {
			num = executeUpdate(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	/**
	 * 修改小伙伴信息
	 */
	@Override
	public int updateFriends(Friends f) {
		int num = 0;
		String sql = "update jdbc_crud_two set name=?,age=?,phonenum=?,date=?,favorite=?  where id=?";
		try {
			num = executeUpdate(sql, f.getName(), f.getAge(), f.getPhonenum(),
					f.getDate(), f.getFavorite());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	/**
	 * 根据id找小伙伴
	 */
	@Override
	public Friends findUserById(int id) {
		Friends f = null;
		String sql = "select * from jdbc_crud_two where id=?";
		rs = executeQuery(sql, id);
		try {
			if (rs.next()) {
				f = new Friends(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getString(4), rs.getDate(5), rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	/**
	 * 获取所有小伙伴
	 */
	@Override
	public List<Friends> getAllFriends() {
		List<Friends> ulist = new ArrayList<Friends>();
		String sql = "select * from jdbc_crud_two";
		rs = executeQuery(sql);
		try {
			while (rs.next()) {
				Friends f = new Friends(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getString(4), rs.getDate(5),
						rs.getString(6));
				ulist.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ulist;
	}

}